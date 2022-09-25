/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listeners;

import gui.FrmPrincipal;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 * Permite realizar las funciones necesarias para comprobar e impedir que los campos de actualizar Paciente lleven tipeos incorrectos
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class ActualizarPacienteKeyListener implements KeyListener{
    private FrmPrincipal frame;

    public ActualizarPacienteKeyListener(FrmPrincipal frame) {
        this.frame = frame;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getNombreTextFiedl()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getApellidoTextField()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getTelefonoTextField()){
            permitirDiezNumeros(e, frame.getEditarPaciente().getpnlEditar().getTelefonoTextField());
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getCedulaTextField()){
            permitirDiezNumeros(e,frame.getEditarPaciente().getpnlEditar().getCedulaTextField());
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getCuantasVacunasCovField()){
            permitirSoloNumerosCeroACinco(e, frame.getEditarPaciente().getpnlEditar().getCuantasVacunasCovField());
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getCalle()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getCiudad()){
            permitirLetras(e);
        }
        if(e.getSource()==frame.getEditarPaciente().getpnlEditar().getNumero()){
            permitirSoloNumeros(e, frame.getEditarPaciente().getpnlEditar().getNumero());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    /**
     * Método que permite unicamente letras y el espacio en los JTextfield
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
     * Permite unicamente Diez numeros en los JTextfield con una longitud máxima de 10 digitos
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
     * Permite solo números del 0 al 5 con una longitud máxima de 2 dígitos
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
     * Permite una longitud máxima de 3 dígitos numericos
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
