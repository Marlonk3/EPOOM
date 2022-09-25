/**
 * Contiene el listener de clase JPanel de nombre Informe el cual el da acción a los botones siguiente y anterior para realizar el paginado dependiendo de el paramentro "p" se refiere a pacientes y "m" a medico
 * 
 * Creado el 14 de Agosto del 2022, 15:00 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 */

package listeners;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import files.ManejarArchivoMedico;
import files.ManejarArchivoPaciente;
import gui.Informe;
import modelo.Medico;
import modelo.Paciente;

public class InformeListener implements ActionListener {
   private Informe panel;
   private String who;
   private int contadorPaciente = 0, contadorMedico = 0;
   private ManejarArchivoPaciente archivosPaciente;
   private ManejarArchivoMedico archivosMedico;
   private String[] columnas = {
         "Tipos", "Datos"
   };
   /**
    * Cosntructor que recibe como parametro un JPanel y un String cuanquiera de los posibles parametros "m" o "p"
    * @param panel JPanel
    * @param who String
    */
   public InformeListener(Informe panel, String who) {
      this.panel = panel;
      this.who = who;

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == panel.getBtnSiguiente()) {
         if (who == "p") {
            panel.getBntAnterior().setEnabled(true);
            contadorPaciente++;
            // Recupera lista
            ArrayList<Paciente> listaRecuperada;
            listaRecuperada = new ArrayList<>();
            archivosPaciente = new ManejarArchivoPaciente();
            try {
               listaRecuperada = archivosPaciente.getListaPaciente();
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            // se usa lista en la tabla
            String esAlergico;
            if (listaRecuperada.get(contadorPaciente).getEsAlergico() == true) {
               esAlergico = "Si";
            } else {
               esAlergico = "No";
            }
            Object[][] filas = {
                  { "Nombre", listaRecuperada.get(contadorPaciente).getNombre() },
                  { "Apellido", listaRecuperada.get(contadorPaciente).getApellidos() },
                  { "Teléfono", listaRecuperada.get(contadorPaciente).getTelefono() },
                  { "Cedula", listaRecuperada.get(contadorPaciente).getCedula() },
                  { "Es Alergico", esAlergico },
                  { "Total Vacunas Covid", listaRecuperada.get(contadorPaciente).getTotalVacunasCovid() },
                  { "Ciudad", listaRecuperada.get(contadorPaciente).getCiudad() },
                  { "Calle", listaRecuperada.get(contadorPaciente).getCalle() },
                  { "Número", listaRecuperada.get(contadorPaciente).getNumero() },
                  {"Carnet", listaRecuperada.get(contadorPaciente).getCarnet()}
            };
            try {
               if (comprobarContadorSuma("p")) {
                  panel.getBtnSiguiente().setEnabled(false);
               }
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            JTable tablaInforme = new JTable(filas, columnas);
            tablaInforme.setEnabled(false);
            tablaInforme.setRowSelectionAllowed(false);
            tablaInforme.setFont(new Font("Aharoni", 0, 30));
            tablaInforme.setRowHeight(20);
            tablaInforme.getColumnModel().getColumn(0).setPreferredWidth(400);
            tablaInforme.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaInforme.setRowHeight(50);

            panel.removerTabla();

            panel.addNewTabla(tablaInforme);
            // panel.getPanelInforme().add(tablaInforme);

            panel.refrescarPanel();
         }
         if (who == "m") {
            panel.getBntAnterior().setEnabled(true);
            contadorMedico++;
            // Recupera lista
            ArrayList<Medico> listaRecuperada;
            listaRecuperada = new ArrayList<>();
            archivosMedico = new ManejarArchivoMedico();
            try {
               listaRecuperada = archivosMedico.getListaMedico();
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            // se usa lista en la tabla
            Object[][] filas = {
                  { "Nombre", listaRecuperada.get(contadorMedico).getNombre() },
                  { "Apellido", listaRecuperada.get(contadorMedico).getApellidos() },
                  { "Teléfono", listaRecuperada.get(contadorMedico).getTelefono() },
                  { "Cedula", listaRecuperada.get(contadorMedico).getCedula() },
                  { "Ciudad", listaRecuperada.get(contadorMedico).getCiudad() },
                  { "Calle", listaRecuperada.get(contadorMedico).getCalle() },
                  { "Número", listaRecuperada.get(contadorMedico).getNumero() },
                  { "Licencia", listaRecuperada.get(contadorMedico).getLicencia() },
                  { "Especialidad", listaRecuperada.get(contadorMedico).getEspecialidad() },
                  { "Años", listaRecuperada.get(contadorMedico).getAnios() },
                  { "Meses", listaRecuperada.get(contadorMedico).getMeses() },
                  { "Hora de inicio", listaRecuperada.get(contadorMedico).getHoraInicio() },
                  { "Hora de salida", listaRecuperada.get(contadorMedico).getHoraFin() },
                  {"Carnet", listaRecuperada.get(contadorMedico).getCarnet()}
            };
            try {
               if (comprobarContadorSuma("m")) {
                  panel.getBtnSiguiente().setEnabled(false);
               }
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            JTable tablaInforme = new JTable(filas, columnas);
            tablaInforme.setEnabled(false);
            tablaInforme.setRowSelectionAllowed(false);
            tablaInforme.setFont(new Font("Aharoni", 0, 30));
            tablaInforme.setRowHeight(20);
            tablaInforme.getColumnModel().getColumn(0).setPreferredWidth(400);
            tablaInforme.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaInforme.setRowHeight(50);

            panel.removerTabla();
            panel.addNewTabla(tablaInforme);
            panel.refrescarPanel();
         }
      }
      if (e.getSource() == panel.getBntAnterior()) {
         if (who == "p") {

            contadorPaciente--;
            ArrayList<Paciente> listaRecuperada;
            listaRecuperada = new ArrayList<>();
            archivosPaciente = new ManejarArchivoPaciente();
            try {
               listaRecuperada = archivosPaciente.getListaPaciente();
               if (comprobarContadorSuma("p") == false) {
                  panel.getBtnSiguiente().setEnabled(true);
               }
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            String esAlergico;
            if (listaRecuperada.get(contadorPaciente).getEsAlergico() == true) {
               esAlergico = "Si";
            } else {
               esAlergico = "No";
            }
            Object[][] filas = {
                  { "Nombre", listaRecuperada.get(contadorPaciente).getNombre() },
                  { "Apellido", listaRecuperada.get(contadorPaciente).getApellidos() },
                  { "Teléfono", listaRecuperada.get(contadorPaciente).getTelefono() },
                  { "Cedula", listaRecuperada.get(contadorPaciente).getCedula() },
                  { "Es Alergico", esAlergico },
                  { "Total Vacunas Covid", listaRecuperada.get(contadorPaciente).getTotalVacunasCovid() },
                  { "Ciudad", listaRecuperada.get(contadorPaciente).getCiudad() },
                  { "Calle", listaRecuperada.get(contadorPaciente).getCalle() },
                  { "Número", listaRecuperada.get(contadorPaciente).getNumero() },
                  {"Carnet", listaRecuperada.get(contadorPaciente).getCarnet()}
            };
            JTable tablaInforme = new JTable(filas, columnas);
            tablaInforme.setEnabled(false);
            tablaInforme.setRowSelectionAllowed(false);
            tablaInforme.setFont(new Font("Aharoni", 0, 30));
            tablaInforme.setRowHeight(20);
            tablaInforme.getColumnModel().getColumn(0).setPreferredWidth(400);
            tablaInforme.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaInforme.setRowHeight(50);
            panel.removerTabla();

            panel.addNewTabla(tablaInforme);

            panel.refrescarPanel();
            if (comprobarContadorResta("p")) {
               panel.getBntAnterior().setEnabled(false);
            }
         }
         if (who == "m") {
            contadorMedico--;
            ArrayList<Medico> listaRecuperada;
            listaRecuperada = new ArrayList<>();
            archivosMedico = new ManejarArchivoMedico();
            try {
               listaRecuperada = archivosMedico.getListaMedico();
               if (comprobarContadorSuma("m") == false) {
                  panel.getBtnSiguiente().setEnabled(true);
               }
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            // se crea un objeto con los valores a agrear en la tabla
            Object[][] filas = {
                  { "Nombre", listaRecuperada.get(contadorMedico).getNombre() },
                  { "Apellido", listaRecuperada.get(contadorMedico).getApellidos() },
                  { "Teléfono", listaRecuperada.get(contadorMedico).getTelefono() },
                  { "Cedula", listaRecuperada.get(contadorMedico).getCedula() },
                  { "Ciudad", listaRecuperada.get(contadorMedico).getCiudad() },
                  { "Calle", listaRecuperada.get(contadorMedico).getCalle() },
                  { "Número", listaRecuperada.get(contadorMedico).getNumero() },
                  { "Licencia", listaRecuperada.get(contadorMedico).getLicencia() },
                  { "Especialidad", listaRecuperada.get(contadorMedico).getEspecialidad() },
                  { "Años", listaRecuperada.get(contadorMedico).getAnios() },
                  { "Meses", listaRecuperada.get(contadorMedico).getMeses() },
                  { "Hora de inicio", listaRecuperada.get(contadorMedico).getHoraInicio() },
                  { "Hora de salida", listaRecuperada.get(contadorMedico).getHoraFin() },
                  {"Carnet", listaRecuperada.get(contadorMedico).getCarnet()}
            };
            //Se le da formato a la nueva tabla 
            JTable tablaInforme = new JTable(filas, columnas);
            tablaInforme.setEnabled(false);
            tablaInforme.setRowSelectionAllowed(false);
            tablaInforme.setFont(new Font("Aharoni", 0, 30));
            tablaInforme.setRowHeight(20);
            tablaInforme.getColumnModel().getColumn(0).setPreferredWidth(400);
            tablaInforme.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaInforme.setRowHeight(50);
            //se añade la nueva tabla
            panel.removerTabla();
            panel.addNewTabla(tablaInforme);
            panel.refrescarPanel();
            //comprueba contador resta para ver si se necesita o no desactivar el btn
            if (comprobarContadorResta("m")) {
               panel.getBntAnterior().setEnabled(false);
            }
         }
      }

   }

   /**
    * Permite comprobar si el contador es igual al tamaño de la lista ya sea de
    * pacientes o de medicos recibe como parametro "p" si debe comprobar la lista
    * de pacientes o "m"si debe comprobar la de medicos
    * 
    * @param who String
    * @return boolean
    * @throws ClassNotFoundException
    * @throws IOException
    */
   public boolean comprobarContadorSuma(String who) throws ClassNotFoundException, IOException {
      boolean esIgual = false;
      if (who == "p") {
         ArrayList<Paciente> listaRecuperada;
         listaRecuperada = new ArrayList<>();
         archivosPaciente = new ManejarArchivoPaciente();
         listaRecuperada = archivosPaciente.getListaPaciente();
         if (contadorPaciente == listaRecuperada.size() - 1) {
            esIgual = true;
         }
      }
      if (who == "m") {
         ArrayList<Medico> listaRecuperada;
         listaRecuperada = new ArrayList<>();
         archivosMedico = new ManejarArchivoMedico();
         listaRecuperada = archivosMedico.getListaMedico();
         if (contadorMedico == listaRecuperada.size() - 1) {
            esIgual = true;
         }
      }
      return esIgual;
   }

   /**
    * Comprueba si el contador es igual a 0, recibe como parametro un String "p" o "m"
    * 
    * @param who String
    * @return boolean
    */
   public boolean comprobarContadorResta(String who) {
      boolean esIgual = false;
      if (who == "p") {
         if (contadorPaciente == 0) {
            esIgual = true;
         }
      }
      if (who == "m") {
         if (contadorMedico == 0) {
            esIgual = true;
         }
      }
      return esIgual;
   }
}
