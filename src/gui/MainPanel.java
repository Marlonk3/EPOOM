/**
 * La clase mainPanel realiza la creación del panel principal de opciones para la elección de gestion entre pacientes y medicos del hospital "Paciente Feliz"  
 * 
 * Creado el 31 de Agosto del 2022, 15:30 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * 
 * @version POO - 2022
 */


package gui;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class MainPanel extends JPanel {
   private PanelImgBackground fondoLogo= new PanelImgBackground("/Img/LogoMain.gif");
   private PanelImgBackground panelFondoMain =new PanelImgBackground("/Img/BackgroundMain.jpg");
   private JPanel panelEast, panelMedico, panelPaciente;
   private JLabel imgMedicoJLabel, imgPacienteJLabel;
   private JButton btnMedico, btnPaciente;
   
   
   /**
    * Constructor inicia los componentes necesarios para la creación del mainPanel
    */
   public MainPanel (){
	   
	   initComponets();
      
   }
   /**
    * Realiza las instancias necesarias para poner en marcha cada componenete que debe formar parte del JPanel - mainPanel
    */
   private void initComponets(){
	   
	   //setSize(900, 500);
	   setLayout(new BorderLayout());
	   add(panelFondoMain, BorderLayout.CENTER);
	   panelFondoMain.setLayout(new GridLayout(0,2));
	   panelFondoMain.add(fondoLogo);
	   panelEast= new JPanel (new GridLayout(2,0));
	   panelEast.setOpaque(false);
	   ImageIcon imagenMedico= new ImageIcon(MainPanel.class.getResource("/Img/MedicoLogo.png"));
	   
	   imgMedicoJLabel = new JLabel();
	   imgMedicoJLabel.setBounds(0, 0, 150, 150);
	   imgMedicoJLabel.setIcon(new ImageIcon(imagenMedico.getImage().getScaledInstance(imgMedicoJLabel.getWidth(), imgMedicoJLabel.getHeight(), Image.SCALE_SMOOTH)));
	   panelMedico= new JPanel(new FlowLayout(FlowLayout.CENTER,20,70));
	   btnMedico= new JButton("  Médicos  ");
	   
	   btnMedico.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
	   btnMedico.setBackground(Color.white);
	   btnMedico.setBorder(BorderFactory.createLineBorder(Color.black,3,true));
	   
	   panelMedico.add(imgMedicoJLabel);
	   panelMedico.add(btnMedico);
	   panelMedico.setOpaque(false);
	   
	   btnPaciente= new JButton(" Pacientes ");
	   btnPaciente.setBackground(Color.white);
	   btnPaciente.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
	   btnPaciente.setBorder(BorderFactory.createLineBorder(Color.black,3,true));
	   
	   panelPaciente = new JPanel(new FlowLayout(FlowLayout.CENTER,20,70));
	   panelPaciente.setOpaque(false);
	   imgPacienteJLabel= new JLabel();
	   imgPacienteJLabel.setBounds(0,0,150,150);
	   ImageIcon imagenPaciente= new ImageIcon(MainPanel.class.getResource("/Img/PacienteLogo.png"));
	   imgPacienteJLabel.setIcon(new ImageIcon(imagenPaciente.getImage().getScaledInstance(imgPacienteJLabel.getWidth(), imgPacienteJLabel.getHeight(), Image.SCALE_SMOOTH)));
	   
	   panelPaciente.add(imgPacienteJLabel);
	   panelPaciente.add(btnPaciente);
	   
	   
	   panelEast.add(panelMedico);
	   panelEast.add(panelPaciente);
	   panelFondoMain.add(panelEast); 
   }
   
   /**
    * Metodo get permite devolver el valor de btnMedico que es de tipo JButton
    * @return JButton 
    */
   public JButton getBtnMedico() {
	   return btnMedico;
   }
   /**
    * Metodo get permite devolver el valor de btnPaciente que es de tipo JButton
    * @return JButton
    */
   public JButton getBtnPaciente() {
	   return btnPaciente;
   }
   
}
