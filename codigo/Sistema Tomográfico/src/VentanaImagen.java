
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template archivo, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAURA
 */
public class VentanaImagen extends javax.swing.JFrame {

    BufferedImage imagenOriginal;
    FileNameExtensionFilter filtro;
    ImageIcon icon;
    File archivo;
    Icon icono;
    
    int resultado;
    int anchoImg;
    int altoImg;
    
    public VentanaImagen() {
        initComponents();
        imagenOriginal = null;
        filtro = new FileNameExtensionFilter("JPG, PNG Y GIF","jpg","gif","png"); // Creando filtro
        archivo = null;
        icon = null;
        icono = null;
        
        resultado = 0;
        anchoImg = 0;
        altoImg = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seleccionImagen = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seleccionImagen.setCurrentDirectory(new java.io.File("C:\\Users\\Joel Gallegos\\Desktop\\cerebro"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seleccionImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccionImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaImagen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser seleccionImagen;
    // End of variables declaration//GEN-END:variables

    BufferedImage subirImagen(JLabel imagenOriginalR) {
         
        VentanaImagen imagen = new VentanaImagen(); //Creando un objeto de la clase SubirImagen.
        imagen.seleccionImagen.setFileFilter(filtro); 
        resultado = imagen.seleccionImagen.showOpenDialog(null);
        
        anchoImg = imagenOriginalR.getWidth();
        altoImg = imagenOriginalR.getHeight();
        
        if (JFileChooser.APPROVE_OPTION == resultado)
        {
            archivo = imagen.seleccionImagen.getSelectedFile();

            try
            {
                imagenOriginal = ImageIO.read(archivo);
                icon = new ImageIcon(archivo.toString());
                icono = new ImageIcon(icon.getImage().getScaledInstance(anchoImg, altoImg, Image.SCALE_DEFAULT));

               imagenOriginalR.setText(null);
               imagenOriginalR.setIcon( icono );
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }

        }
    return imagenOriginal;
    }
}
