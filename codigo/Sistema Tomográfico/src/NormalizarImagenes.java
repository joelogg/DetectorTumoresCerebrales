
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAURA
 */
class NormalizarImagenes {
    
    int anchoImagen;
    int altoImagen;
    BufferedImage imagen;
    ImageIcon imagenIcono;
    Icon icono;
    
    NormalizarImagenes(){
        this.anchoImagen = 0;
        this.altoImagen = 0;
        this.imagen = null;
        this.imagenIcono = null;
        this.icono = null;
    }
    
    NormalizarImagenes (int ancho, int alto){
        this.anchoImagen = ancho;
        this.altoImagen = alto;
    }
    
    public void normalizar() 
    {
        leerImagenes();
    }

    private void leerImagenes() {
                                                     
        String directorioOrigen = "C:\\Users\\Joel Gallegos\\Desktop\\cerebro\\Gliomas";
        String directorioDestino = "C:\\Users\\Joel Gallegos\\Desktop\\cerebro\\Gliomas Normalizados";
        
        File archivos = new File(directorioOrigen);
        if (archivos.exists())
        { // Directorio existe 
            File[] ficheros = archivos.listFiles();
            String nombreArchivo; 
            int ancho, alto, altoN, anchoN;
            
            for (int x=0;x<ficheros.length;x++)
            {
                nombreArchivo = ficheros[x].getName();
                System.out.println(nombreArchivo);
                
                try 
                {
                    // Se carga la imagen original
                    BufferedImage imagen;
                    File f = new File(directorioOrigen+"\\"+nombreArchivo);
                    imagen = ImageIO.read(f);
                    
                    //redimensionar
                    ancho = imagen.getWidth();
                    alto = imagen.getHeight();                    
                    
                    altoN=300;
                    //anchoN=ancho*altoN/alto;
                    anchoN=300;
                    
                                    
                    BufferedImage dimg = new BufferedImage(anchoN, altoN, imagen.getType());  
                    Graphics2D g = dimg.createGraphics();  
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
                    g.drawImage(imagen, 0, 0, anchoN, altoN, 0, 0, ancho, alto, null);  
                    //g.dispose();  
                    
                    ImageIO.write(dimg, "jpg", new File(directorioDestino + "\\"+nombreArchivo));
                   
                } 
                catch (IOException ex) 
                { 
                    System.out.println("Error de lectura"); 
                }
            }
        }
       
    }
}
