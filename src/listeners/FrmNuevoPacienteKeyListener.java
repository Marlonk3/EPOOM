package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import gui.FrmPrincipal;
import javax.swing.JTextField;

/**
 * Permite realizar las funciones necesarias para que los campos de creación de un nuevo paciente lleven datos incorrectos
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class FrmNuevoPacienteKeyListener implements KeyListener{
    private FrmPrincipal frame;
    
    public FrmNuevoPacienteKeyListener(FrmPrincipal frame){
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()==frame.getAgregarNuevoPanel().getNombreTextFiedl()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getApellidoTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getTelefonoTextField()){
            permitirDiezNumeros(e, frame.getAgregarNuevoPanel().getTelefonoTextField());
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getCedulaTextField()){
            permitirDiezNumeros(e, frame.getAgregarNuevoPanel().getCedulaTextField());
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getCuantasVacunasCovField()){
            permitirSoloNumerosCeroACinco(e, frame.getAgregarNuevoPanel().getCuantasVacunasCovField());
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getCalle()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getCiudad()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getAgregarNuevoPanel().getNumero()){
            permitirSoloNumeros(e, frame.getAgregarNuevoPanel().getNumero());
        } 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    /**
     * Este método permite solo el ingreso de letras y el espacio
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
     * Método que permite unicamente 10 nuemros
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
     * Método que permite unicamente ingresar un digito del cero al cinco 
     * @param e
     * @param textF 
     */
    public void permitirSoloNumerosCeroACinco(KeyEvent e, JTextField textF){
        int c = e.getKeyChar();
        boolean numeros = c >= 48 && c <=53;
        if(!numeros){
            e.consume();   
        }
        if(textF.getText().length()>=1){
            e.consume();
        }
    }
    /**
     * Método que permite ingresar unicamente numeros y solo 3 digitos
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
        if(textF.getText().length()>=3){
            e.consume();
        }
    }
    
}