/**
 * Permite realizar un panel el cual recibe como parametro un objeto para luego llenar una tabla con diferentes valores
 * 
 * Creado el 12 de Septiembre del 2022, 16:47 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */

package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
public class TableBusqueda extends JPanel{
   private Object[][] filas;
   private String []columnas={
      "Tipos", "Datos"
   };

   private JTable tablaDatos;
   private JScrollPane scroll;
   private JPanel  relleno1, relleno2, relleno3, relleno4;
   /**
    * Cosntructrio por defecto
    */
   public TableBusqueda(){}
   /**
    * Constructor que recibe como paramentro un Objeto para posteriormente llenar la tabla con la busqueda realizada
    * @param filas Object []
    */
   public TableBusqueda(Object [][] filas){
      this.filas=filas;
      initcomponets();
   }
   /**
    * Permite realizar las instancias y llamados necesarios para realizar la tabla del paciente-medico buscado
    * @param filas
    */
   private void initcomponets(/*Object [][] filas*/){
      setLayout(new BorderLayout());
      tablaDatos= new JTable(filas, columnas);
      tablaDatos.setRowSelectionAllowed(false);
      setBackground(new Color(0,0,0,130));
      tablaDatos.setFont(new Font("Aharoni", 0,15));
      tablaDatos.setRowHeight(20);
      tablaDatos.setEnabled(false);
      scroll= new JScrollPane(tablaDatos);
      add(scroll,BorderLayout.CENTER);
      rellenoBorders();
   }
   /**
    * Permite rellenar los borders del panel central para que este tenga mejor aspecto
    */
   private void rellenoBorders(){
      relleno1 = new JPanel();
      relleno1.add(new JLabel("  "));
      relleno1.setOpaque(false);
      add(relleno1,BorderLayout.NORTH);
      relleno2= new JPanel();
      relleno2.add(new JLabel("  "));
      relleno2.setOpaque(false);
      add(relleno2,BorderLayout.SOUTH);
      relleno3= new JPanel();
      relleno3.add(new JLabel("  "));
      relleno3.setOpaque(false);
      add(relleno3, BorderLayout.EAST);
      relleno4= new JPanel();
      relleno4.setOpaque(false);
      relleno4.add(new JLabel("  "));
      add(relleno4, BorderLayout.WEST);
   }
   public String[] getColumnas() {
      return columnas;
   }
   public void setColumnas(String[] columnas) {
      this.columnas = columnas;
   }
   public JTable getTablaDatos() {
      return tablaDatos;
   }
   public void setTablaDatos(JTable tablaDatos) {
      this.tablaDatos = tablaDatos;
   }
   public JScrollPane getScroll() {
      return scroll;
   }
   public void setScroll(JScrollPane scroll) {
      this.scroll = scroll;
   }
   public JPanel getRelleno1() {
      return relleno1;
   }
   public void setRelleno1(JPanel relleno1) {
      this.relleno1 = relleno1;
   }
   public JPanel getRelleno2() {
      return relleno2;
   }
   public void setRelleno2(JPanel relleno2) {
      this.relleno2 = relleno2;
   }
   public JPanel getRelleno3() {
      return relleno3;
   }
   public void setRelleno3(JPanel relleno3) {
      this.relleno3 = relleno3;
   }
   public JPanel getRelleno4() {
      return relleno4;
   }
   public void setRelleno4(JPanel relleno4) {
      this.relleno4 = relleno4;
   }
   public Object[][] getFilas() {
      return filas;
   }
   public void setFilas(Object[][] filas) {
      this.filas = filas;
   }
   
}
