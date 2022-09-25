/**
 * Permite crea un JPanel para Crear un nuevo medico
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 */

package gui;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Especialidad;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class AgregarNuevoMedico extends JPanel{
   private TipoSeccionPanel barraSeccion;
   private JPanel principalCentralJPanel, nombreContenedorJPanel, contenedorTextNombre, contenedorApellidosJPanel, conetenedorPanelApellidoF, contenedortelefono, contenedorTextTelefoJPanel, contenedorCedulaJPanel, contenedorTextCedulPanel, barraSouthGuardar, contenedorCiudadJPanel, contenedorTxtCiudadJPanel, contenedorCalleJPanel, contenedorTxtCalle, contenedorNumeroJPanel, contenedorTxtNumeroJPanel, contenedorLicencia, contenedorTxtLicencia, contenedorEspecialidad, conteTxtEspecialidad, contAnios, contTxtAnios, contMeses, contTxtMeses, contHoraInicio, contTxtHoraInicio, contHoraFin, contTxtHoraFin;
   private JLabel nombreJLabel, apellidoJLabel, telefonoJLabel, ceduJLabel, especialidadJLabel, ciudadJLabel, calleJLabel, numeroJLabel, licenciaJLabel, aniosJLabel, mesesJLabel, horaInicioJLabel, horaFinJLabel;
   private JTextField nombreTextFiedl, apellidoTextField, telefonoTextField, cedulaTextField, ciudadTextField, callTextField, numeroJTextField, licenciaTextField, aniosTextField, mesesTextField, horaInicioTextField, horaFinTextField;
   private FlowLayout flowStyle = new FlowLayout(FlowLayout.CENTER, 0, 5);
   private Font txtFont = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
   private Font fieldtxtFont = new Font("Aharoni", 0,25);
   private JButton btnGuardar;
   private Color backgroundColor= new Color(0,0,0,130);
   private JComboBox<String> especialidadBox;
   /**
    * Constructor que permite llamar a la la función initComponents para poder inicializar los companentes
    */
   public AgregarNuevoMedico (){
      
      initComponents();
   }
   /**
    * Función que permite realizar las instancias y llamados necesarios para inicializar el JPanel 
    */
   private void initComponents(){
        setSize(1200, 700);
        barraSeccion= new TipoSeccionPanel("/Img/BackgroundMedico.jpg", "Medicos");//cambiar-backgroundSeccion, nombreSeccion
        setLayout(new BorderLayout());
      
        principalCentralJPanel = new JPanel(new GridLayout(13,2/*, 5,5*/));
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

        contenedorLicencia= new JPanel(flowStyle);
        contenedorLicencia.setOpaque(false);
        licenciaJLabel= new JLabel("Licencia:");
        licenciaJLabel.setFont(txtFont);
        licenciaJLabel.setForeground(Color.white);
        contenedorLicencia.add(licenciaJLabel);

        contenedorTxtLicencia= new JPanel(flowStyle);
        contenedorTxtLicencia.setOpaque(false);
        licenciaTextField= new JTextField(23);
        licenciaTextField.setFont(fieldtxtFont);
        licenciaTextField.setHorizontalAlignment(JTextField.CENTER);
        contenedorTxtLicencia.add(licenciaTextField);

        contenedorEspecialidad= new JPanel(flowStyle);
        contenedorEspecialidad.setOpaque(false);
        especialidadJLabel= new JLabel("Especialidad:");
        especialidadJLabel.setFont(txtFont);
        especialidadJLabel.setForeground(Color.white);
        contenedorEspecialidad.add(especialidadJLabel);

        conteTxtEspecialidad= new JPanel(flowStyle);
        conteTxtEspecialidad.setOpaque(false);
        especialidadBox = new JComboBox<>();
        especialidadBox.setFont(fieldtxtFont);
        especialidadBox.addItem("--Selecione--");
        for(Especialidad e: Especialidad.values()){
           especialidadBox.addItem(e.getEspecialidad());
        }
        conteTxtEspecialidad.add(especialidadBox);

        contAnios= new JPanel(flowStyle);
        contAnios.setOpaque(false);
        aniosJLabel= new JLabel("Años:");
        aniosJLabel.setFont(txtFont);
        aniosJLabel.setForeground(Color.white);
        contAnios.add(aniosJLabel);

        contTxtAnios= new JPanel(flowStyle);
        contTxtAnios.setOpaque(false);
        aniosTextField= new JTextField(2);
        aniosTextField.setFont(fieldtxtFont);
        aniosTextField.setHorizontalAlignment(JTextField.CENTER);
        contTxtAnios.add(aniosTextField);

        contMeses= new JPanel(flowStyle);
        contMeses.setOpaque(false);
        mesesJLabel= new JLabel("Meses:");
        mesesJLabel.setFont(txtFont);
        mesesJLabel.setForeground(Color.white);
        contMeses.add(mesesJLabel);

        contTxtMeses= new JPanel(flowStyle);
        contTxtMeses.setOpaque(false);
        mesesTextField= new JTextField(2);
        mesesTextField.setFont(fieldtxtFont);
        mesesTextField.setHorizontalAlignment(JTextField.CENTER);
        contTxtMeses.add(mesesTextField);

        contHoraInicio= new JPanel(flowStyle);
        contHoraInicio.setOpaque(false);
        horaInicioJLabel= new JLabel("Hora de inicio:");
        horaInicioJLabel.setFont(txtFont);
        horaInicioJLabel.setForeground(Color.white);
        contHoraInicio.add(horaInicioJLabel);

        contTxtHoraInicio= new JPanel(flowStyle);
        contTxtHoraInicio.setOpaque(false);
        horaInicioTextField= new JTextField(4);
        horaInicioTextField.setFont(fieldtxtFont);
        horaInicioTextField.setHorizontalAlignment(JTextField.CENTER);
        contTxtHoraInicio.add(horaInicioTextField);

        contHoraFin= new JPanel(flowStyle);
        contHoraFin.setOpaque(false);
        horaFinJLabel=new JLabel("Hora de salida:");
        horaFinJLabel.setFont(txtFont);
        horaFinJLabel.setForeground(Color.white);
        contHoraFin.add(horaFinJLabel);

        contTxtHoraFin= new JPanel(flowStyle);
        contTxtHoraFin.setOpaque(false);
        horaFinTextField= new JTextField(4);
        horaFinTextField.setFont(fieldtxtFont);
        horaFinTextField.setHorizontalAlignment(JTextField.CENTER);
        contTxtHoraFin.add(horaFinTextField);

        principalCentralJPanel.add(nombreContenedorJPanel);
        principalCentralJPanel.add(contenedorTextNombre);
        principalCentralJPanel.add(contenedorApellidosJPanel);
        principalCentralJPanel.add(conetenedorPanelApellidoF);
        principalCentralJPanel.add(contenedortelefono);
        principalCentralJPanel.add(contenedorTextTelefoJPanel);
        principalCentralJPanel.add(contenedorCedulaJPanel);
        principalCentralJPanel.add(contenedorTextCedulPanel);
        principalCentralJPanel.add(contenedorCiudadJPanel);
        principalCentralJPanel.add(contenedorTxtCiudadJPanel);
        principalCentralJPanel.add(contenedorCalleJPanel);
        principalCentralJPanel.add(contenedorTxtCalle);
        principalCentralJPanel.add(contenedorNumeroJPanel);
        principalCentralJPanel.add(contenedorTxtNumeroJPanel);
        principalCentralJPanel.add(contenedorLicencia);
        principalCentralJPanel.add(contenedorTxtLicencia);
        principalCentralJPanel.add(contenedorEspecialidad);
        principalCentralJPanel.add(conteTxtEspecialidad);
        principalCentralJPanel.add(contAnios);
        principalCentralJPanel.add(contTxtAnios);
        principalCentralJPanel.add(contMeses);
        principalCentralJPanel.add(contTxtMeses);
        principalCentralJPanel.add(contHoraInicio);
        principalCentralJPanel.add(contTxtHoraInicio);
        principalCentralJPanel.add(contHoraFin);
        principalCentralJPanel.add(contTxtHoraFin);

        barraSeccion.getImagenFondoPanel().add(principalCentralJPanel,BorderLayout.CENTER);
        barraSeccion.getImagenFondoPanel().add(barraSouthGuardar,BorderLayout.SOUTH);
        add(barraSeccion, BorderLayout.CENTER);
   }

    public JTextField getNombreTextFiedl() {
        return nombreTextFiedl;
    }

    public JTextField getApellidoTextField() {
        return apellidoTextField;
    }

    public JTextField getTelefonoTextField() {
        return telefonoTextField;
    }

    public JTextField getCedulaTextField() {
        return cedulaTextField;
    }

    public JTextField getCiudadTextField() {
        return ciudadTextField;
    }

    public JTextField getCallTextField() {
        return callTextField;
    }

    public JTextField getNumeroJTextField() {
        return numeroJTextField;
    }

    public JTextField getLicenciaTextField() {
        return licenciaTextField;
    }

    public JTextField getAniosTextField() {
        return aniosTextField;
    }

    public JTextField getMesesTextField() {
        return mesesTextField;
    }

    public JTextField getHoraInicioTextField() {
        return horaInicioTextField;
    }

    public JTextField getHoraFinTextField() {
        return horaFinTextField;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JComboBox<String> getEspecialidadBox() {
        return especialidadBox;
    }
   
    public TipoSeccionPanel getBarraSeccion(){
        return barraSeccion;
    }
    public JPanel getPrincipalCentralJPanel(){
        return principalCentralJPanel;
    }
    public JPanel getBarraSouthGuardar(){
        return barraSouthGuardar;
    }
}
