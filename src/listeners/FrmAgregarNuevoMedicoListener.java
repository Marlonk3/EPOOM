/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import files.ManejarArchivoMedico;
import gui.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Medico;

/**
 * Permite realizar las funciones necesarias para crear un nuevo medico
 * 
 * Creado el 13 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class FrmAgregarNuevoMedicoListener implements ActionListener {
    private FrmPrincipal frame;
    private ManejarArchivoMedico guardarLista;
    private ManejarArchivoMedico recuperarLista;
    private ArrayList<Medico> lstMedico = new ArrayList<>();
    private File archivo = new File("./src/medico.epf");

    public FrmAgregarNuevoMedicoListener() {
    }

    public FrmAgregarNuevoMedicoListener(FrmPrincipal frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getPanelMenuMedico().getBtnAgregar()) {
            frame.removePanelMenuMedico();
            frame.setPnlNuevoMedico();
            frame.refrescarPanel();
            limpiar();
        }
        if (e.getSource() == frame.getPnlNuevoMedico().getBarraSeccion().getComeBackJButton()) {
            if (mensajeDeConfirmacion() == 0) {
                frame.removePnlNuevoMedico();
                frame.setPanelMenuMedico();
                frame.refrescarPanel();
                limpiar();
            }
        }
        if (e.getSource() == frame.getPnlNuevoMedico().getBtnGuardar()) {

            if (validarCamposVacios() == false || validarMeses() == false) {
            } else {
                try {
                    if (!archivo.exists()) {
                        recuperarListaSinArchivo();
                    } else {
                        recuperarLista();
                    }
                    nuevoMedico();
                    int i = lstMedico.size();
                    guardarLista = new ManejarArchivoMedico(lstMedico);
                    guardarLista.guardarArchivo();
                    mostrarMensaje("Médico registrado, su carnet es: " + lstMedico.get(i - 1).getCarnet());
                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmAgregarNuevoMedicoListener.class.getName()).log(Level.SEVERE, null, ex);
                }

                frame.removePnlNuevoMedico();
                frame.setPanelMenuMedico();
                frame.refrescarPanel();
            }
        }
    }

    /**
     * Envia un mensaje de confirmación para retroceder
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
     * Recibe un String devuelve un dialogo con ese string
     * 
     * @param mensaje
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * deja en blanco los JTextField
     */
    public void limpiar() {
        frame.getPnlNuevoMedico().getNombreTextFiedl().setText("");
        frame.getPnlNuevoMedico().getApellidoTextField().setText("");
        frame.getPnlNuevoMedico().getTelefonoTextField().setText("");
        frame.getPnlNuevoMedico().getCedulaTextField().setText("");
        frame.getPnlNuevoMedico().getCiudadTextField().setText("");
        frame.getPnlNuevoMedico().getCallTextField().setText("");
        frame.getPnlNuevoMedico().getNumeroJTextField().setText("");
        frame.getPnlNuevoMedico().getLicenciaTextField().setText("");
        frame.getPnlNuevoMedico().getEspecialidadBox().setSelectedIndex(0);
        frame.getPnlNuevoMedico().getAniosTextField().setText("");
        frame.getPnlNuevoMedico().getMesesTextField().setText("");
        frame.getPnlNuevoMedico().getHoraInicioTextField().setText("");
        frame.getPnlNuevoMedico().getHoraFinTextField().setText("");
    }

    /**
     * Valida si existen campos vacíos en los JTextField
     * 
     * @return
     */
    public boolean validarCamposVacios() {
        boolean validacion = false;
        if (frame.getPnlNuevoMedico().getNombreTextFiedl().getText().isEmpty()
                || frame.getPnlNuevoMedico().getApellidoTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getTelefonoTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getCedulaTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getCiudadTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getCallTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getNumeroJTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getLicenciaTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getEspecialidadBox().getSelectedIndex() == 0
                || frame.getPnlNuevoMedico().getAniosTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getMesesTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getHoraInicioTextField().getText().isEmpty()
                || frame.getPnlNuevoMedico().getHoraFinTextField().getText().isEmpty()) {
            validacion = false;
            mostrarMensaje("Campos incompletos");
        } else {
            validacion = true;
        }
        return validacion;
    }

    /**
     * Agrega una nueva instancia anonima de Médico en la lista
     */
    public void nuevoMedico() {
        String nombre = frame.getPnlNuevoMedico().getNombreTextFiedl().getText();
        String apellidos = frame.getPnlNuevoMedico().getApellidoTextField().getText();
        String telefono = frame.getPnlNuevoMedico().getTelefonoTextField().getText();
        String cedula = frame.getPnlNuevoMedico().getCedulaTextField().getText();
        String ciudad = frame.getPnlNuevoMedico().getCiudadTextField().getText();
        String calle = frame.getPnlNuevoMedico().getCallTextField().getText();
        int numero = Integer.parseInt(frame.getPnlNuevoMedico().getNumeroJTextField().getText());
        int Licencia = Integer.parseInt(frame.getPnlNuevoMedico().getLicenciaTextField().getText());
        String especialidad = frame.getPnlNuevoMedico().getEspecialidadBox().getSelectedItem().toString();
        int anios = Integer.parseInt(frame.getPnlNuevoMedico().getAniosTextField().getText());
        int meses = Integer.parseInt(frame.getPnlNuevoMedico().getMesesTextField().getText());
        String horaInicio = frame.getPnlNuevoMedico().getHoraInicioTextField().getText();
        String horaFin = frame.getPnlNuevoMedico().getHoraFinTextField().getText();
        lstMedico.add(new Medico(nombre, apellidos, telefono, cedula, calle, ciudad, numero, Licencia, especialidad,
                anios, meses, horaInicio, horaFin));
        if (archivo.exists()) {
            frame.getPanelMenuMedico().getBtnActualizarDatos().setEnabled(true);
            frame.getPanelMenuMedico().getBtnBuscar().setEnabled(true);
            frame.getPanelMenuMedico().getBtnLista().setEnabled(true);
        }
    }

    /**
     * Guarda los datos de un archivo en una lista
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void recuperarLista() throws IOException, ClassNotFoundException {
        recuperarLista = new ManejarArchivoMedico();
        lstMedico = recuperarLista.getListaMedico();
    }

    public void recuperarListaSinArchivo() throws IOException, ClassNotFoundException {
        recuperarLista = new ManejarArchivoMedico();
        lstMedico = recuperarLista.getListaMedicoSinArchivo();
    }

    public boolean validarMeses() {
        boolean verificar = false;
        int x = Integer.parseInt(frame.getPnlNuevoMedico().getMesesTextField().getText());
        if (x > 11) {
            verificar = false;
            mostrarMensaje("Los meses no deben ser mayor a 11");
        } else {
            verificar = true;

        }
        return verificar;
    }
}
