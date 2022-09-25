/**
 * Contiene una extención JPanel con componentes tipo plantilla que permite realizar la creación de un JPanel personalizado para crear la barra superior para distinguir la seccion que se estas consultando
 * 
 * Creado el 31 de Agosto del 2022, 18:30 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TipoSeccionPanel extends JPanel{
	private JPanel barraNorthTipo,panelBotonComeBack;
	private PanelImgBackground imagenFondoPanel;
	private JLabel tituloJLabel;
	private JButton comeBackJButton;
	/**
	 * Constructor por defecto
	 */
	public TipoSeccionPanel() {}
	/**
	 * Constructor que recibe paramentos la imagen que debe ir en el backgorund como el nombre de la sección en la que se encuentra 
	 * @param imgBackground String - La ruta de la imagen
	 * @param nombreSeccion String - Nombre de la sección
	 */
	public TipoSeccionPanel (String imgBackground, String nombreSeccion) {
		initComponets(imgBackground, nombreSeccion);
	}
	/**
	 * Función permite las instancias y agregar componentes a la plantilla de de la barra de sección
	 * @param imgBackground String - La ruta de la imagen
	 * @param nombreSeccion String - Nombre de la sección
	 */
	public void initComponets(String imgBackground, String nombreSeccion) {
		setSize(900, 500);
		imagenFondoPanel=new PanelImgBackground(imgBackground);
		setLayout(new BorderLayout());
		add(imagenFondoPanel, BorderLayout.CENTER);
		imagenFondoPanel.setLayout(new BorderLayout());
		barraNorthTipo = new JPanel(new GridLayout(0,3));
		panelBotonComeBack= new JPanel(new FlowLayout(FlowLayout.LEFT, 30,10));
		panelBotonComeBack.setOpaque(false);
		
		
		barraNorthTipo.setBackground(new Color(0,0,0,130));
		tituloJLabel= new JLabel (nombreSeccion,SwingConstants.CENTER);
		tituloJLabel.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
		tituloJLabel.setForeground(new Color(75,186,186));
		
		
		comeBackJButton= new JButton("Volver");
		comeBackJButton.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,15));
		comeBackJButton.setForeground(tituloJLabel.getForeground());
		comeBackJButton.setBackground(new Color(255,255,255));
		ImageIcon imagenComeBack= new ImageIcon(MainPanel.class.getResource("/Img/Backbutton.png"));
		comeBackJButton.setIcon(new ImageIcon(imagenComeBack.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		
		
		panelBotonComeBack.add(comeBackJButton);
		barraNorthTipo.add(panelBotonComeBack);
		barraNorthTipo.add(tituloJLabel);
		
		
		
		imagenFondoPanel.add(barraNorthTipo,BorderLayout.NORTH);
	}
	/**
	 * Metodo get devuelve el valor de barraNorthTipo
	 * @return JPanel
	 */
	public JPanel getBarraNorthTipo() {
		return barraNorthTipo;
	}
	/**
	 * Metodo set cambia el valor del barraNorthtipo
	 * @param barraNorthTipo JPanel
	 */
	public void setBarraNorthTipo(JPanel barraNorthTipo) {
		this.barraNorthTipo = barraNorthTipo;
	}
	
	/**
	 * Metodo get devuelve el valor del panelBotonComeBack
	 * @return JPanel
	 */
	public JPanel getPanelBotonComeBack() {
		return panelBotonComeBack;
	}
	/**
	 * Metodo set cambia el valor del panelBotonComeback
	 * @param panelBotonComeBack JPanel
	 */
	public void setPanelBotonComeBack(JPanel panelBotonComeBack) {
		this.panelBotonComeBack = panelBotonComeBack;
	}
	/**
	 * Metodo get devuelve el valor del imagenFondoPanel
	 * @return PanelImgBackground
	 */
	public PanelImgBackground getImagenFondoPanel() {
		return imagenFondoPanel;
	}
	/**
	 * Metodo set cambia el valor del imagenFondoPanel
	 * @param imagenFondoPanel PanelImgBackground
	 */
	public void setImagenFondoPanel(PanelImgBackground imagenFondoPanel) {
		this.imagenFondoPanel = imagenFondoPanel;
	}
	/**
	 * Metodo get devuelve el valor del tituloJLabel
	 * @return JLabel
	 */
	public JLabel getTituloJLabel() {
		return tituloJLabel;
	}
	/**
	 * Metodo set cambia el valor del tituloJLabel
	 * @param tituloJLabel JLabel
	 */
	public void setTituloJLabel(JLabel tituloJLabel) {
		this.tituloJLabel = tituloJLabel;
	}
	/**
	 * Metodo get devuelve el valor del comeBackJButton
	 * @return JButton
	 */
	public JButton getComeBackJButton() {
		return comeBackJButton;
	}
	/**
	 * Metodo set cambia el valor del comeBackJButton
	 * @param comeBackJButton JButton
	 */
	public void setComeBackJButton(JButton comeBackJButton) {
		this.comeBackJButton = comeBackJButton;
	}
	
	
}
