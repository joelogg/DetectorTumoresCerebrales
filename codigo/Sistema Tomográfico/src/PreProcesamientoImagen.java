
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
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
class PreProcesamientoImagen {
    
    BufferedImage imgGris;
    BufferedImage imgMenorRuido;
    BufferedImage imgBinarizada;
    BufferedImage imgContorno;
    BufferedImage imgMascaraCerebro;
    BufferedImage imgCaracteristicas;
    Color colorImagen;
    int anchoImagen;
    int altoImagen;
    int tipoImagen;
    int anchoEtiqueta;
    int altoEtiqueta;
    int gris;
    int colorRojo;
    int colorAzul;
    int colorVerde;
    
    PreProcesamientoImagen(){
        this.imgGris = null;
        this.imgMenorRuido = null;
        this.imgBinarizada = null;
        this.imgContorno = null;
        this.imgMascaraCerebro = null;
        this.imgCaracteristicas = null;
        this.colorImagen = null;
        this.anchoImagen = 0;
        this.altoImagen = 0;
        this.tipoImagen = 0;
        this.anchoEtiqueta = 0;
        this.altoEtiqueta = 0;
        this.gris = 0;
        this.colorRojo = 0;
        this.colorVerde = 0;
        this.colorAzul = 0;
    }

    private BufferedImage convertirEscalaGris(BufferedImage imagen) {
        BufferedImage imgGrisCopia = null;
        
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgGrisCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            
            for(int i = 0; i < anchoImagen; i++) 
            {
                for (int j = 0; j < (altoImagen); j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    colorRojo = colorImagen.getRed();
                    colorVerde = colorImagen.getGreen();
                    colorAzul = colorImagen.getBlue();
                    
                    gris =(int) ((colorRojo + colorVerde + colorAzul)/3); 
                    colorImagen = new Color(gris, gris, gris, colorImagen.getAlpha());
                    imgGrisCopia.setRGB(i, j, colorImagen.getRGB());
                }
            }
        }
        
        return imgGrisCopia;
        
    }

    private BufferedImage ajustarIntensidadPixel(BufferedImage imagen) {
        
           BufferedImage imgMenorRuidoCopia = null;
           
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgMenorRuidoCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int color, pc1, pc2, pc3, pc4, pc5, pc6, pc7, pc8, promedio;
            Color p1, p2, p3, p4, p5, p6, p7, p8;
            int pc9, pc10, pc11, pc12, pc13,    pc14, pc15, pc16, pc17, pc18, pc19,    pc20, pc21, pc22, pc23, pc24;
            Color p9, p10, p11, p12, p13,    p14, p15, p16, p17, p18, p19,    p20, p21, p22, p23, p24;
            
            for(int i = 2; i < anchoImagen-2; i++) 
            {
                for (int j = 2; j < altoImagen-2; j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    p1 = new Color(imagen.getRGB(i-1, j-1));
                    pc1 = p1.getRed();
                    p2 = new Color(imagen.getRGB(i-1, j));
                    pc2 = p2.getRed();
                    p3 = new Color(imagen.getRGB(i-1, j+1));
                    pc3 = p3.getRed();
                    p4 = new Color(imagen.getRGB(i-1, j));
                    pc4 = p4.getRed();
                    p5 = new Color(imagen.getRGB(i+1, j));
                    pc5 = p5.getRed();
                    p6 = new Color(imagen.getRGB(i-1, j+1));
                    pc6 = p6.getRed();
                    p7 = new Color(imagen.getRGB(i, j+1));
                    pc7 = p7.getRed();
                    p8 = new Color(imagen.getRGB(i+1, j+1));
                    pc8 = p8.getRed();
                    
                    p9 = new Color(imagen.getRGB(i-2, j-2));
                    pc9 = p9.getRed();
                    p10 = new Color(imagen.getRGB(i-1, j-2));
                    pc10 = p10.getRed();
                    p11 = new Color(imagen.getRGB(i, j-2));
                    pc11 = p11.getRed();
                    p12 = new Color(imagen.getRGB(i+1, j-2));
                    pc12 = p12.getRed();
                    p13 = new Color(imagen.getRGB(i+2, j-2));
                    pc13 = p13.getRed();
                    p14 = new Color(imagen.getRGB(i-2, j-1));
                    pc14 = p14.getRed();
                    p15 = new Color(imagen.getRGB(i-2, j));
                    pc15 = p15.getRed();
                    p16 = new Color(imagen.getRGB(i-2, j+1));
                    pc16 = p16.getRed();
                    p17 = new Color(imagen.getRGB(i+2, j-1));
                    pc17 = p17.getRed();
                    p18 = new Color(imagen.getRGB(i+2, j));
                    pc18 = p18.getRed();
                    p19 = new Color(imagen.getRGB(i+2, j+1));
                    pc19 = p19.getRed();
                    p20 = new Color(imagen.getRGB(i-2, j+2));
                    pc20 = p20.getRed();
                    p21 = new Color(imagen.getRGB(i-1, j+2));
                    pc21 = p21.getRed();
                    p22 = new Color(imagen.getRGB(i, j+2));
                    pc22 = p22.getRed();
                    p23 = new Color(imagen.getRGB(i+1, j+2));
                    pc23 = p23.getRed();
                    p24 = new Color(imagen.getRGB(i+2, j+2));
                    pc24 = p24.getRed();
                    
                    //promedio = (int)((pc1+pc2+pc3+pc4+pc5+pc6+pc7+pc8)/8);
                    promedio = (int)((pc1+pc2+pc3+pc4+pc5+pc6+pc7+pc8+pc9+pc10+
                            pc11+pc12+pc13+pc14+pc15+pc16+pc17+pc18+pc19+pc20+
                            pc21+pc22+pc23+pc24)/24);
                    colorImagen = new Color(promedio, promedio, promedio, colorImagen.getAlpha());
                    
                   
                    
                    
                    imgMenorRuidoCopia.setRGB(i, j, colorImagen.getRGB());
                }
            }
        }
        
        return intensidadPixelNegro(imgMenorRuidoCopia);
    }

