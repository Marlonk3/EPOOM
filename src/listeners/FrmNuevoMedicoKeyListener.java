
package listeners;

import gui.FrmPrincipal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Permite realizar las funciones necesarias para que los campos de creación de un nuevo medico lleven datos incorrectos
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class FrmNuevoMedicoKeyListener implements KeyListener{
    
    FrmPrincipal frame;
    
    public FrmNuevoMedicoKeyListener(){}
    
    public FrmNuevoMedicoKeyListener(FrmPrincipal frame){
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()==frame.getPnlNuevoMedico().getNombreTextFiedl()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getApellidoTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getTelefonoTextField()){
            permitirDiezNumeros(e, frame.getPnlNuevoMedico().getTelefonoTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getCedulaTextField()){
            permitirDiezNumeros(e, frame.getPnlNuevoMedico().getCedulaTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getCiudadTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getCallTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getNumeroJTextField()){
            permitirSoloNumeros(e, frame.getPnlNuevoMedico().getNumeroJTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getLicenciaTextField()){
            permitirDiezNumeros(e, frame.getPnlNuevoMedico().getLicenciaTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getAniosTextField()){
            permitirSoloNumeros(e, frame.getPnlNuevoMedico().getAniosTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getMesesTextField()){
            permitirSoloNumeros(e, frame.getPnlNuevoMedico().getMesesTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getHoraInicioTextField()){
            PermitirHora(e, frame.getPnlNuevoMedico().getHoraInicioTextField());
        }
        if(e.getSource()==frame.getPnlNuevoMedico().getHoraFinTextField()){
           PermitirHora(e, frame.getPnlNuevoMedico().getHoraFinTextField());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    /**
     * Permite unicamente ingresar letras y el espacio
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
     * Permite unicamente diez números
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
     * Permite el maximo de 3 números
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
     * Recibe un String para presentarlo como un dialogo
     * @param mensaje 
     */
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    /**
     * Controla que en hora se puedan ingresar máximo de 6 digitos y el caracter ":"
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
