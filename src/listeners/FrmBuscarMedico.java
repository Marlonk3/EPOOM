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

public class FrmBuscarMedico implements ActionListener{
   private FrmPrincipal frame;
   private int contador=0;
   /**
    * constructor da valor a la variable frame local
    * @param frame FrmPrincipal
    */
   public FrmBuscarMedico(FrmPrincipal frame){
      this.frame= frame;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==frame.getPanelmenuMedico().getBtnBuscar()){
         frame.removePanelMenuMedico();
         frame.addBuscarMedicoPanel();
         frame.refrescarPanel();
      }
      if(e.getSource()==frame.getBuscarMedico().getPrincipalPanel().getComeBackJButton()){
         frame.removerBuscarMedico();
         frame.setPanelMenuMedico();
         frame.refrescarPanel();
      }
      if(e.getSource()==frame.getBuscarMedico().getBtnBucar()){
         String buscador= frame.getBuscarMedico().getBarraBusqueda().getText().toString().toLowerCase();
         if(contador==0){
            try {
               frame.buscarPorCarnet("m", buscador);
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
         }else{
            frame.removerTablaBusquedaMedico();
            try {
               frame.buscarPorCarnet("m", buscador);
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
         }
         contador++;
      }


      
   }
   
}