private int encontrarUmbralNBinarizacion(BufferedImage imagen) 
    {
        int histograma [] = histograma(imagen);
        int umbral, posMax=0, puntoMasAlto=0, posPuntoMasAlto=0;
       
        for(int i=255; i>=0; i--)
        {
            if(histograma[i]>50)
            {
                posMax=i;
                break;
            }
        }
        for(int i=0; i<256; i++)
        {
            if(histograma[i]>50)
            {
                if(histograma[i]>puntoMasAlto)
                {
                    puntoMasAlto = histograma[i];
                    posPuntoMasAlto = i;
                }
            }
        }
        
        //System.out.println("Posicion punto más alto: "+ posPuntoMasAlto+ " Max: "+posMax+" Promedio: "+(posPuntoMasAlto+posMax)/2);
        
        umbral=(int)((posPuntoMasAlto+posMax)/2);
        return umbral;
    }

private BufferedImage binarizar(BufferedImage imagen) {
            
           BufferedImage imgBinarizadaCopia = null;
           
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgBinarizadaCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int colorR, colorB;           
            
            int umbral = encontrarUmbralNBinarizacion(imagen);
            
            
            System.out.println("Nuevo Umbral " + umbral);
            for(int i = 0; i < anchoImagen; i++) 
            {
                for (int j = 0; j < altoImagen; j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    colorR = colorImagen.getRed();
                    colorB = colorImagen.getBlue();
                    
                    if(colorR!=colorB )
                    {
                        colorImagen = new Color(255,0,0, colorImagen.getAlpha());
                    }
                    else if(colorR < umbral)
                    {
                        colorImagen = new Color(0,0,0, colorImagen.getAlpha());
                    }
                    else
                    {
                        colorImagen = new Color(255,255,255, colorImagen.getAlpha());
                    }
                    
               
                    imgBinarizadaCopia.setRGB(i, j, colorImagen.getRGB());
                }
            }      
            
        }
        
        return imgBinarizadaCopia;
    }  

   private BufferedImage obtenerContorno(BufferedImage imagen) {
               BufferedImage imgContornoCopia = null;
           
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgContornoCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int color, pc1, pc2, pc3, pc4, pc5, pc6, pc7, pc8;
            Color p1, p2, p3, p4, p5, p6, p7, p8;
            
            for(int i = 1; i < anchoImagen-1; i++) 
            {
                for (int j = 1; j < altoImagen-1; j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    p1 = new Color(imagen.getRGB(i-1, j-1));
                    pc1 = p1.getRed();
                    p2 = new Color(imagen.getRGB(i-1, j));
                    pc2 = p2.getRed();
                    p3 = new Color(imagen.getRGB(i-1, j+1));
                    pc3 = p3.getRed();
                    p4 = new Color(imagen.getRGB(i-1, j));
                    pc4 = p4.getRed();
                    p5 = new Color(imagen.getRGB(i+1, j));
                    pc5 = p5.getRed();
                    p6 = new Color(imagen.getRGB(i-1, j+1));
                    pc6 = p6.getRed();
                    p7 = new Color(imagen.getRGB(i, j+1));
                    pc7 = p7.getRed();
                    p8 = new Color(imagen.getRGB(i+1, j+1));
                    pc8 = p8.getRed();
                    
                    int r=2;
                    if((Math.abs(pc1-color) < r) && (Math.abs(pc2-color) < r) && (Math.abs(pc3-color) < r) && (Math.abs(pc4-color) < r)
                      &&(Math.abs(pc5-color) < r)&&(Math.abs(pc6-color) < r)&&(Math.abs(pc7-color) < r)&&(Math.abs(pc8-color) < r))
                    {
                        colorImagen = new Color(0,0,0, colorImagen.getAlpha());
                    }
                    else
                    {
                        colorImagen = new Color(255, 255, 255, colorImagen.getAlpha());
                    }
                    
                    imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                }
            }
        }
        
        return imgContornoCopia;
    }
    
    private BufferedImage colocarMascaraRoja(BufferedImage imagen)
    {
        BufferedImage imgContornoCopia = null;
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgContornoCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int color;
            
            for(int i = 0; i < anchoImagen; i++) 
            {
                for (int j = 0; j < altoImagen; j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 0)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                    {
                        
                        break;
                    }
                }
            }
            
            for(int i = anchoImagen-1; i >= 0; i--) 
            {
                for (int j = altoImagen-1; j >= 0; j--) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 0)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                        break;
                }
            }
            
            //---------- COSTADOS--------
             
            for (int j = 0; j < altoImagen; j++) 
            {
                for(int i = 0; i < anchoImagen; i++)
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 0)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                        break;
                }
            }
            
            for (int j = altoImagen-1; j >= 0; j--) 
            {
                for(int i = anchoImagen-1; i >= 0; i--) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 0)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                        break;
                }
            }
            
            
        }
        
        return imgContornoCopia;
    }
    
    
    private BufferedImage obtenerCerebro(BufferedImage imgSinFondo, BufferedImage imgMenorRuido) 
    {
       BufferedImage imgCerebro = null;
        if(imgSinFondo != null ) 
        {
            anchoImagen = imgMenorRuido.getWidth();
            altoImagen = imgMenorRuido.getHeight();
            tipoImagen = imgMenorRuido.getType();
            
            imgCerebro = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int color1, color2;
                        
            for(int i = 0; i < anchoImagen; i++) 
            {
                for (int j = 0; j < altoImagen; j++) 
                {
                    colorImagen = new Color(imgSinFondo.getRGB(i, j));
                    color1 = colorImagen.getRed();
                    color2 = colorImagen.getBlue();
                    
                                      
                    if(color1 != color2)
                    {
                       colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                       imgCerebro.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                    {
                        colorImagen = new Color(imgMenorRuido.getRGB(i, j));
                        imgCerebro.setRGB(i, j, colorImagen.getRGB());
                    }
                }
            }
        }
        
        return imgCerebro;
    }
    
    
    void visualizarImagenEscalaGris(BufferedImage imagenOriginalCopia, JLabel imagen) {
       imgGris = convertirEscalaGris(imagenOriginalCopia);
       colocarImagenEnEiqueta(imgGris, imagen);
       
    }

    void visualizarFiltradoImagen(JLabel imagen) 
    {
        imgMenorRuido = ajustarIntensidadPixel(imgGris); 
        colocarImagenEnEiqueta(imgMenorRuido, imagen);
    }
    
    void visualizarImagenBinarizada(JLabel imagen) {
        imgBinarizada = binarizar(imgMascaraCerebro);
        colocarImagenEnEiqueta(imgBinarizada, imagen);
        
    }
   
    
    void visualizarImagenContorno(JLabel imagen) {
        imgContorno = obtenerContorno(imgMenorRuido);
        colocarImagenEnEiqueta(imgContorno, imagen);

    }
     
    void visualizarCaracteristicas(JLabel imagen) {
        imgCaracteristicas = obtenerCaracteristicas(imgBinarizada, imgMascaraCerebro);
        colocarImagenEnEiqueta(imgCaracteristicas, imagen);

    }
    void visualizarRespuesta(JLabel imagen)
    {        
        colocarImagenEnEiqueta(imgCaracteristicas, imagen);
    }
    void visualizarImagenContorno2(JLabel imagen) {
        BufferedImage imgMascaraR = null;
        imgContorno = obtenerContorno(imgContorno);
        imgMascaraR = colocarMascaraRoja(imgContorno);
        
        imgMascaraR = borrarCorteza(imgMascaraR);
        
        imgMascaraCerebro = obtenerCerebro(imgMascaraR, imgMenorRuido);
        colocarImagenEnEiqueta(imgMascaraCerebro, imagen);
        
    }
    
    public BufferedImage preProcesar(BufferedImage imagen)
    {
        BufferedImage img = null, img1 = null;
        img = convertirEscalaGris(imagen);
        img1 = ajustarIntensidadPixel(img);
        img = obtenerContorno(img1);
        img = obtenerContorno(img);
        img = colocarMascaraRoja(img);
        img = borrarCorteza(img);
        img = obtenerCerebro(img, img1);   
        //img = binarizar(img);
       
        img1 = binarizar(img);
        img = obtenerCaracteristicas(img1,img);
       
        return img;
    }
    
    
    private void colocarImagenEnEiqueta(BufferedImage img, JLabel imagenGrisLabel) {
       ImageIcon imgGris = new ImageIcon(img);
       anchoEtiqueta = imagenGrisLabel.getWidth();
       altoEtiqueta = imagenGrisLabel.getHeight();
       
        Icon icono = new ImageIcon(imgGris.getImage().getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT));
        imagenGrisLabel.setText(null);
        imagenGrisLabel.setIcon(icono);
    }

    private BufferedImage intensidadPixelNegro(BufferedImage imagen) {
        
        BufferedImage imgCopia = null;
           
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int color;
            
            
            for(int i = 0; i < anchoImagen; i++) 
            {
                for (int j = 0; j < altoImagen; j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color < 40)
                    {
                        colorImagen = new Color(0,0,0, colorImagen.getAlpha());
                    }
                    else
                    {
                        colorImagen = new Color(imagen.getRGB(i, j));
                    }
                    
                    imgCopia.setRGB(i, j, colorImagen.getRGB());
                }
            }
        }
        
        return imgCopia;
    }
    
    
    
    
    //______________
        
    /**
     * Devuelve el histograma de la imagen.
     * @param imagen BufferedImagen de la cual se quiere obtener el histograma
     * @return Devuelve una variable int[5][256], donde el primer campo[0] corresponde
     * al canal Rojo, [1]=verde [2]=azul [3]=alfa [4]=escala grises
     */
    public int[] histograma(BufferedImage imagen){
        Color color;
        int suma;
        int histogramaReturn[]=new int[256];
        
        //Recorremos la imagen
        for( int i = 0; i < imagen.getWidth(); i++ ){
            for( int j = 0; j < imagen.getHeight(); j++ ){                
                color=new Color(imagen.getRGB(i, j));    
                if(color.getRed()!=255 && color.getBlue()!=0 && color.getGreen()!=255)
                {
                    suma=histogramaReturn[color.getRed()];
                    suma++;
                    histogramaReturn[color.getRed()]=suma;
                }                
            }
        }
        return histogramaReturn;
    }
    
    void verHistograma(JLabel l) {
        int histograma[]=new int[256];
        histograma = histograma(imgMascaraCerebro);          
        BufferedImage imagen = imgMascaraCerebro;
        BufferedImage imgCopia = null;
           
        if(imagen != null ) 
        {
            tipoImagen = imagen.getType();
            
            imgCopia = new BufferedImage(256, 200, tipoImagen);
            int color, altoAux, maxAlto=1;
            
            for(int i = 0; i < histograma.length; i++) 
            {
                altoAux = histograma[i];
                if(maxAlto<altoAux)
                {
                    maxAlto=altoAux;
                }
            }
            
            for(int i = 0; i < histograma.length; i++) 
            {
                altoAux = (int)((histograma[i]*200)/maxAlto);
                for (int j = 0; j < altoAux; j++) 
                {
                    colorImagen = new Color(255,255,255, colorImagen.getAlpha());
                    imgCopia.setRGB(i, 199-j, colorImagen.getRGB());
                }
                
            }
            
            for (int j = 0; j < 200; j++) 
            {
                colorImagen = new Color(255,0,0, colorImagen.getAlpha());
                imgCopia.setRGB(50, j, colorImagen.getRGB());
                imgCopia.setRGB(100, j, colorImagen.getRGB());
                imgCopia.setRGB(151, j, colorImagen.getRGB());
                imgCopia.setRGB(200, j, colorImagen.getRGB());
                
            }
           
            colocarImagenEnEiqueta(imgCopia, l);  
        }
            
    }
    private BufferedImage obtenerCaracteristicas(BufferedImage imagen, BufferedImage imagenMascaraCerebro) 
    {        
        List< List<Pixel> > posiblesTumores = new LinkedList< List<Pixel>>(); 
        List< List<Pixel> > posiblesTumoresTamanio = new LinkedList< List<Pixel>>(); 
        BufferedImage imgContornoCopia = null;
        
        
        
        anchoImagen = imagen.getWidth();
        altoImagen = imagen.getHeight();
        tipoImagen = imagen.getType();
            
        imgCaracteristicas = imagen;//new BufferedImage(anchoImagen, altoImagen, tipoImagen);
        int colorR, colorG, colorB;
        
        int cantidadPixelesCerebro=0, cantidadPosiblesTumores=0;
        double porcentajeTumor = 0;
        
        //Para contar cuantos pixeles tiene solo el cerebro
        for(int i = 0; i < anchoImagen; i++) 
        {
            for (int j = 0; j < altoImagen; j++) 
            {
                colorImagen = new Color(imagen.getRGB(i, j));
                colorR = colorImagen.getRed();
                colorG = colorImagen.getGreen();                
                    
                if(colorR==colorG)
                {
                    cantidadPixelesCerebro = cantidadPixelesCerebro + 1;                  
                }
            }
        }
        //para extraer en una lista los posibles tumores(todas las secciones blancas)           
        for(int i = 0; i < anchoImagen; i++) 
        {
            for (int j = 0; j < altoImagen; j++) 
            {
                colorImagen = new Color(imagen.getRGB(i, j));
                colorR = colorImagen.getRed();
                colorG = colorImagen.getGreen();
                colorB = colorImagen.getBlue();
                    
                if(colorR==255 && colorG==255 && colorB==255)
                {                    
                    posiblesTumores.add(extraerUnPosibleTumor(i, j));                   
                }
                else
                {
                    colorImagen = new Color(imagen.getRGB(i, j));//colorImagen = new Color(255,255,0, colorImagen.getAlpha());
                    imgCaracteristicas.setRGB(i, j, colorImagen.getRGB());
                }
                
            }
        }
        cantidadPosiblesTumores = posiblesTumores.size();
        System.out.println("Numero de posibles tumores-" + cantidadPosiblesTumores+"-");
        
        //Asigna a otra lista los posibles tumore, pero considerando que sean de tamaño considerable
        for(int i = 0; i < cantidadPosiblesTumores; i++) 
        {
            porcentajeTumor = (posiblesTumores.get(i).size()*100)/cantidadPixelesCerebro;
            if(porcentajeTumor>3)
            {
                posiblesTumoresTamanio.add(posiblesTumores.get(i));                
            }
        }
        System.out.println("Numero de posibles tumores-" + posiblesTumoresTamanio.size()+"-");
        
        //colocamos en la imagen imgCaracteristicas los mismos datos de imgMascaraCerebro
        for(int i = 0; i < anchoImagen; i++) 
        {
            for (int j = 0; j < altoImagen; j++) 
            {
                colorImagen = new Color(imagenMascaraCerebro.getRGB(i, j));
                imgCaracteristicas.setRGB(i, j, colorImagen.getRGB());                                       
             }           
        }
        // en imgCaracteristicas pintamos de amarilo los posibles timores
        for(List<Pixel> t:posiblesTumoresTamanio)
        {
            for(Pixel p:t)
            {
                colorImagen = new Color(255,255,0, colorImagen.getAlpha());
                imgCaracteristicas.setRGB(p.x, p.y, colorImagen.getRGB()); 
            }
        }
         
        return imgCaracteristicas;
    }

    private BufferedImage borrarCorteza(BufferedImage imagen) 
    {
        BufferedImage imgContornoCopia = null;
        if(imagen != null ) 
        {
            anchoImagen = imagen.getWidth();
            altoImagen = imagen.getHeight();
            tipoImagen = imagen.getType();
            
            imgContornoCopia = new BufferedImage(anchoImagen, altoImagen, tipoImagen);
            int color, numPixelBorrar=20;
            
            for(int i = 0; i < anchoImagen; i++) 
            {
                for (int j = 0; j < altoImagen; j++) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 255)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                    {
                        for (int k = 0; k < numPixelBorrar && j+k<altoImagen;k++) 
                        {
                            
                            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                            imgContornoCopia.setRGB(i, j+k, colorImagen.getRGB());
                            
                        }
                        break;
                    }
                }
            }
            
            for(int i = anchoImagen-1; i >= 0; i--) 
            {
                for (int j = altoImagen-1; j >= 0; j--) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 255)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                    {
                        for (int k = 0; k < numPixelBorrar && j-k>=0;k++) 
                        {
                            
                            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                            imgContornoCopia.setRGB(i, j-k, colorImagen.getRGB());
                            
                        }
                        break;
                    }
                }
            }
            
            //---------- COSTADOS--------
             
            for (int j = 0; j < altoImagen; j++) 
            {
                for(int i = 0; i < anchoImagen; i++)
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 255)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                    {
                        for (int k = 0; k < numPixelBorrar && i+k<anchoImagen;k++) 
                        {
                            
                            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                            imgContornoCopia.setRGB(i+k, j, colorImagen.getRGB());
                            
                        }
                        break;
                    }
                }
            }
            
            for (int j = altoImagen-1; j >= 0; j--) 
            {
                for(int i = anchoImagen-1; i >= 0; i--) 
                {
                    colorImagen = new Color(imagen.getRGB(i, j));
                    color = colorImagen.getRed();
                    
                    if(color == 255)
                    {
                        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                        imgContornoCopia.setRGB(i, j, colorImagen.getRGB());
                    }
                    
                    else
                    {
                        for (int k = 0; k < numPixelBorrar && i-k>=0;k++) 
                        {
                            
                            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
                            imgContornoCopia.setRGB(i-k, j, colorImagen.getRGB());
                            
                        }
                        break;
                    }
                }
            }
            
            
        }
        
        return imgContornoCopia;
    }
   
    private List<Pixel> extraerUnPosibleTumor(int i,  int j) 
    {
        List<Pixel> posibleTumor = new LinkedList<Pixel>();        
        
        int colorR, colorG, colorB;
        colorImagen = new Color(imgCaracteristicas.getRGB(i, j));
        colorR = colorImagen.getRed();
        colorG = colorImagen.getGreen();
        colorB = colorImagen.getBlue();
        
        Pixel p1 = new Pixel(i,j,colorR, colorG, colorB);
        posibleTumor.add(p1);
        colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
        imgCaracteristicas.setRGB(i, j, colorImagen.getRGB());
        
        
        buscarArriba(p1, posibleTumor);
        buscarAbajo(p1, posibleTumor);
        buscarIzquierda(p1, posibleTumor);
        buscarDerecha(p1, posibleTumor);
        
        return posibleTumor;
    }

    private void buscarArriba(Pixel pixel, List<Pixel> posibleTumor) 
    {
        if(pixel.y-1<0)
            return;
        
        int colorR, colorG, colorB;
        colorImagen = new Color(imgCaracteristicas.getRGB(pixel.x, pixel.y-1));
        colorR = colorImagen.getRed();
        colorG = colorImagen.getGreen();
        colorB = colorImagen.getBlue();
        
        if(colorR==255 && colorG==255 && colorG==255)
        {
            Pixel p1 = new Pixel(pixel.x,pixel.y-1,colorR, colorG, colorB);
            posibleTumor.add(p1);
            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
            imgCaracteristicas.setRGB(pixel.x, pixel.y-1, colorImagen.getRGB());
            
            buscarArriba(p1, posibleTumor);
            buscarAbajo(p1, posibleTumor);
            buscarIzquierda(p1, posibleTumor);
            buscarDerecha(p1, posibleTumor);            
        }       
    }

    private void buscarAbajo(Pixel pixel, List<Pixel> posibleTumor) 
    {
         if(pixel.y+1>=imgCaracteristicas.getHeight())
            return;
        
        int colorR, colorG, colorB;
        colorImagen = new Color(imgCaracteristicas.getRGB(pixel.x, pixel.y+1));
        colorR = colorImagen.getRed();
        colorG = colorImagen.getGreen();
        colorB = colorImagen.getBlue();
        
        if(colorR==255 && colorG==255 && colorG==255)
        {
            Pixel p1 = new Pixel(pixel.x,pixel.y+1,colorR, colorG, colorB);
            posibleTumor.add(p1);
            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
            imgCaracteristicas.setRGB(pixel.x, pixel.y+1, colorImagen.getRGB());
            
            buscarArriba(p1, posibleTumor);
            buscarAbajo(p1, posibleTumor);
            buscarIzquierda(p1, posibleTumor);
            buscarDerecha(p1, posibleTumor);            
        } 
    }

    private void buscarIzquierda(Pixel pixel, List<Pixel> posibleTumor) 
    {
        if(pixel.x-1<0)
            return;
        
        int colorR, colorG, colorB;
        colorImagen = new Color(imgCaracteristicas.getRGB(pixel.x-1, pixel.y));
        colorR = colorImagen.getRed();
        colorG = colorImagen.getGreen();
        colorB = colorImagen.getBlue();
        
        if(colorR==255 && colorG==255 && colorG==255)
        {
            Pixel p1 = new Pixel(pixel.x-1,pixel.y,colorR, colorG, colorB);
            posibleTumor.add(p1);
            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
            imgCaracteristicas.setRGB(pixel.x-1, pixel.y, colorImagen.getRGB());
            
            buscarArriba(p1, posibleTumor);
            buscarAbajo(p1, posibleTumor);
            buscarIzquierda(p1, posibleTumor);
            buscarDerecha(p1, posibleTumor);            
        }  
    }

    private void buscarDerecha(Pixel pixel, List<Pixel> posibleTumor) 
    {
        if(pixel.x+1>=imgCaracteristicas.getWidth())
            return;
        
        int colorR, colorG, colorB;
        Color colorImagen = new Color(imgCaracteristicas.getRGB(pixel.x+1, pixel.y));
        colorR = colorImagen.getRed();
        colorG = colorImagen.getGreen();
        colorB = colorImagen.getBlue();
        
        if(colorR==255 && colorG==255 && colorG==255)
        {
            Pixel p1 = new Pixel(pixel.x+1,pixel.y,colorR, colorG, colorB);
            posibleTumor.add(p1);
            colorImagen = new Color(255, 0,0, colorImagen.getAlpha());
            imgCaracteristicas.setRGB(pixel.x+1, pixel.y, colorImagen.getRGB());
            
            buscarArriba(p1, posibleTumor);
            buscarAbajo(p1, posibleTumor);
            buscarIzquierda(p1, posibleTumor);
            buscarDerecha(p1, posibleTumor);            
        } 
    }

    

    
    
}
    
    


    
    

