/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import files.ManejarArchivoPaciente;
import gui.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Paciente;

/**
 * Permite realizar las funciones necesarias que los campos de actualiar nuevo paciente no lleven datos o tipeos incorrectos
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class ActualizarPacienteListener implements ActionListener{
    private FrmPrincipal frame;
    private int x=0;
    private int bandera = 0;
    private ManejarArchivoPaciente recuperarDatos;
    private ManejarArchivoPaciente guardarDatos;
    ArrayList<Paciente> lstPaciente;
    
    public ActualizarPacienteListener(FrmPrincipal frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frame.getEditarPaciente().getBtnBucar()){
            try {
                recuperarLista();
                try{
                    if(lstPaciente.size()!=0){
                        for(int i=0;i<lstPaciente.size();i++){
                            if(frame.getEditarPaciente().getBarraBusqueda().getText().equals(lstPaciente.get(i).getCarnet())){
                                bandera =1;
                                x=i;
                                frame.getEditarPaciente().setPanelEditar();
                                frame.getEditarPaciente().removePanelCentralImagen();
                                frame.refrescarPanel();
                                agregarDatos(i);
                                frame.getEditarPaciente().getBtnBucar().setEnabled(false);
                            }
                        }
                        if(bandera==0 && x<lstPaciente.size()){
                                mostrarMensaje("Paciente no encontrado");
                        }
                    }else{
                        mostrarMensaje("No existen pacientes registrados");
                    }    
                }catch(NullPointerException ex){
                    
                }                
            } catch (ClassNotFoundException | IOException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getBtnGuardar()){
            if(validarCamposVacios()==true){
                editarPaciente(x);
                try {
                    guardarDatos();
                    
                } catch (IOException ex) {

                }
                mostrarMensaje("Paciente Actualizado, su carnet es:" + lstPaciente.get(x).getCarnet());
                frame.removeEditarPaciente();
                frame.setPanelMenuPaciente();
                frame.refrescarPanel();
            }else{
                mostrarMensaje("Ingrese los datos correctamente, los campos nombre y apellido llevan como mínimo 3 caracteres y la cedula 10");
            } 
        }
        if(e.getSource()==frame.getPanelMenuPaciente().getBtnActualizarDatos()){
            frame.getEditarPaciente().getBtnBucar().setEnabled(true);
            frame.removePanelMenuPaciente();
            frame.setPanelEditarPaciente();
            frame.getEditarPaciente().removePanelEditar();
            frame.getEditarPaciente().setPanelImagen();
            frame.getEditarPaciente().getBarraBusqueda().setText("");
            frame.refrescarPanel();
        }
    }
    
    /**
     * Recupera la lista del archivo guardado guardando los datos en una lista
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void recuperarLista() throws ClassNotFoundException, IOException{
        lstPaciente = new ArrayList<>();
        recuperarDatos = new ManejarArchivoPaciente();
        lstPaciente = recuperarDatos.getListaPaciente();
    }
    
    /**
     * Llena los JTextfield con los datos a modificar
     * @param i 
     */
    public void agregarDatos(int i){
        frame.getEditarPaciente().getpnlEditar().getNombreTextFiedl().setText(lstPaciente.get(i).getNombre());
        frame.getEditarPaciente().getpnlEditar().getApellidoTextField().setText(lstPaciente.get(i).getApellidos());
        frame.getEditarPaciente().getpnlEditar().getTelefonoTextField().setText(lstPaciente.get(i).getTelefono());
        frame.getEditarPaciente().getpnlEditar().getCedulaTextField().setText(lstPaciente.get(i).getCedula());
        if(lstPaciente.get(i).getEsAlergico()==true){
            frame.getEditarPaciente().getpnlEditar().getOpcionesSiEsAlergico().setSelected(true);
        }else{
            frame.getEditarPaciente().getpnlEditar().getOpcionesNoEsAlergico().setSelected(true);
        }
        frame.getEditarPaciente().getpnlEditar().getCuantasVacunasCovField().setText(String.valueOf(lstPaciente.get(i).getTotalVacunasCovid()));
        frame.getEditarPaciente().getpnlEditar().getCiudad().setText(lstPaciente.get(i).getCiudad());
        frame.getEditarPaciente().getpnlEditar().getCalle().setText(lstPaciente.get(i).getCalle());
        frame.getEditarPaciente().getpnlEditar().getNumero().setText(String.valueOf(lstPaciente.get(i).getNumero()));
    }
    
    /**
     * Guarda los cambios en la lista
     * @param i 
     */
    public void editarPaciente(int i){
        boolean esAlergico;
        String telefono = frame.getEditarPaciente().getpnlEditar().getTelefonoTextField().getText();
        String cedula = frame.getEditarPaciente().getpnlEditar().getCedulaTextField().getText();
        int totalVacunas = Integer.parseInt(frame.getEditarPaciente().getpnlEditar().getCuantasVacunasCovField().getText());
        int numero = Integer.parseInt(frame.getEditarPaciente().getpnlEditar().getNumero().getText());
        String nombre =  frame.getEditarPaciente().getpnlEditar().getNombreTextFiedl().getText();
        String apellidos = frame.getEditarPaciente().getpnlEditar().getApellidoTextField().getText();
        String ciudad = frame.getEditarPaciente().getpnlEditar().getCiudad().getText();
        String calle = frame.getEditarPaciente().getpnlEditar().getCalle().getText();
        if(frame.getEditarPaciente().getpnlEditar().getOpcionesSiEsAlergico().isSelected()){
            esAlergico=true;
        }else{
            esAlergico=false;
        }
        lstPaciente.get(i).setNombre(nombre);
        lstPaciente.get(i).setApellidos(apellidos);
        lstPaciente.get(i).setCalle(calle);
        lstPaciente.get(i).setCedula(cedula);
        lstPaciente.get(i).setEsAlergico(esAlergico);
        lstPaciente.get(i).setTelefono(telefono);
        lstPaciente.get(i).setTotalVacunasCovid(totalVacunas);
        lstPaciente.get(i).setCiudad(ciudad);
        lstPaciente.get(i).setNumero(numero);
    }
    
    /**
     * Controla que no hallan campos vacíos en cada JTextField
     * @return 
     */
    public boolean validarCamposVacios(){
        boolean validacion = false;
        if(frame.getEditarPaciente().getpnlEditar().getNombreTextFiedl().getText().length()<3 || frame.getEditarPaciente().getpnlEditar().getNombreTextFiedl().getText().isEmpty() || frame.getEditarPaciente().getpnlEditar().getApellidoTextField().getText().length()<3 || frame.getEditarPaciente().getpnlEditar().getApellidoTextField().getText().isEmpty() || frame.getEditarPaciente().getpnlEditar().getCalle().getText().isEmpty() || frame.getEditarPaciente().getpnlEditar().getCedulaTextField().getText().length()<10 || frame.getEditarPaciente().getpnlEditar().getCedulaTextField().getText().isEmpty() || (frame.getEditarPaciente().getpnlEditar().getOpcionesSiEsAlergico().isSelected()==false && frame.getEditarPaciente().getpnlEditar().getOpcionesNoEsAlergico().isSelected()==false) || frame.getEditarPaciente().getpnlEditar().getTelefonoTextField().getText().isEmpty() || frame.getEditarPaciente().getpnlEditar().getTotalVacunas().getText().isEmpty() || frame.getEditarPaciente().getpnlEditar().getCiudad().getText().isEmpty() || frame.getEditarPaciente().getpnlEditar().getNumero().getText().isEmpty()){
            validacion = false;
        }else{
            validacion = true;
        }
        return validacion;
    }
    
    /**
     * Recibe un Strign como parámetro y lo muestra en un JOptioPane.showMessageDialog
     * @param mensaje 
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    /**
     * Mensaje de confirmación para retorceder
     * @return 
     */
    public int mensajeDeConfirmacion(){
        int x = 0;
        String [] opciones = {"Aceptar", "Cancelar"};
        x = JOptionPane . showOptionDialog (null ,"¿Decea cancelar la operación actual?","¡ADVERTENCIA!", JOptionPane . DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE , null, opciones, opciones[0]);
        return x;
    }
    /**
     * Guarda la lista en un archivo
     * @throws IOException 
     */
    public void guardarDatos() throws IOException{
        guardarDatos = new ManejarArchivoPaciente(lstPaciente);
        guardarDatos.guardarArchivo();
    }
}
