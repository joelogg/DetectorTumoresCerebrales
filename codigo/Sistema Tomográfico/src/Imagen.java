
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
class Imagen {
    
    int anchoImagen;
    int altoImagen;
    BufferedImage imagen;
    ImageIcon imagenIcono;
    Icon icono;
    
    Imagen(){
        this.anchoImagen = 0;
        this.altoImagen = 0;
        this.imagen = null;
        this.imagenIcono = null;
        this.icono = null;
    }
    
    Imagen (int ancho, int alto){
        this.anchoImagen = ancho;
        this.altoImagen = alto;
    }

    public void visualizarImagen(JLabel imagenOriginal) 
    {
        imagenIcono = new ImageIcon(this.imagen);
        anchoImagen = imagenOriginal.getWidth();
        altoImagen = imagenOriginal.getHeight();
        
        icono = new ImageIcon(imagenIcono.getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT));
        imagenOriginal.setText(null);
        imagenOriginal.setIcon(icono);
    }

    public BufferedImage agregarImagen(JLabel imagenOriginalR) {
        VentanaImagen ventana = new VentanaImagen();
        this.imagen = ventana.subirImagen(imagenOriginalR);
        
        return imagen;
    }

    public void procesarImagenes() 
    {
        leerImagenes();
    }

    private void leerImagenes() {
                                                     
        String directorioOrigen = "C:\\Users\\Joel Gallegos\\Desktop\\cerebro\\Gliomas Normalizados";
        String directorioDestino = "C:\\Users\\Joel Gallegos\\Desktop\\cerebro\\Glioma Posible Tumor";
        
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
                    anchoN=ancho*altoN/alto;
                    
                                    
                    BufferedImage dimg = new BufferedImage(anchoN, altoN, imagen.getType());  
                    Graphics2D g = dimg.createGraphics();  
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
                    g.drawImage(imagen, 0, 0, anchoN, altoN, 0, 0, ancho, alto, null);  
                    //g.dispose();  
                    dimg = convertir(dimg);
                    ImageIO.write(dimg, "jpg", new File(directorioDestino + "\\"+nombreArchivo));
                   
                } 
                catch (IOException ex) 
                { 
                    System.out.println("Error de lectura"); 
                }
            }
        }
       
    }

    private BufferedImage convertir(BufferedImage imagen) {
        // ESCALA DE GRISES
        BufferedImage img = null;
        PreProcesamientoImagen imagenes = new PreProcesamientoImagen();
        img = imagenes.preProcesar(imagen);
        
        return img;
    }
    
    
}
