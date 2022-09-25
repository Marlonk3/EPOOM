package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.PnlCrearInformePaciente;

public class CrearInformePacienteListener implements ActionListener {

	private PnlCrearInformePaciente frame;
	private int clicks = 1;
	private int indiceFinal, indiceComienzo, infPaginado;

	public CrearInformePacienteListener(PnlCrearInformePaciente frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (clicks == 1) {
			indiceComienzo = frame.getParticiones();
			indiceFinal = frame.getParticiones() + frame.getParticiones();
			infPaginado = 0;

		}
		if (e.getSource() == frame.getSiguiente()) {
			clicks++;

			if (clicks <= frame.getCantidad()) {
				frame.getAnterior().setEnabled(true);
				frame.limpiarTabla();

				if (!(clicks == 2)) {
					indiceComienzo = indiceComienzo + frame.getParticiones();
					indiceFinal = indiceFinal + frame.getParticiones();
				}
				frame.siguienteFila(indiceComienzo, indiceFinal);
				frame.refrescarPanel();
				frame.setInComienzo(clicks);
				frame.removerInformacionPaginas();
				frame.anadirNuevaEtiquetaInformacion();
				frame.refrescarInformacionPaginas();
				if (clicks == frame.getCantidad() && frame.isExisteResiduo() == false) {
					frame.getSiguiente().setEnabled(false);
				}
			} else {
				frame.getAnterior().setEnabled(true);
				if (!(clicks == 2)) {
					indiceComienzo = indiceComienzo + frame.getParticiones();
					indiceFinal = indiceFinal + frame.getParticiones();
				}

				frame.limpiarTabla();
				frame.ultimaLista(indiceFinal);
				frame.refrescarPanel();
				frame.getSiguiente().setEnabled(false);
				frame.setInComienzo(clicks);
				frame.removerInformacionPaginas();
				frame.anadirNuevaEtiquetaInformacion();
				frame.refrescarInformacionPaginas();
			}
		}
		if (e.getSource() == frame.getAnterior()) {

			clicks--;
			if (clicks >= 1) {

				frame.getSiguiente().setEnabled(true);
				frame.setInComienzo(clicks);
				frame.removerInformacionPaginas();
				frame.anadirNuevaEtiquetaInformacion();
				frame.refrescarInformacionPaginas();
				indiceComienzo = indiceComienzo - frame.getParticiones();
				indiceFinal = indiceFinal - frame.getParticiones();
				frame.limpiarTabla();
				frame.siguienteFila(indiceComienzo, indiceFinal);
				frame.refrescarPanel();
				if (clicks == 1) {
					frame.getAnterior().setEnabled(false);
					indiceComienzo = frame.getParticiones();
					indiceFinal = frame.getParticiones() + frame.getParticiones();
					infPaginado = 0;
				}

//			}else {
//				indiceComienzo= indiceComienzo-frame.getParticiones();
//				indiceFinal=indiceFinal-frame.getParticiones();
//				frame.getSiguiente().setEnabled(true);
//				frame.getAnterior().setEnabled(false);
//				frame.limpiarTabla();
//				frame.primeraLista();
//				frame.refrescarPanel();
//				frame.setInComienzo(clicks);
//				frame.removerInformacionPaginas();
//				frame.anadirNuevaEtiquetaInformacion();
//				frame.refrescarInformacionPaginas();

			}
		}

		// reinicia cantidad de clicks
		if (e.getSource() == frame.getPrincipalPanel().getComeBackJButton()) {
			clicks = 1;
		}
		if (e.getSource() == frame.getConfi()) {
			

			String text = JOptionPane.showInputDialog(null, "Ingrese el numero de elementos a mostrar");

			if(!(text==null)) {
				try {
					int particiones = Integer.parseInt(text);
					
					if(particiones!=0) {
						frame.setParticiones(particiones);
						frame.removerInformacionPaginas();
						frame.anadirNuevaEtiquetaInformacion();
						frame.refrescarInformacionPaginas();
						frame.limpiarTabla();
						frame.iniciarTabla();
						frame.refrescarPanel();
						clicks = 1;
						indiceComienzo = frame.getParticiones();
						indiceFinal = frame.getParticiones() + frame.getParticiones();
						infPaginado = 0;
					}else {
						JOptionPane.showMessageDialog(null, "No puede ser " + '"' + text + '"');
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No puede ser " + '"' + text + '"');
				}
				
			}

		}

	}

	public PnlCrearInformePaciente getFrame() {
		return frame;
	}

	public void setFrame(PnlCrearInformePaciente frame) {
		this.frame = frame;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public int getIndiceFinal() {
		return indiceFinal;
	}

	public void setIndiceFinal(int indiceFinal) {
		this.indiceFinal = indiceFinal;
	}

	public int getIndiceComienzo() {
		return indiceComienzo;
	}

	public void setIndiceComienzo(int indiceComienzo) {
		this.indiceComienzo = indiceComienzo;
	}

	public int getInfPaginado() {
		return infPaginado;
	}

	public void setInfPaginado(int infPaginado) {
		this.infPaginado = infPaginado;
	}

}
