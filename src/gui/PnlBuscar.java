/**
 * Panel que permite mostrar un mensaje de aviso antes de empexar la busqueda en al sección de buscar por carnet
 * 
 * Creado el 11 de Septiembre del 2022, 10:30 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */
package gui;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

public class PnlBuscar extends JPanel{
    private JLabel nota;
    private JPanel contNota;
   
    /**
    * constructor permite relizar todas las instancias necesarias para mostrar panel mensaje antes de realizar las busquedas
    */
    public PnlBuscar(){
       setSize(1200, 700);
       setLayout(new BorderLayout());
       setOpaque(false);
       nota= new JLabel("Recuerde que para buscar se debe introducir el carnet");
       nota.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 35));
       nota.setForeground(Color.BLACK);
       contNota= new JPanel(new FlowLayout(FlowLayout.CENTER,0,250));
       contNota.setBackground(new Color(225,225,225,220));
       ImageIcon imagenBuscar= new ImageIcon(PnlBuscar.class.getResource("/Img/buscar.png"));
       nota.setIcon(new ImageIcon(imagenBuscar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
       contNota.add(nota);
       add(contNota,BorderLayout.CENTER);
    }

    public JLabel getNota() {
       return nota;
    }

    public void setNota(JLabel nota) {
       this.nota = nota;
    }

    public JPanel getContNota() {
       return contNota;
    }

    public void setContNota(JPanel contNota) {
       this.contNota = contNota;
    }
   
}
