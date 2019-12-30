package com.rubaanxd.swing;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Fondo Swing
 * Clase con metodos para trabajar con fondos y bordes en componentes Swing
 * <p>
 *  
 * @author RubaanxD
 * @version 1.0
 * @since 2019
 */
public class FondoSwing implements Border {

    private BufferedImage mImagen = null;

    /**
     * Constructor, indicamos la imagen que queremos que se redimensione
     *
     * @param ruta ruta de la imagen
     * @throws java.io.IOException
     */
    public FondoSwing(String ruta) throws IOException {
        mImagen = ImageIO.read(new File(ruta));
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    public void setBorder(JFrame frame) {
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setBorder(this);
    }

    public void setBorder(JDialog frame) {
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setBorder(this);
    }

}
