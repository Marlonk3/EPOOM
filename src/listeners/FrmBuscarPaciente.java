/**
 * Listener que da vida a la sección de Buscar en la sección paciente
 * 
 * Creado el 13 de Agosto del 2022, 13:25 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import gui.FrmPrincipal;

public class FrmBuscarPaciente implements ActionListener{
   private FrmPrincipal frame;
   private int contador=0;
   /**
    * Constructor da valor a la variable frame local 
    * @param frame FrmPrincipal
    */
   public FrmBuscarPaciente(FrmPrincipal frame){
      this.frame= frame;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource()== frame.getPanelMenuPaciente().getBtnBuscar()){
         frame.removePanelMenuPaciente();
         frame.addBuscarPacientePanel();
         frame.refrescarPanel();
      }
      if(e.getSource()==frame.getBuscarPaciente().getPrincipalPanel().getComeBackJButton()){
         frame.removeBuscarPaciente();
         frame.setPanelMenuPaciente();
         frame.refrescarPanel();
      }
      if(e.getSource()==frame.getBuscarPaciente().getBtnBucar()){
         String buscador= frame.getBuscarPaciente().getBarraBusqueda().getText().toString().toLowerCase();
         if(contador==0){
            try {
               frame.buscarPorCarnet("p", buscador);
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
         }else{
            frame.removerTablaBusquedaPaciente();
            try {
               frame.buscarPorCarnet("p", buscador);
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
         }

         contador++;
         

         
      }
      
   }
   
}
