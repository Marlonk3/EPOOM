/**
 * Permite realizar un panel el cual muestra los reportes paginados 
 * 
 * Creado el 12 de Septiembre del 2022, 20:47 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import files.ManejarArchivoMedico;
import files.ManejarArchivoPaciente;
import listeners.InformeListener;
import modelo.Medico;
import modelo.Paciente;

import java.awt.FlowLayout;

public class Informe extends JPanel {
   private TipoSeccionPanel principalPanel;
   private JScrollPane scroll;
   private JPanel panelCentral, panelInforme;
   private JButton btnSiguiente, bntAnterior;
   private JTable tablaInforme;
   private String[] columnas = {
         "Tipos", "Datos"
   };
   private Object[][] filas;
   private String nombreSeccion;
   private String who;
   private ManejarArchivoPaciente archivosPaciente;
   private ManejarArchivoMedico archivosMedico;
   private File archivoPaciente = new File("./src/Paciente.epf");
   private File archivoMedico = new File("./src/medico.epf");

   /**
    * Constructor por defecto
    */
   public Informe() {
   }

   /**
    * Constructor que permite recibir y dar valor las variables
    * 
    * @param who String
    */
   public Informe(String who) {
      this.who = who;

      initComponets();
      addListenerBtnInforme();
   }

   /**
    * Realiza las instancias y llamada necesarias para el JPanel
    * 
    */
   private void initComponets() {
      setSize(1200, 700);
      if (who == "p") {
         nombreSeccion = "Paciente";
      } else {
         nombreSeccion = "Medico";
      }

      principalPanel = new TipoSeccionPanel("/Img/BackgroundMedico2.jpg", nombreSeccion);
      setLayout(new BorderLayout());
      añadePanelCentral();

      add(principalPanel, BorderLayout.CENTER);
   }

   /**
    * Se coloca un ActionListener a los botone btnSiguiente y btnAnterior
    */
   private void addListenerBtnInforme() {
      InformeListener listener = new InformeListener(this, who);
      btnSiguiente.addActionListener(listener);
      bntAnterior.addActionListener(listener);
   }

   /**
    * Realiza las instancias necesarias para la parte principal y central del
    * JPanel
    * 
    * @param filas Object[][]
    */
   private void añadePanelCentral() {
      panelCentral = new JPanel(new BorderLayout());
      btnSiguiente = new JButton(">");
      btnSiguiente.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
      btnSiguiente.setBackground(Color.WHITE);
      bntAnterior = new JButton("<");
      bntAnterior.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
      bntAnterior.setBackground(Color.WHITE);


      // Añade tabla central de informes
      panelInforme = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 100));
      // Añade la primera instancia de la tabla por default si who es igual a "p"
      if (who == "p") {
         if (archivoPaciente.exists()) {
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
            if (listaRecuperada.get(0).getEsAlergico() == true) {
               esAlergico = "Si";
            } else {
               esAlergico = "No";
            }
            Object[][] nuevaFila = {
                  { "Nombre", listaRecuperada.get(0).getNombre() },
                  { "Apellido", listaRecuperada.get(0).getApellidos() },
                  { "Teléfono", listaRecuperada.get(0).getTelefono() },
                  { "Cedula", listaRecuperada.get(0).getCedula() },
                  { "Es Alergico", esAlergico },
                  { "Total Vacunas Covid", listaRecuperada.get(0).getTotalVacunasCovid() },
                  { "Ciudad", listaRecuperada.get(0).getCiudad() },
                  { "Calle", listaRecuperada.get(0).getCalle() },
                  { "Número", listaRecuperada.get(0).getNumero() },
                  { "Carnet", listaRecuperada.get(0).getCarnet() }
            };
            // Se igual la tabla por default con la variable local
            filas = nuevaFila;
            // Se desactiva el btn corde la necesidad
            bntAnterior.setEnabled(false);
            if (listaRecuperada.size() <= 1) {
               btnSiguiente.setEnabled(false);
               bntAnterior.setEnabled(false);
            }

         }

      }
      // Añade la primera instancia de la tabla por default si who es igual a "m"
      if (who == "m") {
         if (archivoMedico.exists()) {
            ArrayList<Medico> listaRecuperada;
            listaRecuperada = new ArrayList<>();
            archivosMedico = new ManejarArchivoMedico();
            try {
               listaRecuperada = archivosMedico.getListaMedico();
            } catch (ClassNotFoundException | IOException e1) {
               e1.printStackTrace();
            }
            // se usa lista en la tabla
            Object[][] nuevaFila = {
                  { "Nombre", listaRecuperada.get(0).getNombre() },
                  { "Apellido", listaRecuperada.get(0).getApellidos() },
                  { "Teléfono", listaRecuperada.get(0).getTelefono() },
                  { "Cedula", listaRecuperada.get(0).getCedula() },
                  { "Ciudad", listaRecuperada.get(0).getCiudad() },
                  { "Calle", listaRecuperada.get(0).getCalle() },
                  { "Número", listaRecuperada.get(0).getNumero() },
                  { "Licencia", listaRecuperada.get(0).getLicencia() },
                  { "Especialidad", listaRecuperada.get(0).getEspecialidad() },
                  { "Años", listaRecuperada.get(0).getAnios() },
                  { "Meses", listaRecuperada.get(0).getMeses() },
                  { "Hora de inicio", listaRecuperada.get(0).getHoraInicio() },
                  { "Hora de salida", listaRecuperada.get(0).getHoraFin() },
                  { "Carnet", listaRecuperada.get(0).getCarnet() }
            };
            // Se igual la tabla por default con la variable local
            filas = nuevaFila;
            // Se desactiva el btn corde la necesidad
            bntAnterior.setEnabled(false);
            if (listaRecuperada.size() <= 1) {
               btnSiguiente.setEnabled(false);
               bntAnterior.setEnabled(false);
            }
         }
      }

      tablaInforme = new JTable(filas, columnas);
      tablaInforme.setEnabled(false);
      panelInforme.add(tablaInforme);
      tablaInforme.setRowSelectionAllowed(false);
      tablaInforme.setFont(new Font("Aharoni", 0, 30));
      tablaInforme.setRowHeight(20);
      tablaInforme.getColumnModel().getColumn(0).setPreferredWidth(400);
      tablaInforme.getColumnModel().getColumn(1).setPreferredWidth(400);
      panelInforme.setOpaque(false);
      tablaInforme.setRowHeight(50);
      scroll = new JScrollPane(panelInforme);
      scroll.getVerticalScrollBar().setUnitIncrement(16);

      panelCentral.add(btnSiguiente, BorderLayout.EAST);
      panelCentral.add(bntAnterior, BorderLayout.WEST);
      panelCentral.add(scroll, BorderLayout.CENTER);
      principalPanel.getImagenFondoPanel().add(panelCentral, BorderLayout.CENTER);
   }

   /**
    * Permite remover la tabla del panelInforme
    */
   public void removerTabla() {
      panelInforme.remove(tablaInforme);
   }

   /**
    * Añade una nueva tabla a panelInforme
    * 
    * @param tabla JTable
    */
   public void addNewTabla(JTable tabla) {
      tablaInforme = tabla;
      panelInforme.add(tablaInforme);
   }

   /**
    * Refresca el ScrollPanel
    */
   public void refrescarPanel() {
      SwingUtilities.updateComponentTreeUI(scroll);
      scroll.validate();
   }

   /*** Getter and Setter * */
   public TipoSeccionPanel getPrincipalPanel() {
      return principalPanel;
   }

   public void setPrincipalPanel(TipoSeccionPanel principalPanel) {
      this.principalPanel = principalPanel;
   }

   public JScrollPane getScroll() {
      return scroll;
   }

   public void setScroll(JScrollPane scroll) {
      this.scroll = scroll;
   }

   public JPanel getPanelCentral() {
      return panelCentral;
   }

   public void setPanelCentral(JPanel panelCentral) {
      this.panelCentral = panelCentral;
   }

   public JPanel getPanelInforme() {
      return panelInforme;
   }

   public void setPanelInforme(JPanel panelInforme) {
      this.panelInforme = panelInforme;
   }

   public JButton getBtnSiguiente() {
      return btnSiguiente;
   }

   public void setBtnSiguiente(JButton btnSiguiente) {
      this.btnSiguiente = btnSiguiente;
   }

   public JButton getBntAnterior() {
      return bntAnterior;
   }

   public void setBntAnterior(JButton bntAnterior) {
      this.bntAnterior = bntAnterior;
   }

   public JTable getTablaInforme() {
      return tablaInforme;
   }

   public void setTablaInforme(JTable tablaInforme) {
      this.tablaInforme = tablaInforme;
   }

   public String[] getColumnas() {
      return columnas;
   }

   public void setColumnas(String[] columnas) {
      this.columnas = columnas;
   }

   public Object[][] getFilas() {
      return filas;
   }

   public void setFilas(Object[][] filas) {
      this.filas = filas;
   }

   public String getNombreSeccion() {
      return nombreSeccion;
   }

   public void setNombreSeccion(String nombreSeccion) {
      this.nombreSeccion = nombreSeccion;
   }

}
