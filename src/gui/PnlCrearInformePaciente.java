
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import files.ManejarArchivoPaciente;
import listeners.CrearInformePacienteListener;
import modelo.Paciente;

public class PnlCrearInformePaciente extends JPanel {
	private TipoSeccionPanel principalPanel;
	private JPanel panelCentral, cntTabla, contBotones;
	private JButton anterior, siguiente, confi;
	private JLabel infPaginado;
	private int inFinal, inComienzo;
	private JScrollPane scroll;
	private JTable tabla;
	private ManejarArchivoPaciente archivo;
	private ArrayList<Paciente> listaRecuperada;
	private DefaultTableModel model;
	private int particiones;
	private int cantidad;
	private boolean existeResiduo;
	private List<Paciente> nuevaLista;

	public PnlCrearInformePaciente() {
		initComponets();
		particiones = 4;
	}

	private void initComponets() {
		setSize(1200, 700);
		// setSize(1000, 600);
		principalPanel = new TipoSeccionPanel("/Img/BackgroundMedico2.jpg", "Medico");// cambiar
		setLayout(new BorderLayout());
		add(principalPanel, BorderLayout.CENTER);
		anadeBotoneSur();
		anadeTabla();
		addListenerBtn();

	}

	private void anadeTabla() {
		cntTabla = new JPanel(new BorderLayout());

		tabla = new JTable();
		model = new DefaultTableModel();

		scroll = new JScrollPane(tabla);
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("teléfono");
		model.addColumn("Cédula");
		model.addColumn("Es alergico");
		model.addColumn("Total vacunas");
		model.addColumn("Ciudad");
		model.addColumn("Calle");
		model.addColumn("Número");
		model.addColumn("Carnet");
		tabla.setModel(model);
		tabla.setRowHeight(40);
		tabla.setFont(new Font("Aharoni", 0, 11));
		panelCentral.add(scroll, BorderLayout.CENTER);
	}

	private void addListenerBtn() {
		CrearInformePacienteListener listener = new CrearInformePacienteListener(this);
		siguiente.addActionListener(listener);
		anterior.addActionListener(listener);
		principalPanel.getComeBackJButton().addActionListener(listener);
		confi.addActionListener(listener);
	}

