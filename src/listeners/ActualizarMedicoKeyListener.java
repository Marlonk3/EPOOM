
package listeners;

import gui.FrmPrincipal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 
 * Esta clase controla los valores que se pueden escribir dentro de los JTextfield de la clase Actualizar Medico 
 * @author Erik Andre Barroso Castillo
 * Creado el 11 de Septiembre del 2022, 10:20 horas
 * @version POO - 2022
 * 
 */
public class ActualizarMedicoKeyListener implements KeyListener{

    FrmPrincipal frame;

    public ActualizarMedicoKeyListener(FrmPrincipal frame) {
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getNombreTextFiedl()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getApellidoTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getTelefonoTextField()){
            permitirDiezNumeros(e, frame.getEditarMedico().getpnlEditar().getTelefonoTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getCedulaTextField()){
            permitirDiezNumeros(e, frame.getEditarMedico().getpnlEditar().getCedulaTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getCiudadTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getCallTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getNumeroJTextField()){
            permitirSoloNumeros(e, frame.getEditarMedico().getpnlEditar().getNumeroJTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getLicenciaTextField()){
            permitirDiezNumeros(e, frame.getEditarMedico().getpnlEditar().getLicenciaTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getAniosTextField()){
            permitirSoloNumeros(e, frame.getEditarMedico().getpnlEditar().getAniosTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getMesesTextField()){
            permitirSoloNumeros(e, frame.getEditarMedico().getpnlEditar().getMesesTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getHoraInicioTextField()){
            PermitirHora(e, frame.getEditarMedico().getpnlEditar().getHoraInicioTextField());
        }
        if(e.getSource()==frame.getEditarMedico().getpnlEditar().getHoraFinTextField()){
           PermitirHora(e, frame.getEditarMedico().getpnlEditar().getHoraFinTextField());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    /**
     * función que reibe como parametro un KeyEvent para permitur unicamente letras en un textField
     * @param e 
     */
    public void permitirLetras(KeyEvent e){
        int c = e.getKeyChar();
        //Se controla en base al codigo ASCCI el cual permitirá unicamente letras y el espacio
        boolean mayusculas = c >= 65 && c <=90;
        boolean minusculas = c >= 97 && c <=122;
        boolean espacio = c ==32;
        if(!(mayusculas || minusculas || espacio)){
            e.consume();            
        }
        
    }
    /**
     * Permite solo numeros y el máximo de 10 caracteres
     * @param e
     * @param textF 
     */
    public void permitirDiezNumeros(KeyEvent e, JTextField textF){
        int c = e.getKeyChar();
        //Se controla en base al codigo ASCCI el cual permitirá unicamente numeros
        boolean numeros = c >= 48 && c <=57;
        if(!numeros){
            e.consume();   
        }
        if(textF.getText().length()>=10){
            e.consume();
        }
    }
    
    /**
     * Método para permitir unicamente números en un JTextField y que sean mayor o igual a dos
     * @param e
     * @param textF 
     */
    public void permitirSoloNumeros(KeyEvent e, JTextField textF){
        int c = e.getKeyChar();
        //Se controla en base al codigo ASCCI el cual permitirá unicamente numeros
        boolean numeros = c >= 48 && c <=57;
        if(!numeros){
            e.consume();   
        }
        if(textF.getText().length()>=2){
            e.consume();
        }
    }
    
    /**
     * Método qie recibe como parametro un string y presenta un JOptionPane como mensaje
     * @param mensaje 
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    /**
     * Método que recibe como parámetro el evento de tipo keyevent y un JTexfield que controla los caracteres que se pueden ingresar en hora
     * @param e
     * @param textF 
     */
    public void PermitirHora(KeyEvent e, JTextField textF){
        int c = e.getKeyChar();
        //Se controla en base al codigo ASCCI el cual permitirá unicamente numeros
        boolean numeros = c >= 48 && c <=58;
        if(!numeros){
            e.consume();   
        }
        if(textF.getText().length()>=5){
            e.consume();
        }
    }
}
