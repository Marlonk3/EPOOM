/**
 * Contiene la extención JFrame lo que permite realizar la gestión de los paneles que se muestra al usuarío mediante eventos e instancias de otras clases de tipo JPanel 
 * 
 * Creado el 31 de Agosto del 2022, 15:30 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import files.ManejarArchivoMedico;
import files.ManejarArchivoPaciente;
import listeners.ActualizarMedicoKeyListener;
import listeners.ActualizarMedicoListener;
import listeners.ActualizarPacienteListener;
import listeners.ActualizarPacienteKeyListener;
import listeners.FrmAgregarNuevoMedicoListener;
import listeners.FrmPrincipalListener;
import modelo.Medico;
import modelo.Paciente;
import listeners.FrmAgregarNuevoPacienteListener;
import listeners.FrmBuscarMedico;
import listeners.FrmInformePacientesListener;
import listeners.FrmInfromeMedicoListener;
import listeners.FrmNuevoMedicoKeyListener;
import listeners.FrmNuevoPacienteKeyListener;
import listeners.FrmBuscarPaciente;

public class FrmPrincipal extends JFrame {
	Cursor c;
	ImageIcon cursorImg = new ImageIcon(FrmPrincipal.class.getResource("/Img/cursor.png"));
	Toolkit tk = Toolkit.getDefaultToolkit();
	private AgregarNuevo agregarNuevoPacientePanel;
	private AgregarNuevoMedico pnlNuevoMedico;
	private JPanel contentPane;
	private MainPanel primerPanel;
	private PanelsMenu panelmenuMedico, panelmenuPaciente;
	private ActualizarPaciente editarPaciente;
	private ActualizarMedico editarMedico;
	private PanelDefaultBusc mensajeRecuerda;
	private ManejarArchivoPaciente archivosPaciente;
	private BusCart buscarPaciente, buscarMedico;
	private ManejarArchivoMedico archivosMedico;
	// private Informe panelInformePaciente, panelInformeMedico;
	private PnlCrearInformePaciente pnlInformePaciente;
	private PnlCrearInforme pnlInformeMedico;
	private TableBusqueda tablaBusqueda;
	private File archivoPaciente = new File("./src/Paciente.epf");
	private File archivoMedico = new File("./src/medico.epf");

	/**
	 * Constructor permite realizar las acciones necesarías para mostrar JFrame con
	 * el nombre "El Paciente Feliz"
	 * 
	 * @throws java.io.IOException
	 */
	public FrmPrincipal() throws IOException {
		super("EPOOM");
		initComponets();
		// Icono del programa
		setIconImage(getIconImage());
		// Listeners
		addListeners();
		addListenersBtnMenuPaciente();
		frmNuevoPacienteKeyListener();
		addListenersNuevoMedico();
		addKeyListenersNuevoMedico();
		addListenersEditarPaciente();
		addListenersEditarMedico();
		addKeyListenersEditarPaciente();
		addKeyListenersActualizarMedico();
		addListenersBuscarPaciente();
		addListenerBtnInformePaciente();
		addListenerBtnInformeMedico();
		addListnerBuscarMedico();
	}

	/**
	 * Función initComponets permite realizar las instancias necesarias para iniciar
	 * los componentes
	 */
	private void initComponets() {

		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		primerPanel = new MainPanel();
		editarMedico = new ActualizarMedico("Editar Medico");
		contentPane.add(primerPanel, BorderLayout.CENTER);
		panelmenuMedico = new PanelsMenu("/Img/BackgroundMedico.jpg", "Médicos", "médico");
		panelmenuPaciente = new PanelsMenu("/Img/BackgroundPaciente.jpg", "Pacientes", "paciente");
		agregarNuevoPacientePanel = new AgregarNuevo();
		pnlNuevoMedico = new AgregarNuevoMedico();
		editarPaciente = new ActualizarPaciente("Editar Paciente");
		this.c = tk.createCustomCursor(cursorImg.getImage(), new Point(1, 1), "Cursor");
		this.setCursor(c);
		buscarPaciente = new BusCart("Buscar Paciente");
		buscarMedico = new BusCart("Buscar médico");
		mensajeRecuerda = new PanelDefaultBusc();
		
		pnlInformeMedico = new PnlCrearInforme();
		pnlInformePaciente= new PnlCrearInformePaciente();

		if (!archivoPaciente.exists()) {
			panelmenuPaciente.getBtnBuscar().setEnabled(false);
			panelmenuPaciente.getBtnLista().setEnabled(false);
			panelmenuPaciente.getBtnActualizarDatos().setEnabled(false);
		}
		if (!archivoMedico.exists()) {
			panelmenuMedico.getBtnBuscar().setEnabled(false);
			panelmenuMedico.getBtnLista().setEnabled(false);
			panelmenuMedico.getBtnActualizarDatos().setEnabled(false);
		}
	}

	@Override
	public Image getIconImage() {
		Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/Icono.png"));
		return icono;
	}

	/**
	 * Añade los listener de la sección buscar medico
	 */
	private void addListnerBuscarMedico() {
		FrmBuscarMedico listener = new FrmBuscarMedico(this);
		panelmenuMedico.getBtnBuscar().addActionListener(listener);
		buscarMedico.getPrincipalPanel().getComeBackJButton().addActionListener(listener);
		buscarMedico.getBtnBucar().addActionListener(listener);
	}

	/**
	 * Permite Añadir los ActionListener al panel BuscarPaciente y a cada uno de sus
	 * botones
	 */
	private void addListenersBuscarPaciente() {
		FrmBuscarPaciente listener = new FrmBuscarPaciente(this);
		panelmenuPaciente.getBtnBuscar().addActionListener(listener);
		buscarPaciente.getPrincipalPanel().getComeBackJButton().addActionListener(listener);
		buscarPaciente.getBtnBucar().addActionListener(listener);
	}

	/**
	 * Permite añadir los ActionListener a la sección que pertenece a el informe
	 * medico
	 */
	private void addListenerBtnInformeMedico() {
		FrmInfromeMedicoListener listener = new FrmInfromeMedicoListener(this);
		panelmenuMedico.getBtnLista().addActionListener(listener);
		pnlInformeMedico.getPrincipalPanel().getComeBackJButton().addActionListener(listener);
	}

	/**
	 * Permite añadir los ActionListener a la sección que pertenece a el informe
	 * paciente
	 */
	private void addListenerBtnInformePaciente() {
		FrmInformePacientesListener listener = new FrmInformePacientesListener(this);
		panelmenuPaciente.getBtnLista().addActionListener(listener);
		pnlInformePaciente.getPrincipalPanel().getComeBackJButton().addActionListener(listener);
	}
	
	
	/**
	 * Añade el panel buscarMedico
	 */
	public void addBuscarMedicoPanel() {
		contentPane.add(buscarMedico);
		buscarMedico.getContenedorPrincipal().add(mensajeRecuerda, BorderLayout.CENTER);
	}

	/**
	 * Añade la sección de buscar nuevo paciente
	 */
	public void addBuscarPacientePanel() {
		contentPane.add(buscarPaciente);
		buscarPaciente.getContenedorPrincipal().add(mensajeRecuerda, BorderLayout.CENTER);
	}

	/**
	 * Remueve el panel buscarMedico
	 */
	public void removerBuscarMedico() {
		contentPane.remove(buscarMedico);
	}

	/**
	 * Remueve le panel buscar nuevo paciente
	 */
	public void removeBuscarPaciente() {
		contentPane.remove(buscarPaciente);
	}

	/**
	 * Remueve la tabla de busqueda que se encuentra en buscarMedico
	 */
	public void removerTablaBusquedaMedico() {
		buscarMedico.getContenedorPrincipal().remove(tablaBusqueda);
	}

	/**
	 * Remueve la tabla de busqueda que se encuentra en buscarPaciente
	 */
	public void removerTablaBusquedaPaciente() {
		buscarPaciente.getContenedorPrincipal().remove(tablaBusqueda);
	}

	/**
	 * Permite realizar la busqueda por carnet acorde la necesidad si who es igual
	 * "m" medico y si "p" entonces paciente
	 * 
	 * @param who     String
	 * @param bucador String - Lo que el usuario escribio en el buscador
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void buscarPorCarnet(String who, String bucador) throws ClassNotFoundException, IOException {

		if (who == "p") {
			ArrayList<Paciente> listaRecuperada;
			listaRecuperada = new ArrayList<>();
			archivosPaciente = new ManejarArchivoPaciente();
			listaRecuperada = archivosPaciente.getListaPaciente();
			boolean seEncontro = false;
			for (int i = 0; i < listaRecuperada.size(); i++) {
				if (bucador.equals(listaRecuperada.get(i).getCarnet())) {
					String esAlergico;
					if (listaRecuperada.get(i).getEsAlergico() == true) {
						esAlergico = "Si";
					} else {
						esAlergico = "No";
					}
					Object[][] filas = { { "Nombre", listaRecuperada.get(i).getNombre() },
							{ "Apellido", listaRecuperada.get(i).getApellidos() },
							{ "Teléfono", listaRecuperada.get(i).getTelefono() },
							{ "Cedula", listaRecuperada.get(i).getCedula() }, { "Es Alergico", esAlergico },
							{ "Total Vacunas Covid", listaRecuperada.get(i).getTotalVacunasCovid() },
							{ "Ciudad", listaRecuperada.get(i).getCiudad() },
							{ "Calle", listaRecuperada.get(i).getCalle() },
							{ "Número", listaRecuperada.get(i).getNumero() } };
					removerPanelAvisoPaciente();
					tablaBusqueda = new TableBusqueda(filas);

					buscarPaciente.getContenedorPrincipal().add(tablaBusqueda, BorderLayout.CENTER);
					refrescarPanel();
					seEncontro = true;
				}
			}
			if (seEncontro == false) {
				JOptionPane.showMessageDialog(null, "Lo sentimos no se ha encontrado");
			}
		}
		if (who == "m") {
			ArrayList<Medico> listaRecuperada;
			listaRecuperada = new ArrayList<>();
			archivosMedico = new ManejarArchivoMedico();
			listaRecuperada = archivosMedico.getListaMedico();
			boolean seEncontro = false;

			for (int i = 0; i < listaRecuperada.size(); i++) {
				if (bucador.equals(listaRecuperada.get(i).getCarnet())) {
					Object[][] filas = { { "Nombre", listaRecuperada.get(i).getNombre() },
							{ "Apellido", listaRecuperada.get(i).getApellidos() },
							{ "Teléfono", listaRecuperada.get(i).getTelefono() },
							{ "Cedula", listaRecuperada.get(i).getCedula() },
							{ "Ciudad", listaRecuperada.get(i).getCiudad() },
							{ "Calle", listaRecuperada.get(i).getCalle() },
							{ "Número", listaRecuperada.get(i).getNumero() },
							{ "Licencia", listaRecuperada.get(i).getLicencia() },
							{ "Especialidad", listaRecuperada.get(i).getEspecialidad() },
							{ "Años", listaRecuperada.get(i).getAnios() },
							{ "Meses", listaRecuperada.get(i).getMeses() },
							{ "Hora de inicio", listaRecuperada.get(i).getHoraInicio() },
							{ "Hora de salida", listaRecuperada.get(i).getHoraFin() } };
					removerPanelAvisoMedico();
					tablaBusqueda = new TableBusqueda(filas);

					buscarMedico.getContenedorPrincipal().add(tablaBusqueda, BorderLayout.CENTER);
					refrescarPanel();
					seEncontro = true;
				}
			}
			if (seEncontro == false) {
				JOptionPane.showMessageDialog(null, "Lo sentimos no se ha encontrado");
			}
		}
	}

	public void removePanelInformePaciente() {
		contentPane.remove(pnlInformePaciente);
	}

	/**
	 * Añade el panel de informe medico
	 */
	public void addPanelListaMedico() {
		// panelInformeMedico= new Informe("m");
		contentPane.add(pnlInformeMedico);

	}

	
	public void addPanelListaPaciente() {
		contentPane.add(pnlInformePaciente);
	}
	
	public BusCart getBuscarPaciente() {
		return buscarPaciente;
	}

	/**
	 * Remueve el panel de informe medico
	 */
	public void removerPanelInformeMedico() {
		contentPane.remove(pnlInformeMedico);
	}

	public void setBuscarPaciente(BusCart buscarPaciente) {
		this.buscarPaciente = buscarPaciente;
	}

	/**
	 * Remueve el panel de aviso que se encuentra en buscarMedico
	 */
	public void removerPanelAvisoMedico() {
		buscarMedico.getContenedorPrincipal().remove(mensajeRecuerda);
	}

	/**
	 * Remueve el panel de aviso que se encuentra en buscarPaciente
	 */
	public void removerPanelAvisoPaciente() {
		buscarPaciente.getContenedorPrincipal().remove(mensajeRecuerda);
	}

	public BusCart getBuscarMedico() {
		return buscarMedico;
	}

	/**
	 * Remueve el panel buscar paciente
	 */
	public void removerPanelBuscarPaciente() {
		contentPane.remove(buscarPaciente);
	}

	public void setBuscarMedico(BusCart buscarMedico) {
		this.buscarMedico = buscarMedico;
	}

	/**
	 * Agrega a los contenedores los acction listeners creando una instancia de la
	 * clase escuchadora y enviando el frame.
	 */
	private void addListeners() {
		FrmPrincipalListener listener = new FrmPrincipalListener(this);
		primerPanel.getBtnMedico().addActionListener(listener);
		primerPanel.getBtnPaciente().addActionListener(listener);
		panelmenuMedico.getformatoPanelOpciones().getComeBackJButton().addActionListener(listener);
		panelmenuPaciente.getformatoPanelOpciones().getComeBackJButton().addActionListener(listener);
	}

	/**
	 * Añade los AccionListener a la sección de Menu paciente
	 */
	private void addListenersBtnMenuPaciente() {
		FrmAgregarNuevoPacienteListener listener = new FrmAgregarNuevoPacienteListener(this);
		agregarNuevoPacientePanel.getBarraSeccion().getComeBackJButton().addActionListener(listener);
		panelmenuPaciente.getBtnAgregar().addActionListener(listener);
		agregarNuevoPacientePanel.getBtnGuardar().addActionListener(listener);
		editarPaciente.getPrincipalPanel().getComeBackJButton().addActionListener(listener);
	}

	/**
	 * Añade KeyListener a la sección paciente
	 */
	private void frmNuevoPacienteKeyListener() {
		FrmNuevoPacienteKeyListener listener = new FrmNuevoPacienteKeyListener(this);
		agregarNuevoPacientePanel.getNombreTextFiedl().addKeyListener(listener);
		agregarNuevoPacientePanel.getApellidoTextField().addKeyListener(listener);
		agregarNuevoPacientePanel.getCedulaTextField().addKeyListener(listener);
		agregarNuevoPacientePanel.getTelefonoTextField().addKeyListener(listener);
		agregarNuevoPacientePanel.getTotalVacunas().addKeyListener(listener);
		agregarNuevoPacientePanel.getCalle().addKeyListener(listener);
		agregarNuevoPacientePanel.getNumero().addKeyListener(listener);
		agregarNuevoPacientePanel.getCiudad().addKeyListener(listener);
		agregarNuevoPacientePanel.getCuantasVacunasCovField().addKeyListener(listener);
	}

	/**
	 * Añade AcctionListeners a la seccón encargada de crear un nuevo medico
	 * 
	 * @throws IOException
	 */
	private void addListenersNuevoMedico() throws IOException {
		FrmAgregarNuevoMedicoListener listener = new FrmAgregarNuevoMedicoListener(this);
		panelmenuMedico.getBtnAgregar().addActionListener(listener);
		pnlNuevoMedico.getBarraSeccion().getComeBackJButton().addActionListener(listener);
		pnlNuevoMedico.getBtnGuardar().addActionListener(listener);
	}

	/**
	 * Añade KeyListeners a la sección nuevo medico
	 */
	private void addKeyListenersNuevoMedico() {
		FrmNuevoMedicoKeyListener listener = new FrmNuevoMedicoKeyListener(this);
		pnlNuevoMedico.getNombreTextFiedl().addKeyListener(listener);
		pnlNuevoMedico.getApellidoTextField().addKeyListener(listener);
		pnlNuevoMedico.getTelefonoTextField().addKeyListener(listener);
		pnlNuevoMedico.getCedulaTextField().addKeyListener(listener);
		pnlNuevoMedico.getCiudadTextField().addKeyListener(listener);
		pnlNuevoMedico.getCallTextField().addKeyListener(listener);
		pnlNuevoMedico.getNumeroJTextField().addKeyListener(listener);
		pnlNuevoMedico.getLicenciaTextField().addKeyListener(listener);
		pnlNuevoMedico.getAniosTextField().addKeyListener(listener);
		pnlNuevoMedico.getMesesTextField().addKeyListener(listener);
		pnlNuevoMedico.getHoraInicioTextField().addKeyListener(listener);
		pnlNuevoMedico.getHoraFinTextField().addKeyListener(listener);
	}

	/**
	 * Añade los ActionListeners para la sección editar paciente
	 */
	private void addListenersEditarPaciente() {
		ActualizarPacienteListener listener = new ActualizarPacienteListener(this);
		editarPaciente.getBtnBucar().addActionListener(listener);
		editarPaciente.getpnlEditar().getBtnGuardar().addActionListener(listener);
		panelmenuPaciente.getBtnActualizarDatos().addActionListener(listener);
	}

	/**
	 * Añade los ActionListeners para la sección editar Medico
	 */
	private void addListenersEditarMedico() {
		ActualizarMedicoListener listener = new ActualizarMedicoListener(this);
		editarMedico.getBtnBuscar().addActionListener(listener);
		panelmenuMedico.getBtnActualizarDatos().addActionListener(listener);
		editarMedico.getPrincipalPanel().getComeBackJButton().addActionListener(listener);
		editarMedico.getpnlEditar().getBtnGuardar().addActionListener(listener);
	}

	/**
	 * Añade KeyListener a la sección de editar Paciente
	 */
	private void addKeyListenersEditarPaciente() {
		ActualizarPacienteKeyListener listener = new ActualizarPacienteKeyListener(this);
		editarPaciente.getpnlEditar().getNombreTextFiedl().addKeyListener(listener);
		editarPaciente.getpnlEditar().getApellidoTextField().addKeyListener(listener);
		editarPaciente.getpnlEditar().getCedulaTextField().addKeyListener(listener);
		editarPaciente.getpnlEditar().getTelefonoTextField().addKeyListener(listener);
		editarPaciente.getpnlEditar().getTotalVacunas().addKeyListener(listener);
		editarPaciente.getpnlEditar().getCalle().addKeyListener(listener);
		editarPaciente.getpnlEditar().getNumero().addKeyListener(listener);
		editarPaciente.getpnlEditar().getCiudad().addKeyListener(listener);
		editarPaciente.getpnlEditar().getCuantasVacunasCovField().addKeyListener(listener);

	}

	/**
	 * Añade KeyListener a la sección de editar Paciente
	 */
	private void addKeyListenersActualizarMedico() {
		ActualizarMedicoKeyListener listener = new ActualizarMedicoKeyListener(this);
		editarMedico.getpnlEditar().getNombreTextFiedl().addKeyListener(listener);
		editarMedico.getpnlEditar().getApellidoTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getTelefonoTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getCedulaTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getCiudadTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getCallTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getNumeroJTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getLicenciaTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getAniosTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getMesesTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getHoraInicioTextField().addKeyListener(listener);
		editarMedico.getpnlEditar().getHoraFinTextField().addKeyListener(listener);
	}

	/**
	 * Agrega el panel para poder agregar un nuevo paciente
	 */
	public void addAgregarNuevoPaciente() {
		contentPane.add(agregarNuevoPacientePanel);
	}

	/**
	 * Remueve el panel que agrega nuevo paciente
	 */
	public void removerAgregarNuevo() {
		contentPane.remove(agregarNuevoPacientePanel);
	}

	/**
	 * Metodo accesor get que retorna el primer panel que es una instancia de main
	 * panel.
	 * 
	 * @return primerPanel
	 **/
	public MainPanel getPrimerPanel() {
		return primerPanel;
	}

	/**
	 * Método accesor get que retorna PanelMenuMedico instancia de PanelsMenu.
	 * 
	 * @return panelmenuMedico
	 **/
	public PanelsMenu getPanelMenuMedico() {
		return panelmenuMedico;
	}

	/**
	 * Métofo accesor get que retorna el PanelMenuPaciente instancia de PanelsMenu.
	 * 
	 * @return panelmenuPaciente
	 **/
	public PanelsMenu getPanelMenuPaciente() {
		return panelmenuPaciente;
	}

	/**
	 * Método accesor set que agrega a panelMedico al contentPane.
	 **/
	public void setPanelMenuMedico() {
		contentPane.add(panelmenuMedico);
	}

	/**
	 * Método accesor set que agrega el panelMenuPAciente al contentPane.
	 **/
	public void setPanelMenuPaciente() {
		contentPane.add(panelmenuPaciente);
	}

	/**
	 * Método accesor set que agrega el primerPanel al contentPane.
	 **/
	public void setPrimerPanel() {
		contentPane.add(primerPanel, BorderLayout.CENTER);
	}

	/**
	 * Método para remover el PanelMenuMedico del contentPane.
	 **/
	public void removePanelMenuMedico() {
		contentPane.remove(panelmenuMedico);
	}

	/**
	 * Método para remover el panelMenuPaciente del contentPane.
	 **/
	public void removePanelMenuPaciente() {
		contentPane.remove(panelmenuPaciente);
	}

	/**
	 * Método para remover el PrimerPanel del contentPane.
	 **/
	public void removePrimerPanel() {
		contentPane.remove(primerPanel);
	}

	/**
	 * Método para refrescar el FramePrincipal.
	 **/
	public void refrescarPanel() {
		SwingUtilities.updateComponentTreeUI(contentPane);
		contentPane.validate();
	}

	public Cursor getC() {
		return c;
	}

	public void setC(Cursor c) {
		this.c = c;
	}

	public ImageIcon getCursorImg() {
		return cursorImg;
	}

	public void setCursorImg(ImageIcon cursorImg) {
		this.cursorImg = cursorImg;
	}

	public Toolkit getTk() {
		return tk;
	}

	public void setTk(Toolkit tk) {
		this.tk = tk;
	}

	public AgregarNuevo getAgregarNuevoPanel() {
		return agregarNuevoPacientePanel;
	}

	public void setAgregarNuevoPanel(AgregarNuevo agregarNuevoPanel) {
		this.agregarNuevoPacientePanel = agregarNuevoPanel;
	}

	public void setPrimerPanel(MainPanel primerPanel) {
		this.primerPanel = primerPanel;
	}

	public PanelsMenu getPanelmenuMedico() {
		return panelmenuMedico;
	}

	public void setPanelmenuMedico(PanelsMenu panelmenuMedico) {
		this.panelmenuMedico = panelmenuMedico;
	}

	public PanelsMenu getPanelmenuPaciente() {
		return panelmenuPaciente;
	}

	public void setPanelmenuPaciente(PanelsMenu panelmenuPaciente) {
		this.panelmenuPaciente = panelmenuPaciente;
	}

	public void setPnlNuevoMedico() {
		contentPane.add(pnlNuevoMedico);
	}

	public AgregarNuevoMedico getPnlNuevoMedico() {
		return pnlNuevoMedico;
	}

	/**
	 * Remover panel nuevo medico
	 */
	public void removePnlNuevoMedico() {
		contentPane.remove(pnlNuevoMedico);
	}

	public void setPanelEditarPaciente() {
		contentPane.add(editarPaciente);
	}

	/**
	 * Remueve el panel editar paciente
	 */
	public void removeEditarPaciente() {
		contentPane.remove(editarPaciente);
	}

	public ActualizarPaciente getEditarPaciente() {
		return editarPaciente;
	}

	public ActualizarMedico getEditarMedico() {
		return editarMedico;
	}

	public void setEditarMedico() {
		contentPane.add(editarMedico);
	}

	/**
	 * Remueve le panel editar medico
	 */
	public void removeEditarMedico() {
		contentPane.remove(editarMedico);
	}

	public AgregarNuevo getAgregarNuevoPacientePanel() {
		return agregarNuevoPacientePanel;
	}

	public void setAgregarNuevoPacientePanel(AgregarNuevo agregarNuevoPacientePanel) {
		this.agregarNuevoPacientePanel = agregarNuevoPacientePanel;
	}

	public void setPnlNuevoMedico(AgregarNuevoMedico pnlNuevoMedico) {
		this.pnlNuevoMedico = pnlNuevoMedico;
	}

	public PanelDefaultBusc getMensajeRecuerda() {
		return mensajeRecuerda;
	}

	public void setMensajeRecuerda(PanelDefaultBusc mensajeRecuerda) {
		this.mensajeRecuerda = mensajeRecuerda;
	}

	public ManejarArchivoPaciente getArchivosPaciente() {
		return archivosPaciente;
	}

	public void setArchivosPaciente(ManejarArchivoPaciente archivosPaciente) {
		this.archivosPaciente = archivosPaciente;
	}

	public ManejarArchivoMedico getArchivosMedico() {
		return archivosMedico;
	}

	public void setArchivosMedico(ManejarArchivoMedico archivosMedico) {
		this.archivosMedico = archivosMedico;
	}

	public void setEditarPaciente(ActualizarPaciente editarPaciente) {
		this.editarPaciente = editarPaciente;
	}

	public void setEditarMedico(ActualizarMedico editarMedico) {
		this.editarMedico = editarMedico;
	}

	public PnlCrearInforme getPnlInformeMedico() {
		return pnlInformeMedico;
	}

	public void setPnlInformeMedico(PnlCrearInforme pnlInformeMedico) {
		this.pnlInformeMedico = pnlInformeMedico;
	}

	public TableBusqueda getTablaBusqueda() {
		return tablaBusqueda;
	}

	public void setTablaBusqueda(TableBusqueda tablaBusqueda) {
		this.tablaBusqueda = tablaBusqueda;
	}

	public File getArchivoPaciente() {
		return archivoPaciente;
	}

	public void setArchivoPaciente(File archivoPaciente) {
		this.archivoPaciente = archivoPaciente;
	}

	public File getArchivoMedico() {
		return archivoMedico;
	}

	public void setArchivoMedico(File archivoMedico) {
		this.archivoMedico = archivoMedico;
	}

	public PnlCrearInformePaciente getPnlInformePaciente() {
		return pnlInformePaciente;
	}

	public void setPnlInformePaciente(PnlCrearInformePaciente pnlInformePaciente) {
		this.pnlInformePaciente = pnlInformePaciente;
	}

}