	private void anadeBotoneSur() {
		panelCentral = new JPanel(new BorderLayout());
		panelCentral.setOpaque(false);
		// Botones South
		contBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 25));
		contBotones.setOpaque(false);
		anterior = new JButton("< Anterior");
		anterior.setBackground(Color.white);
		anterior.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		siguiente = new JButton("Siguiente >");
		siguiente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		siguiente.setBackground(Color.white);
		infPaginado = new JLabel(inComienzo + " de " + inFinal);
		infPaginado.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		infPaginado.setForeground(Color.BLACK);
		confi= new JButton("Configuración");//
		confi.setBackground(Color.white);//
		confi.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		contBotones.add(confi);
		contBotones.add(anterior);
		contBotones.add(infPaginado);
		contBotones.add(siguiente);

		panelCentral.add(contBotones, BorderLayout.SOUTH);
		principalPanel.getImagenFondoPanel().add(panelCentral, BorderLayout.CENTER);

	}

	public void iniciarTabla() {
		// Lee lista
		listaRecuperada = new ArrayList<>();
		archivo = new ManejarArchivoPaciente();
		try {
			listaRecuperada = archivo.getListaPaciente();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		if (particiones > listaRecuperada.size() || particiones == listaRecuperada.size()) {
			for (int i = 0; i < listaRecuperada.size(); i++) {
				Object[] fila = { listaRecuperada.get(i).getNombre(), listaRecuperada.get(i).getApellidos(),
						listaRecuperada.get(i).getTelefono(), listaRecuperada.get(i).getCedula(),
						listaRecuperada.get(i).getEsAlergico(), listaRecuperada.get(i).getTotalVacunasCovid(),
						listaRecuperada.get(i).getCiudad(), listaRecuperada.get(i).getCalle(),
						listaRecuperada.get(i).getNumero(), listaRecuperada.get(i).getCarnet() };
				model.addRow(fila);
				// desactiva botones
				siguiente.setEnabled(false);
				anterior.setEnabled(false);
			}
			inComienzo=0;
			inFinal=0;
			removerInformacionPaginas();
			
			anadirNuevaEtiquetaInformacion();
			refrescarInformacionPaginas();
		} else {
			int residuo=0;
			siguiente.setEnabled(true);
			anterior.setEnabled(false);
			// activar botones
			if(!(particiones==0)) {
				cantidad = ((listaRecuperada.size()) / particiones);
				residuo = ((listaRecuperada.size()) % particiones);
			}
			if (residuo == 0) {
				existeResiduo = false;
			} else {
				existeResiduo = true;

			}
			primeraLista();
			inComienzo = 1;
			if (existeResiduo) {
				inFinal = cantidad + 1;
			} else {

				inFinal = cantidad;
			}
			removerInformacionPaginas();
			anadirNuevaEtiquetaInformacion();
			refrescarInformacionPaginas();
		}

	}

	public void anadirNuevaEtiquetaInformacion() {
		infPaginado.setText(inComienzo + " de " + inFinal);
		contBotones.add(infPaginado);
		contBotones.add(siguiente);
	}

	public void removerInformacionPaginas() {
		contBotones.remove(infPaginado);
		contBotones.remove(siguiente);
	}

	public void refrescarInformacionPaginas() {
		SwingUtilities.updateComponentTreeUI(infPaginado);
		infPaginado.validate();
	}

	public void refrescarPanel() {
		SwingUtilities.updateComponentTreeUI(scroll);
		scroll.validate();
	}

	public void primeraLista() {
		listaRecuperada = new ArrayList<>();
		archivo = new ManejarArchivoPaciente();
		try {
			listaRecuperada = archivo.getListaPaciente();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < particiones; i++) {
			String esAlergico;
			if (listaRecuperada.get(i).getEsAlergico() == true) {
				esAlergico = "Si";
			} else {
				esAlergico = "No";
			}
			Object[] fila = { listaRecuperada.get(i).getNombre(), listaRecuperada.get(i).getApellidos(),
					listaRecuperada.get(i).getTelefono(), listaRecuperada.get(i).getCedula(), esAlergico,
					listaRecuperada.get(i).getTotalVacunasCovid(), listaRecuperada.get(i).getCiudad(),
					listaRecuperada.get(i).getCalle(), listaRecuperada.get(i).getNumero(),
					listaRecuperada.get(i).getCarnet() };
			model.addRow(fila);

		}
	}

	public void siguienteFila(int indiceComienzo, int indiceFinal) {
		nuevaLista = new ArrayList<>();
		listaRecuperada = new ArrayList<>();
		archivo = new ManejarArchivoPaciente();
		try {
			listaRecuperada = archivo.getListaPaciente();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		nuevaLista = listaRecuperada.subList(indiceComienzo, indiceFinal);

		for (int i = 0; i < nuevaLista.size(); i++) {
			String esAlergico;
			if (nuevaLista.get(i).getEsAlergico() == true) {
				esAlergico = "Si";
			} else {
				esAlergico = "No";
			}
			Object[] fila = { nuevaLista.get(i).getNombre(), nuevaLista.get(i).getApellidos(),
					nuevaLista.get(i).getTelefono(), nuevaLista.get(i).getCedula(), esAlergico,
					nuevaLista.get(i).getTotalVacunasCovid(), nuevaLista.get(i).getCiudad(),
					nuevaLista.get(i).getCalle(), nuevaLista.get(i).getNumero(), nuevaLista.get(i).getCarnet() };
			model.addRow(fila);
		}

	}

	public void ultimaLista(int indiceFinal) {
		nuevaLista = new ArrayList<>();
		listaRecuperada = new ArrayList<>();
		archivo = new ManejarArchivoPaciente();
		try {
			listaRecuperada = archivo.getListaPaciente();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		nuevaLista = listaRecuperada.subList(indiceFinal - particiones, listaRecuperada.size());
		for (int i = 0; i < nuevaLista.size(); i++) {
			String esAlergico;
			if (nuevaLista.get(i).getEsAlergico() == true) {
				esAlergico = "Si";
			} else {
				esAlergico = "No";
			}
			Object[] fila = { nuevaLista.get(i).getNombre(), nuevaLista.get(i).getApellidos(),
					nuevaLista.get(i).getTelefono(), nuevaLista.get(i).getCedula(), esAlergico,
					nuevaLista.get(i).getTotalVacunasCovid(), nuevaLista.get(i).getCiudad(),
					nuevaLista.get(i).getCalle(), nuevaLista.get(i).getNumero(), nuevaLista.get(i).getCarnet() };
			model.addRow(fila);
		}
	}

	public void limpiarTabla() {
		int contador = tabla.getRowCount();

		for (int i = contador - 1; i >= 0; i--) {
			model.removeRow(i);
		}

	}

	public TipoSeccionPanel getPrincipalPanel() {
		return principalPanel;
	}

	public void setPrincipalPanel(TipoSeccionPanel principalPanel) {
		this.principalPanel = principalPanel;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	public JPanel getCntTabla() {
		return cntTabla;
	}

	public void setCntTabla(JPanel cntTabla) {
		this.cntTabla = cntTabla;
	}

	public JPanel getContBotones() {
		return contBotones;
	}

	public void setContBotones(JPanel contBotones) {
		this.contBotones = contBotones;
	}

	public JButton getAnterior() {
		return anterior;
	}

	public void setAnterior(JButton anterior) {
		this.anterior = anterior;
	}

	public JButton getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(JButton siguiente) {
		this.siguiente = siguiente;
	}

	public JLabel getInfPaginado() {
		return infPaginado;
	}

	public void setInfPaginado(JLabel infPaginado) {
		this.infPaginado = infPaginado;
	}

	public int getInFinal() {
		return inFinal;
	}

	public void setInFinal(int inFinal) {
		this.inFinal = inFinal;
	}

	public int getInComienzo() {
		return inComienzo;
	}

	public void setInComienzo(int inComienzo) {
		this.inComienzo = inComienzo;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public int getParticiones() {
		return particiones;
	}

	public void setParticiones(int particiones) {
		this.particiones = particiones;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isExisteResiduo() {
		return existeResiduo;
	}

	public void setExisteResiduo(boolean existeResiduo) {
		this.existeResiduo = existeResiduo;
	}
	public JButton getConfi() {
		return confi;
	}

	public void setConfi(JButton confi) {
		this.confi = confi;
	}
}
