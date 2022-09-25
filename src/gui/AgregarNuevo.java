 /**
 * 
 * Grea un JPanel que permite dar a conocer la interfaz grafica que expone al dar click en Boton nuevo medico, dado que muestra el fromulario para poder crear un nuevo medico
 * 
 * Creado el 7 de Septiembre del 2022, 18:20 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 *
 */
package gui;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class AgregarNuevo extends JPanel{
   private TipoSeccionPanel barraSeccion;
   private JPanel principalCentralJPanel, nombreContenedorJPanel, contenedorTextNombre, contenedorApellidosJPanel, conetenedorPanelApellidoF, contenedortelefono, contenedorTextTelefoJPanel, contenedorCedulaJPanel, contenedorTextCedulPanel, contenedorEsAlergicoJPanel, contenedorOpcionesEsAlergicoJPanel, contenedorTotalVacunas, contenedorTxtcuantasVacunas, barraSouthGuardar, contenedorCiudadJPanel, contenedorTxtCiudadJPanel, contenedorCalleJPanel, contenedorTxtCalle, contenedorNumeroJPanel, contenedorTxtNumeroJPanel;
   private JLabel nombreJLabel, apellidoJLabel, telefonoJLabel, ceduJLabel, esAlergicoJLabel, totalVacunas, ciudadJLabel, calleJLabel, numeroJLabel;
   private JTextField nombreTextFiedl, apellidoTextField, telefonoTextField, cedulaTextField, cuantasVacunasCovField, ciudadTextField, callTextField, numeroJTextField;
   private FlowLayout flowStyle = new FlowLayout(FlowLayout.CENTER, 0, 15);
   private Font txtFont = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
   private Font fieldtxtFont = new Font("Aharoni", 0,25);
   private JRadioButton opcionesSiEsAlergico, opcionesNoEsAlergico;
   private ButtonGroup opcionesEsAlergicGroup;
   private JButton btnGuardar;
   private Color backgroundColor= new Color(0,0,0,130);

   /**
    * Constructor que permite llamar a la la función initComponents para poder inicializar los companentes
    */
   public AgregarNuevo (){//String backgroundSeccion, String nombreSeccion
      
      initComponents();//backgroundSeccion, nombreSeccion
   }
   /**
    * Función que permite realizar las instancias y llamados necesarios para inicializar el JPanel 
    */
    private void initComponents(){//String backgroundSeccion, String nombreSeccion
      //setSize(800,500);

      barraSeccion= new TipoSeccionPanel("/Img/BackgroundPaciente.jpg", "Pacientes");//cambiar-backgroundSeccion, nombreSeccion
      setLayout(new BorderLayout());

      principalCentralJPanel = new JPanel(new GridLayout(9,2/*, 5,5*/));
      principalCentralJPanel.setBackground(backgroundColor);
      barraSouthGuardar= new JPanel(flowStyle);
      barraSouthGuardar.setBackground(backgroundColor);
      
      btnGuardar= new JButton("Guardar");
      btnGuardar.setFont(txtFont);
      btnGuardar.setForeground(barraSeccion.getTituloJLabel().getForeground());
      btnGuardar.setBackground(Color.white);
      ImageIcon imgGuardar= new ImageIcon(MainPanel.class.getResource("/Img/BotonGuardar.png"));
      btnGuardar.setIcon(new ImageIcon(imgGuardar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
      barraSouthGuardar.add(btnGuardar);

      nombreContenedorJPanel = new JPanel(flowStyle);
      nombreJLabel= new JLabel("Nombre:");
      nombreJLabel.setFont(txtFont);
      nombreJLabel.setForeground(Color.white);

      nombreContenedorJPanel.setOpaque(false);
      nombreContenedorJPanel.add(nombreJLabel);
      contenedorTextNombre = new JPanel(flowStyle);
      contenedorTextNombre.setOpaque(false);
      
      nombreTextFiedl= new JTextField(23);
      
      
      nombreTextFiedl.setFont(fieldtxtFont);
      nombreTextFiedl.setForeground(Color.black);
      nombreTextFiedl.setHorizontalAlignment(JTextField.CENTER);
      contenedorTextNombre.add(nombreTextFiedl);
      
      apellidoJLabel = new JLabel("Apellidos:");
      apellidoJLabel.setFont(txtFont);
      apellidoJLabel.setForeground(Color.white);
      contenedorApellidosJPanel= new JPanel(flowStyle);
      contenedorApellidosJPanel.setOpaque(false);
      contenedorApellidosJPanel.add(apellidoJLabel);
      conetenedorPanelApellidoF= new JPanel(flowStyle);
      conetenedorPanelApellidoF.setOpaque(false);
      apellidoTextField = new JTextField(23);
      apellidoTextField.setFont(fieldtxtFont);
      apellidoTextField.setHorizontalAlignment(JTextField.CENTER);
      
      conetenedorPanelApellidoF.add(apellidoTextField);
      
      contenedortelefono= new JPanel(flowStyle);
      telefonoJLabel = new JLabel("Teléfono:");
      telefonoJLabel.setFont(txtFont);
      telefonoJLabel.setForeground(Color.white);
      contenedortelefono.setOpaque(false);
      contenedortelefono.add(telefonoJLabel);

      contenedorTextTelefoJPanel= new JPanel(flowStyle);
      contenedorTextTelefoJPanel.setOpaque(false);
      telefonoTextField= new JTextField(23);
      telefonoTextField.setFont(fieldtxtFont);
      telefonoTextField.setHorizontalAlignment(JTextField.CENTER);
      contenedorTextTelefoJPanel.add(telefonoTextField);

      contenedorCedulaJPanel= new JPanel(flowStyle);
      contenedorCedulaJPanel.setOpaque(false);
      ceduJLabel= new JLabel("Cédula:");
      ceduJLabel.setFont(txtFont);
      ceduJLabel.setForeground(Color.white);
      contenedorCedulaJPanel.add(ceduJLabel);

      contenedorTextCedulPanel = new JPanel(flowStyle);
      contenedorTextCedulPanel.setOpaque(false);
      cedulaTextField= new JTextField(23);
      cedulaTextField.setFont(fieldtxtFont);
      cedulaTextField.setHorizontalAlignment(JTextField.CENTER);
      contenedorTextCedulPanel.add(cedulaTextField);

      contenedorEsAlergicoJPanel= new JPanel(flowStyle);
      contenedorEsAlergicoJPanel.setOpaque(false);
      esAlergicoJLabel= new JLabel("Es Alergico:");
      esAlergicoJLabel.setFont(txtFont);
      esAlergicoJLabel.setForeground(Color.WHITE);
      contenedorEsAlergicoJPanel.add(esAlergicoJLabel);

      contenedorOpcionesEsAlergicoJPanel = new JPanel(flowStyle);
      contenedorOpcionesEsAlergicoJPanel.setOpaque(false);
      opcionesSiEsAlergico= new JRadioButton("Si");
      opcionesSiEsAlergico.setFont(txtFont);
      opcionesNoEsAlergico=new JRadioButton("No");
      opcionesNoEsAlergico.setFont(txtFont);
      opcionesEsAlergicGroup = new ButtonGroup();
      opcionesEsAlergicGroup.add(opcionesSiEsAlergico);
      opcionesEsAlergicGroup.add(opcionesNoEsAlergico);

      contenedorOpcionesEsAlergicoJPanel.add(opcionesSiEsAlergico);      
      contenedorOpcionesEsAlergicoJPanel.add(opcionesNoEsAlergico);

      contenedorTotalVacunas= new JPanel(flowStyle);
      contenedorTotalVacunas.setOpaque(false);
      totalVacunas =new JLabel("Total Vacunas Covid:");
      totalVacunas.setFont(txtFont);
      totalVacunas.setForeground(Color.white);

      contenedorTotalVacunas.add(totalVacunas);

      contenedorTxtcuantasVacunas= new JPanel(flowStyle);
      contenedorTxtcuantasVacunas.setOpaque(false);
      cuantasVacunasCovField= new JTextField(1);
      cuantasVacunasCovField.setFont(fieldtxtFont);
      cuantasVacunasCovField.setHorizontalAlignment(JTextField.CENTER);
      contenedorTxtcuantasVacunas.add(cuantasVacunasCovField);

      contenedorCiudadJPanel = new JPanel(flowStyle);
      contenedorCiudadJPanel.setOpaque(false);
      ciudadJLabel= new JLabel("Ciudad:");
      ciudadJLabel.setFont(txtFont);
      ciudadJLabel.setForeground(Color.white);
      contenedorCiudadJPanel.add(ciudadJLabel);

      contenedorTxtCiudadJPanel= new JPanel(flowStyle);
      contenedorTxtCiudadJPanel.setOpaque(false);
      ciudadTextField= new JTextField(23);
      ciudadTextField.setFont(fieldtxtFont);
      ciudadTextField.setHorizontalAlignment(JTextField.CENTER);
      contenedorTxtCiudadJPanel.add(ciudadTextField);

      contenedorCalleJPanel= new JPanel(flowStyle);
      contenedorCalleJPanel.setOpaque(false);
      calleJLabel= new JLabel("Calle:");
      calleJLabel.setFont(txtFont);
      calleJLabel.setForeground(Color.white);
      contenedorCalleJPanel.add(calleJLabel);

      contenedorTxtCalle = new JPanel(flowStyle);
      contenedorTxtCalle.setOpaque(false);
      callTextField = new JTextField(23);
      callTextField.setFont(fieldtxtFont);
      callTextField.setHorizontalAlignment(JTextField.CENTER);
      contenedorTxtCalle.add(callTextField);

      contenedorNumeroJPanel= new JPanel(flowStyle);
      contenedorNumeroJPanel.setOpaque(false);
      numeroJLabel= new JLabel("Número:");
      numeroJLabel.setFont(txtFont);
      numeroJLabel.setForeground(Color.WHITE);
      contenedorNumeroJPanel.add(numeroJLabel);

      contenedorTxtNumeroJPanel = new JPanel(flowStyle);
      contenedorTxtNumeroJPanel.setOpaque(false);
      numeroJTextField= new JTextField(23);
      numeroJTextField.setFont(fieldtxtFont);
      numeroJTextField.setHorizontalAlignment(JTextField.CENTER);
      contenedorTxtNumeroJPanel.add(numeroJTextField);

      principalCentralJPanel.add(nombreContenedorJPanel);
      principalCentralJPanel.add(contenedorTextNombre);
      principalCentralJPanel.add(contenedorApellidosJPanel);
      principalCentralJPanel.add(conetenedorPanelApellidoF);
      principalCentralJPanel.add(contenedortelefono);
      principalCentralJPanel.add(contenedorTextTelefoJPanel);
      principalCentralJPanel.add(contenedorCedulaJPanel);
      principalCentralJPanel.add(contenedorTextCedulPanel);
      principalCentralJPanel.add(contenedorEsAlergicoJPanel);
      principalCentralJPanel.add(contenedorOpcionesEsAlergicoJPanel);
      principalCentralJPanel.add(contenedorTotalVacunas);
      principalCentralJPanel.add(contenedorTxtcuantasVacunas);
      principalCentralJPanel.add(contenedorCiudadJPanel);
      principalCentralJPanel.add(contenedorTxtCiudadJPanel);
      principalCentralJPanel.add(contenedorCalleJPanel);
      principalCentralJPanel.add(contenedorTxtCalle);
      principalCentralJPanel.add(contenedorNumeroJPanel);
      principalCentralJPanel.add(contenedorTxtNumeroJPanel);

      barraSeccion.getImagenFondoPanel().add(principalCentralJPanel,BorderLayout.CENTER);
      barraSeccion.getImagenFondoPanel().add(barraSouthGuardar,BorderLayout.SOUTH);
      add(barraSeccion, BorderLayout.CENTER);
   }
   public TipoSeccionPanel getBarraSeccion() {
      return barraSeccion;
   }
   public void setBarraSeccion(TipoSeccionPanel barraSeccion) {
      this.barraSeccion = barraSeccion;
   }
   public JPanel getPrincipalCentralJPanel() {
      return principalCentralJPanel;
   }
   public void setPrincipalCentralJPanel(JPanel principalCentralJPanel) {
      this.principalCentralJPanel = principalCentralJPanel;
   }
   public JPanel getNombreContenedorJPanel() {
      return nombreContenedorJPanel;
   }
   public void setNombreContenedorJPanel(JPanel nombreContenedorJPanel) {
      this.nombreContenedorJPanel = nombreContenedorJPanel;
   }
   public JPanel getContenedorTextNombre() {
      return contenedorTextNombre;
   }
   public void setContenedorTextNombre(JPanel contenedorTextNombre) {
      this.contenedorTextNombre = contenedorTextNombre;
   }
   public JPanel getContenedorApellidosJPanel() {
      return contenedorApellidosJPanel;
   }
   public void setContenedorApellidosJPanel(JPanel contenedorApellidosJPanel) {
      this.contenedorApellidosJPanel = contenedorApellidosJPanel;
   }
   public JPanel getConetenedorPanelApellidoF() {
      return conetenedorPanelApellidoF;
   }
   public void setConetenedorPanelApellidoF(JPanel conetenedorPanelApellidoF) {
      this.conetenedorPanelApellidoF = conetenedorPanelApellidoF;
   }
   public JPanel getContenedortelefono() {
      return contenedortelefono;
   }
   public void setContenedortelefono(JPanel contenedortelefono) {
      this.contenedortelefono = contenedortelefono;
   }
   public JPanel getContenedorTextTelefoJPanel() {
      return contenedorTextTelefoJPanel;
   }
   public void setContenedorTextTelefoJPanel(JPanel contenedorTextTelefoJPanel) {
      this.contenedorTextTelefoJPanel = contenedorTextTelefoJPanel;
   }
   public JPanel getContenedorCedulaJPanel() {
      return contenedorCedulaJPanel;
   }
   public void setContenedorCedulaJPanel(JPanel contenedorCedulaJPanel) {
      this.contenedorCedulaJPanel = contenedorCedulaJPanel;
   }
   public JPanel getContenedorTextCedulPanel() {
      return contenedorTextCedulPanel;
   }
   public void setContenedorTextCedulPanel(JPanel contenedorTextCedulPanel) {
      this.contenedorTextCedulPanel = contenedorTextCedulPanel;
   }
   public JPanel getContenedorEsAlergicoJPanel() {
      return contenedorEsAlergicoJPanel;
   }
   public void setContenedorEsAlergicoJPanel(JPanel contenedorEsAlergicoJPanel) {
      this.contenedorEsAlergicoJPanel = contenedorEsAlergicoJPanel;
   }
   public JPanel getContenedorOpcionesEsAlergicoJPanel() {
      return contenedorOpcionesEsAlergicoJPanel;
   }
   public void setContenedorOpcionesEsAlergicoJPanel(JPanel contenedorOpcionesEsAlergicoJPanel) {
      this.contenedorOpcionesEsAlergicoJPanel = contenedorOpcionesEsAlergicoJPanel;
   }
   public JPanel getContenedorTotalVacunas() {
      return contenedorTotalVacunas;
   }
   public void setContenedorTotalVacunas(JPanel contenedorTotalVacunas) {
      this.contenedorTotalVacunas = contenedorTotalVacunas;
   }
   public JPanel getContenedorTxtcuantasVacunas() {
      return contenedorTxtcuantasVacunas;
   }
   public void setContenedorTxtcuantasVacunas(JPanel contenedorTxtcuantasVacunas) {
      this.contenedorTxtcuantasVacunas = contenedorTxtcuantasVacunas;
   }
   public JPanel getBarraSouthGuardar() {
      return barraSouthGuardar;
   }
   public void setBarraSouthGuardar(JPanel barraSouthGuardar) {
      this.barraSouthGuardar = barraSouthGuardar;
   }
   public JLabel getNombreJLabel() {
      return nombreJLabel;
   }
   public void setNombreJLabel(JLabel nombreJLabel) {
      this.nombreJLabel = nombreJLabel;
   }
   public JLabel getApellidoJLabel() {
      return apellidoJLabel;
   }
   public void setApellidoJLabel(JLabel apellidoJLabel) {
      this.apellidoJLabel = apellidoJLabel;
   }
   public JLabel getTelefonoJLabel() {
      return telefonoJLabel;
   }
   public void setTelefonoJLabel(JLabel telefonoJLabel) {
      this.telefonoJLabel = telefonoJLabel;
   }
   public JLabel getCeduJLabel() {
      return ceduJLabel;
   }
   public void setCeduJLabel(JLabel ceduJLabel) {
      this.ceduJLabel = ceduJLabel;
   }
   public JLabel getEsAlergicoJLabel() {
      return esAlergicoJLabel;
   }
   public void setEsAlergicoJLabel(JLabel esAlergicoJLabel) {
      this.esAlergicoJLabel = esAlergicoJLabel;
   }
   public JLabel getTotalVacunas() {
      return totalVacunas;
   }
   public void setTotalVacunas(JLabel totalVacunas) {
      this.totalVacunas = totalVacunas;
   }
   public JTextField getNombreTextFiedl() {
      return nombreTextFiedl;
   }
   public void setNombreTextFiedl(JTextField nombreTextFiedl) {
      this.nombreTextFiedl = nombreTextFiedl;
   }
   public JTextField getApellidoTextField() {
      return apellidoTextField;
   }
   public void setApellidoTextField(JTextField apellidoTextField) {
      this.apellidoTextField = apellidoTextField;
   }
   public JTextField getTelefonoTextField() {
      return telefonoTextField;
   }
   public void setTelefonoTextField(JTextField telefonoTextField) {
      this.telefonoTextField = telefonoTextField;
   }
   public JTextField getCedulaTextField() {
      return cedulaTextField;
   }
   public void setCedulaTextField(JTextField cedulaTextField) {
      this.cedulaTextField = cedulaTextField;
   }
   public JTextField getCuantasVacunasCovField() {
      return cuantasVacunasCovField;
   }
   public void setCuantasVacunasCovField(JTextField cuantasVacunasCovField) {
      this.cuantasVacunasCovField = cuantasVacunasCovField;
   }
   public FlowLayout getFlowStyle() {
      return flowStyle;
   }
   public void setFlowStyle(FlowLayout flowStyle) {
      this.flowStyle = flowStyle;
   }
   public Font getTxtFont() {
      return txtFont;
   }
   public void setTxtFont(Font txtFont) {
      this.txtFont = txtFont;
   }
   public Font getFieldtxtFont() {
      return fieldtxtFont;
   }
   public void setFieldtxtFont(Font fieldtxtFont) {
      this.fieldtxtFont = fieldtxtFont;
   }
   public JRadioButton getOpcionesSiEsAlergico() {
      return opcionesSiEsAlergico;
   }
   public void setOpcionesSiEsAlergico(JRadioButton opcionesSiEsAlergico) {
      this.opcionesSiEsAlergico = opcionesSiEsAlergico;
   }
   public JRadioButton getOpcionesNoEsAlergico() {
      return opcionesNoEsAlergico;
   }
   public void setOpcionesNoEsAlergico(JRadioButton opcionesNoEsAlergico) {
      this.opcionesNoEsAlergico = opcionesNoEsAlergico;
   }
   public ButtonGroup getOpcionesEsAlergicGroup() {
      return opcionesEsAlergicGroup;
   }
   public void setOpcionesEsAlergicGroup(ButtonGroup opcionesEsAlergicGroup) {
      this.opcionesEsAlergicGroup = opcionesEsAlergicGroup;
   }
   public JButton getBtnGuardar() {
      return btnGuardar;
   }
   public void setBtnGuardar(JButton btnGuardar) {
      this.btnGuardar = btnGuardar;
   }
   public Color getBackgroundColor() {
      return backgroundColor;
   }
   public void setBackgroundColor(Color backgroundColor) {
      this.backgroundColor = backgroundColor;
   }
   public JTextField getCiudad() {
	   return ciudadTextField;  
   }
   public JTextField getCalle() {
	   return callTextField;  
   }
   public JTextField getNumero() {
	   return numeroJTextField;  
   }
  
}
