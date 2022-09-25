/**
 * Permite da las funciones necesarias al momento de interactuar con los diferentes funciones del panel Informes Medicos
 * 
 * Creado el 11 de Septiembre del 2022, 10:20 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.FrmPrincipal;


public class FrmInfromeMedicoListener implements ActionListener {

   private FrmPrincipal frame;

   public FrmInfromeMedicoListener(FrmPrincipal frame) {
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == frame.getPanelMenuMedico().getBtnLista()) {
    	  
    	 frame.getPnlInformeMedico().limpiarTabla();
    	 frame.getPnlInformeMedico().iniciarTabla(); 
         frame.removePanelMenuMedico();
         frame.addPanelListaMedico();
         frame.refrescarPanel();
         
      }
      if (e.getSource() == frame.getPnlInformeMedico().getPrincipalPanel().getComeBackJButton()) {
         frame.removerPanelInformeMedico();
         frame.setPanelMenuMedico();
         frame.refrescarPanel();
      }

   }

}
