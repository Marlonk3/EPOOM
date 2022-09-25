/**
 * Permite crear las acciones necesarias pertenecientes a los informes de los pacientes
 * 
 * Creado el 28 de Agosto del 2022, 16:47 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */

package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.FrmPrincipal;



public class FrmInformePacientesListener implements ActionListener {
   private FrmPrincipal frame;
  

   public FrmInformePacientesListener(FrmPrincipal frame) {
      this.frame = frame;

   }

   @Override
   public void actionPerformed(ActionEvent e) {
     if (e.getSource() == frame.getPanelMenuPaciente().getBtnLista()) {
    	 frame.getPnlInformePaciente().limpiarTabla();
    	 frame.getPnlInformePaciente().iniciarTabla();
         frame.removePanelMenuPaciente();
         frame.addPanelListaPaciente();
         frame.refrescarPanel();
         
      }
      if (e.getSource() == frame.getPnlInformePaciente().getPrincipalPanel().getComeBackJButton()) {
         frame.removePanelInformePaciente();
         frame.setPanelMenuPaciente();
         frame.refrescarPanel();
      } 
   }

}
