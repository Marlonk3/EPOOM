/**
 * 
 * Permite dar vida al proceso de crear un nuevo médico a travez de la clase implementada ActionListener
 * 
 * Creado el 7 de Septiembre del 2022, 19:10 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 *
 */
package listeners;

import files.ManejarArchivoPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.FrmPrincipal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Paciente;

public class FrmAgregarNuevoPacienteListener implements ActionListener {
    private ManejarArchivoPaciente guardarDatos;
    private ManejarArchivoPaciente recuperarLista;
    private FrmPrincipal frame;
    private ArrayList<Paciente> lstPaciente = new ArrayList<>();
    private File archivo = new File("./src/Paciente.epf");

    /**
     * constructor que recibe como parametro el JFrame de la clase FrmPrincipal y da
     * valor a la variable local
     * 
     * @param frame
     */
    public FrmAgregarNuevoPacienteListener(FrmPrincipal frame) {
        this.frame = frame;
    }

    /**
     * Metodo implementado de la interfaz ActionListener que da vida a los botones y
     * al proceso de agregar un nuevo medico
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getPanelMenuPaciente().getBtnAgregar()) {
            frame.removePanelMenuPaciente();
            frame.addAgregarNuevoPaciente();
            frame.refrescarPanel();
            limpiar();
        }
        if (e.getSource() == frame.getAgregarNuevoPanel().getBarraSeccion().getComeBackJButton()) {
            if (mensajeDeConfirmacion() == 0) {
                frame.removerAgregarNuevo();
                frame.setPanelMenuPaciente();
                frame.refrescarPanel();
                limpiar();
            }
        }
        if (e.getSource() == frame.getAgregarNuevoPanel().getBtnGuardar()) {

            if (frame.getAgregarNuevoPanel().getNombreTextFiedl().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getApellidoTextField().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getTelefonoTextField().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getCedulaTextField().getText().isEmpty()
                    || (frame.getAgregarNuevoPanel().getOpcionesSiEsAlergico().isSelected() == false
                            && frame.getAgregarNuevoPanel().getOpcionesNoEsAlergico().isSelected() == false)
                    || frame.getAgregarNuevoPanel().getCuantasVacunasCovField().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getCiudad().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getCalle().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getNumero().getText().isEmpty()
                    || frame.getAgregarNuevoPanel().getNombreTextFiedl().getText().length() < 3
                    || frame.getAgregarNuevoPanel().getApellidoTextField().getText().length() < 3
                    || frame.getAgregarNuevoPanel().getCedulaTextField().getText().length() < 10) {
                mostrarMensaje(
                        "Debe de llenar todos los campos, los campos nombre y apellido deben de tener 3 caracteres al menos y  la cedula 10");
            } else {
                if (!archivo.exists()) {
                    try {
                        recuperarListaSinArchivo();
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(FrmAgregarNuevoPacienteListener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        recuperarLista();
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(FrmAgregarNuevoPacienteListener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                nuevoPaciente();
                guardarDatos = new ManejarArchivoPaciente(lstPaciente);
                try {
                    int i = lstPaciente.size();
                    guardarDatos.guardarArchivo();
                    mostrarMensaje("Registro Guardado, su carnet es:" + lstPaciente.get(i - 1).getCarnet());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (archivo.exists()) {
                    frame.getPanelMenuPaciente().getBtnActualizarDatos().setEnabled(true);
                    frame.getPanelMenuPaciente().getBtnBuscar().setEnabled(true);
                    frame.getPanelMenuPaciente().getBtnLista().setEnabled(true);
                }
                

                frame.removerAgregarNuevo();
                frame.setPanelMenuPaciente();
                frame.refrescarPanel();
            }
        }
        if (e.getSource() == frame.getEditarPaciente().getPrincipalPanel().getComeBackJButton()) {
            if (mensajeDeConfirmacion() == 0) {
                frame.removeEditarPaciente();
                frame.setPanelMenuPaciente();
                frame.refrescarPanel();
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void nuevoPaciente() {
        boolean esAlergico;
        String telefono = frame.getAgregarNuevoPanel().getTelefonoTextField().getText();
        String cedula = frame.getAgregarNuevoPanel().getCedulaTextField().getText();
        int totalVacunas = Integer.parseInt(frame.getAgregarNuevoPanel().getCuantasVacunasCovField().getText());
        int numero = Integer.parseInt(frame.getAgregarNuevoPanel().getNumero().getText());
        String nombre = frame.getAgregarNuevoPanel().getNombreTextFiedl().getText();
        String apellidos = frame.getAgregarNuevoPanel().getApellidoTextField().getText();
        String ciudad = frame.getAgregarNuevoPanel().getCiudad().getText();
        String calle = frame.getAgregarNuevoPanel().getCalle().getText();
        if (frame.getAgregarNuevoPanel().getOpcionesSiEsAlergico().isSelected()) {
            esAlergico = true;
        } else {
            esAlergico = false;
        }
        lstPaciente.add(
                new Paciente(esAlergico, totalVacunas, nombre, apellidos, telefono, cedula, calle, ciudad, numero));
    }

    public void limpiar() {
        frame.getAgregarNuevoPanel().getTelefonoTextField().setText("");
        frame.getAgregarNuevoPanel().getCedulaTextField().setText("");
        frame.getAgregarNuevoPanel().getCuantasVacunasCovField().setText("");
        frame.getAgregarNuevoPanel().getNumero().setText("");
        frame.getAgregarNuevoPanel().getNombreTextFiedl().setText("");
        frame.getAgregarNuevoPanel().getApellidoTextField().setText("");
        frame.getAgregarNuevoPanel().getCiudad().setText("");
        frame.getAgregarNuevoPanel().getCalle().setText("");
        frame.getAgregarNuevoPanel().getOpcionesEsAlergicGroup().clearSelection();
        frame.getPnlNuevoMedico().getAniosTextField().setText("");
        frame.getPnlNuevoMedico().getMesesTextField().setText("");
        frame.getPnlNuevoMedico().getHoraInicioTextField().setText("");
        frame.getPnlNuevoMedico().getHoraFinTextField().setText("");
    }

    /**
     * Envia un mensaje de confirmación para cancelar la operación vigente
     * 
     * @return
     */
    public int mensajeDeConfirmacion() {
        int x = 0;
        String[] opciones = { "Aceptar", "Cancelar" };
        x = JOptionPane.showOptionDialog(null, "¿Decea cancelar la operación actual?", "¡ADVERTENCIA!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        return x;
    }

    /**
     * Guarda los datos de un archivo en la lista
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void recuperarLista() throws IOException, ClassNotFoundException {
        recuperarLista = new ManejarArchivoPaciente();
        lstPaciente = recuperarLista.getListaPaciente();
    }

    public void recuperarListaSinArchivo() throws IOException, ClassNotFoundException {
        recuperarLista = new ManejarArchivoPaciente();
        lstPaciente = recuperarLista.getListaPacienteSinArchivo();
    }
}
