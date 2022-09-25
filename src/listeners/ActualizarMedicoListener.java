
package listeners;
import files.ManejarArchivoMedico;
import gui.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Medico;

/**
 * Permite realizar las funciones necesarias para realizar las actualizaciones los medicos
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class ActualizarMedicoListener implements ActionListener{
    private FrmPrincipal frame;
    private int x=0;
    private int bandera=0;
    private ManejarArchivoMedico recuperarDatos;
    private ManejarArchivoMedico guardarDatos;
    ArrayList<Medico> lstMedico = new ArrayList<>();

    public ActualizarMedicoListener(FrmPrincipal frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frame.getPanelMenuMedico().getBtnActualizarDatos()){
            frame.getEditarMedico().getBtnBuscar().setEnabled(true);
            frame.removePanelMenuMedico();
            frame.setEditarMedico();
            frame.getEditarMedico().removePanelEditar();
            frame.getEditarMedico().setPanelCentralImagen();
            frame.getEditarMedico().getBarraBusqueda().setText("");
            frame.refrescarPanel();
            try {
                recuperarLista();
            } catch (ClassNotFoundException | IOException ex) {
                
            }
        }
        if(e.getSource()==frame.getEditarMedico().getBtnBuscar()){
            try{
                recuperarLista();
            }catch(ClassNotFoundException | IOException ex){
                
            }
            try{
                if(!lstMedico.isEmpty()){
                        for(int i=0; i<lstMedico.size();i++){
                            if(frame.getEditarMedico().getBarraBusqueda().getText().equals(lstMedico.get(i).getCarnet())){
                                bandera=1;
                                x=i; 
                                frame.getEditarMedico().setPanelEditar();
                                frame.getEditarMedico().removePanelCentralImagen();
                                frame.refrescarPanel();
                                agregarDatos(x);
                                frame.getEditarMedico().getBtnBuscar().setEnabled(false);
                            }                
                        }
                        if(bandera==0 && x<lstMedico.size()){
                                    mostrarMensaje("Medico no encontrado");
                        }
                    }else{
                        mostrarMensaje("No existen médicos registrados");
                    }
            }catch(NullPointerException ex){
                
            }   
        }
        if(e.getSource()==frame.getEditarMedico().getPrincipalPanel().getComeBackJButton()){
            if(mensajeDeConfirmacion()==0){
                frame.removeEditarMedico();
                frame.setPanelMenuMedico();
                frame.refrescarPanel();
            }   
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getBtnGuardar()){
            if(validarCamposVacios()==true || validarMeses()==true){
                editarMedico(x);
                try {
                    guardarDatos();
                } catch (IOException ex) {
                    
                }
                
                frame.removeEditarMedico();
                frame.setPanelMenuMedico();
                frame.refrescarPanel();
            }else{
                
            }
        }
    }
    
    /**
     * Método para obtener la lista del archivo guardado
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    public void recuperarLista() throws ClassNotFoundException, IOException{
        recuperarDatos = new ManejarArchivoMedico();
        lstMedico = recuperarDatos.getListaMedico();
    }
    
    /**
     * Método para enviar un string como un JOptionPane
     * @param mensaje 
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    /**
     * Método para agregar los datos del Médico buscado en los campos a editar
     * @param i 
     */
    public void agregarDatos(int i){
        frame.getEditarMedico().getpnlEditar().getNombreTextFiedl().setText(lstMedico.get(i).getNombre());
        frame.getEditarMedico().getpnlEditar().getApellidoTextField().setText(lstMedico.get(i).getApellidos());
        frame.getEditarMedico().getpnlEditar().getTelefonoTextField().setText(lstMedico.get(i).getTelefono());
        frame.getEditarMedico().getpnlEditar().getCedulaTextField().setText(lstMedico.get(i).getCedula());
        frame.getEditarMedico().getpnlEditar().getCiudadTextField().setText(lstMedico.get(i).getCiudad());
        frame.getEditarMedico().getpnlEditar().getCallTextField().setText(lstMedico.get(i).getCalle());
        frame.getEditarMedico().getpnlEditar().getNumeroJTextField().setText(String.valueOf(lstMedico.get(i).getNumero()));
        frame.getEditarMedico().getpnlEditar().getLicenciaTextField().setText(String.valueOf(lstMedico.get(i).getLicencia()));
        if(lstMedico.get(i).getEspecialidad().equals("Oftamólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(1);
        }
        if(lstMedico.get(i).getEspecialidad().equals("Neurólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(2);
        }
        if(lstMedico.get(i).getEspecialidad().equals("Dermatólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(3);
        }
        if(lstMedico.get(i).getEspecialidad().equals("Traumatólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(4);
        }
        if(lstMedico.get(i).getEspecialidad().equals("Ginecólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(5);
        }
        if(lstMedico.get(i).getEspecialidad().equals("Urólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(6);
        }
        if(lstMedico.get(i).getEspecialidad().equals("Cardiólogo")){
            frame.getEditarMedico().getpnlEditar().getEspecialidadBox().setSelectedIndex(6);
        }
        frame.getEditarMedico().getpnlEditar().getAniosTextField().setText(String.valueOf(lstMedico.get(i).getAnios()));
        frame.getEditarMedico().getpnlEditar().getMesesTextField().setText(String.valueOf(lstMedico.get(i).getMeses()));
        frame.getEditarMedico().getpnlEditar().getHoraInicioTextField().setText(lstMedico.get(i).getHoraInicio());
        frame.getEditarMedico().getpnlEditar().getHoraFinTextField().setText(lstMedico.get(i).getHoraFin());
    }
    /**
     * Crea un mensaje para cuendo se desee cancelar una operación
     * @return 
     */
    public int mensajeDeConfirmacion(){
        int x = 0;
        String [] opciones = {"Aceptar", "Cancelar"};
        x = JOptionPane . showOptionDialog (null ,"¿Decea cancelar la operación actual?","¡ADVERTENCIA!", JOptionPane . DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE , null, opciones, opciones[0]);
        return x;
    }
    /**
     * Método que controla que los JTexField no estén vacíos y en el caso de nombre y apellido permita no menos de 3 y en cédula no menos de 10
     * @return boolean
     */
    public boolean validarCamposVacios(){
        boolean validacion = false;
        if(frame.getEditarMedico().getpnlEditar().getNombreTextFiedl().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getNombreTextFiedl().getText().length()<3 || frame.getEditarMedico().getpnlEditar().getApellidoTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getApellidoTextField().getText().length()<3 || frame.getEditarMedico().getpnlEditar().getTelefonoTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getCedulaTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getCedulaTextField().getText().length()<10 || frame.getEditarMedico().getpnlEditar().getCiudadTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getCallTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getNumeroJTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getLicenciaTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getEspecialidadBox().getSelectedIndex()==0 || frame.getEditarMedico().getpnlEditar().getAniosTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getMesesTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getHoraInicioTextField().getText().isEmpty() || frame.getEditarMedico().getpnlEditar().getHoraFinTextField().getText().isEmpty()){
            validacion = false;
            mostrarMensaje("Ingrese los datos correctamente, los campos nombre y apellido llevan como mínimo 3 caracteres y la cedula 10");
        }else{
            validacion = true;
        }
        return validacion;
    }
    /**
     * Método que guarda en la lista los datos actualizados de médico
     * @param x 
     */
    public void editarMedico(int x){
        String nombre = frame.getEditarMedico().getpnlEditar().getNombreTextFiedl().getText();
        String apellidos = frame.getEditarMedico().getpnlEditar().getApellidoTextField().getText();
        String telefono = frame.getEditarMedico().getpnlEditar().getTelefonoTextField().getText();
        String cedula = frame.getEditarMedico().getpnlEditar().getCedulaTextField().getText();
        String ciudad = frame.getEditarMedico().getpnlEditar().getCiudadTextField().getText();
        String calle = frame.getEditarMedico().getpnlEditar().getCallTextField().getText();
        int numero = Integer.parseInt(frame.getEditarMedico().getpnlEditar().getNumeroJTextField().getText());
        int Licencia = Integer.parseInt(frame.getEditarMedico().getpnlEditar().getLicenciaTextField().getText());
        String especialidad = frame.getEditarMedico().getpnlEditar().getEspecialidadBox().getSelectedItem().toString();
        int anios = Integer.parseInt(frame.getEditarMedico().getpnlEditar().getAniosTextField().getText());
        int meses = Integer.parseInt(frame.getEditarMedico().getpnlEditar().getMesesTextField().getText());
        String horaInicio = frame.getEditarMedico().getpnlEditar().getHoraInicioTextField().getText();
        String horaFin = frame.getEditarMedico().getpnlEditar().getHoraFinTextField().getText();
        lstMedico.get(x).setNombre(nombre);
        lstMedico.get(x).setApellidos(apellidos);
        lstMedico.get(x).setCalle(calle);
        lstMedico.get(x).setCedula(cedula);
        lstMedico.get(x).setTelefono(telefono);
        lstMedico.get(x).setCiudad(ciudad);
        lstMedico.get(x).setNumero(numero);
        lstMedico.get(x).setEspecialidad(especialidad);
        lstMedico.get(x).setLicencia(Licencia);
        lstMedico.get(x).setAnios(anios);
        lstMedico.get(x).setMeses(meses);
        lstMedico.get(x).setHoraInicio(horaInicio);
        lstMedico.get(x).setHoraFin(horaFin);
        mostrarMensaje("Medico actualizado, Recuerde que su carnet es: " + lstMedico.get(x).getCarnet());
    }
    /**
     * Método para guardar los datos de la lista en un archivo binario
     * @throws IOException 
     */
    public void guardarDatos() throws IOException{
        guardarDatos = new  ManejarArchivoMedico(lstMedico);
        guardarDatos.guardarArchivo();
    }
    /**
     * Verifica que los meses no sean mayor a 11
     * @return boolean
     */
    public boolean validarMeses(){
        boolean verificar= false;
        int x= Integer.parseInt(frame.getEditarMedico().getpnlEditar().getMesesTextField().getText());
        if( x>11){
            verificar=false;
            mostrarMensaje("Los meses no deben ser mayor a 11");
        }else{
            verificar=true;
            
        }
        return verificar;
    }
}
