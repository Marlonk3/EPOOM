package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.FrmPrincipal;

/**
 * 
 * @Autor Erik Andre Barroso Castillo.
 * @author Marlon Jair Azua Barrera
 * Creado el 13 de Agosto del 2022, 13:25 horas
 * @version POO - 2022
 * Clase escuchadora para el Frame principal la cual se encarga de manejar los eventos y acciones.
 **/
public class FrmPrincipalListener implements ActionListener {

	private FrmPrincipal frame;

	/**
	 * Constructor vacío de la clase escuchadora.
	 **/
	public FrmPrincipalListener() {
	}

	/**
	 * Constructor que recibe como parámetro una instancia de FrmPrincipal.
	 * 
	 * @param frame
	 **/
	public FrmPrincipalListener(FrmPrincipal frame) {
		this.frame = frame;
	}

	@Override
	/**
	 * Método implementado de la interfaz ActionListener que realiza las acciones
	 * programadas.
	 **/
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == frame.getPrimerPanel().getBtnMedico()) {
			frame.removePrimerPanel();
			frame.refrescarPanel();
			frame.setPanelMenuMedico();
		}
		if (e.getSource() == frame.getPrimerPanel().getBtnPaciente()) {
			frame.removePrimerPanel();
			frame.refrescarPanel();
			frame.setPanelMenuPaciente();
		}
		if (e.getSource() == frame.getPanelMenuMedico().getFormatoPanelOpciones().getComeBackJButton()) {
			frame.setPrimerPanel();
			frame.removePanelMenuMedico();
			frame.refrescarPanel();
		}
		if (e.getSource() == frame.getPanelMenuPaciente().getFormatoPanelOpciones().getComeBackJButton()) {
			frame.setPrimerPanel();
			frame.removePanelMenuPaciente();
			frame.refrescarPanel();
		}

	}

}
