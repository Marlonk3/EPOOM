/**
 * Realiza la creación de un JPanel con un background de tipo imagen para ser instanciado en otras clases, el constructor recibe como parametro la imagen a usar como background
 * 
 * Creado el 31 de Agosto del 2022, 15:30 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 */
package gui;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImgBackground extends JPanel {
    private String Img;
    private Image logoPrincipalImg;

    /**
     * constructor da valor a la variable Img de tipo String para luego ser usada en
     * la funcón heredada paint
     * 
     * @param Img String - imagen a ser usada como background
     */
    public PanelImgBackground(String Img) {
        this.Img = Img;
    }

    /**
     * Funcion heredada paint del paqute java.awt.Graphics permite colocar imagen
     * como background en los JPanel
     * 
     * @param g Graphics
     */
    @Override
    public void paint(Graphics g) {
        logoPrincipalImg = new ImageIcon(getClass().getResource(Img)).getImage();
        g.drawImage(logoPrincipalImg, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
