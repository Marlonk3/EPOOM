/**
 * Contiene una extención JPanel con componentes tipo plantilla que permite realizar la creación de un JPanel personalizado para un menu de opciones con los botones correspondientes a agregar, actualizar datos, lista y buscar 
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
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelsMenu extends JPanel{
	private JPanel panelCentral, agregarPanel, buscarPanel, listaPanel, actualizarDatosPanel;
	private TipoSeccionPanel formatoPanelOpciones;
	private JButton btnAgregar, btnBuscar, btnLista, btnActualizarDatos;
	/**
	 * Constructor por defecto
	 */
	public PanelsMenu(){}
	
	/**
	 * Cosntructor recibe los parametros necesarios para realizar una instancia del JPanel
	 * @param imgBackground String - Recibe la imagen que será el fondo del panel
	 * @param nombreSeccion String - El nombre del JLabel que tendra la barra de opciones 
	 * @param tipoNombreBtn String - El nombre distintivo que tendran los botones
	 */
	public PanelsMenu(String imgBackground, String nombreSeccion, String tipoNombreBtn) {
		initComponets(imgBackground, nombreSeccion, tipoNombreBtn);
	}
	/**
	 *  Función que permite inicializar y agregar los componentes del JPanel 
	 * @param imgBackground String - Recibe la imagen que será el fondo del panel
	 * @param nombreSeccion String - El nombre del JLabel que tendra la barra de opciones 
	 * @param tipoNombreBtn String - El nombre distintivo que tendran los botones
	 */
	public void  initComponets(String imgBackground, String nombreSeccion, String tipoNombreBtn){
		//setSize(900, 500);
		formatoPanelOpciones = new TipoSeccionPanel(imgBackground,nombreSeccion);
		setLayout(new BorderLayout());
		panelCentral= new JPanel(new GridLayout(2,2));
		panelCentral.setOpaque(false);
		agregarPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,150));
		agregarPanel.setOpaque(false);
		btnAgregar = new JButton(" Agregar nuevo "+tipoNombreBtn+" ");
		btnAgregar.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,30));
		
		btnAgregar.setBackground(Color.white);
		agregarPanel.add(btnAgregar);
		buscarPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,150));
		buscarPanel.setOpaque(false);
		btnBuscar= new JButton(" Buscar por carnet ");
		btnBuscar.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,30));
		
		btnBuscar.setBackground(Color.white);
		buscarPanel.add(btnBuscar);
		listaPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,150));
		listaPanel.setOpaque(false);
		btnLista= new JButton(" Lista de "+tipoNombreBtn+"s ");
		btnLista.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,30));
		
		btnLista.setBackground(Color.white);
		listaPanel.add(btnLista);
		actualizarDatosPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,150));
		actualizarDatosPanel.setOpaque(false);
		btnActualizarDatos= new JButton(" Actualizar "+tipoNombreBtn+" ");
		btnActualizarDatos.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,30));

		btnActualizarDatos.setBackground(Color.white);
		actualizarDatosPanel.add(btnActualizarDatos);		
		panelCentral.add(agregarPanel);
		panelCentral.add(buscarPanel);
		panelCentral.add(listaPanel);
		panelCentral.add(actualizarDatosPanel);
		formatoPanelOpciones.getImagenFondoPanel().add(panelCentral, BorderLayout.CENTER);
		add(formatoPanelOpciones, BorderLayout.CENTER);
	}
	
	/**
	 * Metodo get devuelve el valor del panelCentral
	 * @return JPanel
	 */
	public JPanel getPanelCentral() {
		return panelCentral;
	}
	/**
	 * Metodo set cambia el valor del panelCentral
	 * @param panelCentral JPanel
	 */
	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}
	/**
	 * Metodo get devuelve el valor del agregarPanel
	 * @return 	JPanel
	 */
	public JPanel getAgregarPanel() {
		return agregarPanel;
	}
	/**
	 * Metodo set cambia el valor de agregarPanel
	 * @param agregarPanel JPanel
	 */
	public void setAgregarPanel(JPanel agregarPanel) {
		this.agregarPanel = agregarPanel;
	}
	/**
	 * Metodo get devuelve el valor del buscarPanel
	 * @return JPanel
	 */
	public JPanel getBuscarPanel() {
		return buscarPanel;
	}
	/**
	 * Metodo set cambia el valor de buscarPanel
	 * @param buscarPanel JPanel
	 */
	public void setBuscarPanel(JPanel buscarPanel) {
		this.buscarPanel = buscarPanel;
	}
	/**
	 * Metodo get devuelve el valor del listaPanel
	 * @return JPanel
	 */
	public JPanel getListaPanel() {
		return listaPanel;
	}
	/**
	 * Metodo set cambia el valor de listaPanel
	 * @param listaPanel JPanel
	 */
	public void setListaPanel(JPanel listaPanel) {
		this.listaPanel = listaPanel;
	}
	/**
	 *  Metodo get devuelve el valor del actualizarDatosPanel
	 * @return JPanel
	 */
	public JPanel getActualizarDatosPanel() {
		return actualizarDatosPanel;
	}
	/**
	 * Metodo set cambia el valor de actualizarDatosPanel
	 * @param actualizarDatosPanel JPanel
	 */
	public void setActualizarDatosPanel(JPanel actualizarDatosPanel) {
		this.actualizarDatosPanel = actualizarDatosPanel;
	}
	/**
	 * Metodo get devuelve el valor del formatoPanelOpciones
	 * @return JPanel
	 */
	public TipoSeccionPanel getFormatoPanelOpciones() {
		return formatoPanelOpciones;
	}
	/**
	 * Metodo set cambia el valor de fromatoPanelOpciones
	 * @param formatoPanelOpciones TipoSeccionPanel
	 */
	public void setFormatoPanelOpciones(TipoSeccionPanel formatoPanelOpciones) {
		this.formatoPanelOpciones = formatoPanelOpciones;
	}
	/**
	 * Metodo get devuelve el valor del btnAgregar
	 * @return JButton
	 */
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	/**
	 * Metodo set cambia el valor de btnAgregar
	 * @param btnAgregar JButton
	 */
	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
	/**
	 * Metodo get devuelve el valor del btnBuscar
	 * @return JButton
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/**
	 * Metodo set cambia el valor de btnBuscar
	 * @param btnBuscar JButton
	 */
	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	/**
	 * Metodo get devuelve el valor del btnLista
	 * @return JButton
	 */
	public JButton getBtnLista() {
		return btnLista;
	}
	/**
	 * Metodo set cambia el valor de btnLista
	 * @param btnLista JButton
	 */
	public void setBtnLista(JButton btnLista) {
		this.btnLista = btnLista;
	}
	/**
	 * Metodo get devuelve el valor del btnActualizarDatos
	 * @return JButton
	 */
	public JButton getBtnActualizarDatos() {
		return btnActualizarDatos;
	}
	/**
	 * Metodo set cambia el valor de btnActualizarDatos
	 * @param btnActualizarDatos JButton
	 */
	public void setBtnActualizarDatos(JButton btnActualizarDatos) {
		this.btnActualizarDatos = btnActualizarDatos;
	}
	
	/**
	 * Metodo get devuelve el valor del panel formatoPanelOpciones
	 * @return
	 */
	public TipoSeccionPanel getformatoPanelOpciones() {
		return formatoPanelOpciones;
	}
	
	
}
