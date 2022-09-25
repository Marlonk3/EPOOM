
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Permite crear un panel para actualizar los datos de los medicos
 * 
 * Creado el 12 de Septiembre del 2022, 20:47 horas
 * @author erick Erik Andre Barroso Castillo
 */
public class ActualizarMedico extends JPanel{
    private TipoSeccionPanel principalPanel ;
    private JPanel contenedorPrincipal, barraBusquedaCont, pnlCentral,pnlImagen;
    private JTextField barraBusqueda;
    private JButton btnBuscar;
    private AgregarNuevoMedico pnlEditar;
   /**
    * Constructor que permite recibe como parametro un String el cual es el nombre de la sección
    * @param nombreSeccion
    */
    public ActualizarMedico(String nombreSeccion){
        initComponets(nombreSeccion);
    }
    private void  initComponets(String nombreSeccion){
        setSize(1200, 700);
        pnlCentral = new JPanel(new BorderLayout());
        pnlImagen = new JPanel(new BorderLayout());
        pnlCentral.setOpaque(false);
        principalPanel= new TipoSeccionPanel("/Img/BackgroundPaciente2.jpg",nombreSeccion);
        setLayout(new BorderLayout());
        pnlEditar = new AgregarNuevoMedico();
        pnlEditar.getBarraSeccion().getTituloJLabel().setText("Datos del Paciente");
        contenedorPrincipal= new JPanel(new BorderLayout());
        contenedorPrincipal.setOpaque(false);
        agregandoBarraDeBusqueda();
        principalPanel.getImagenFondoPanel().add(contenedorPrincipal, BorderLayout.CENTER);
        add(principalPanel, BorderLayout.CENTER);
        //contenedorPrincipal.add(new TableBusqueda(filas),BorderLayout.CENTER);
    }
   /**
    * Permite agregar la barra de busqueda con el respectivo botón
    */
    private void agregandoBarraDeBusqueda(){

       barraBusquedaCont= new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
       barraBusquedaCont.setBackground( new Color(0,0,0,130));
       btnBuscar= new JButton("Buscar");
       ImageIcon imagenBuscar= new ImageIcon(BusCart.class.getResource("/Img/buscar.png"));
       btnBuscar.setIcon(new ImageIcon(imagenBuscar.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
       btnBuscar.setBackground(Color.WHITE);
       btnBuscar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));

       barraBusqueda= new JTextField(20);
       barraBusqueda.setFont(new Font("Aharoni", 0,28));
       barraBusquedaCont.add(barraBusqueda);
       barraBusquedaCont.add(btnBuscar);
       contenedorPrincipal.add(barraBusquedaCont,BorderLayout.NORTH);
       pnlImagen.add(new PnlBuscar(),BorderLayout.CENTER);
       pnlImagen.setOpaque(false);
       pnlCentral.add(pnlImagen);
       contenedorPrincipal.add(pnlCentral, BorderLayout.CENTER);

    }
    public TipoSeccionPanel getPrincipalPanel() {
       return principalPanel;
    }
    public void setPrincipalPanel(TipoSeccionPanel principalPanel) {
       this.principalPanel = principalPanel;
    }
    public JPanel getContenedorPrincipal() {
       return contenedorPrincipal;
    }
    public void setContenedorPrincipal(JPanel contenedorPrincipal) {
       this.contenedorPrincipal = contenedorPrincipal;
    }
    public JPanel getBarraBusquedaCont() {
       return barraBusquedaCont;
    }
    public void setBarraBusquedaCont(JPanel barraBusquedaCont) {
       this.barraBusquedaCont = barraBusquedaCont;
    }
    public JTextField getBarraBusqueda() {
       return barraBusqueda;
    }
    public void setBarraBusqueda(JTextField barraBusqueda) {
       this.barraBusqueda = barraBusqueda;
    }
    public JButton getBtnBuscar() {
       return btnBuscar;
    }
    public void setBtnBuscar(JButton btnBucar) {
       this.btnBuscar = btnBucar;
    }
    public void removePanelCentralImagen(){
     pnlCentral.remove(pnlImagen);
    }
    public void setPanelEditar(){
        pnlCentral.add(pnlEditar.getPrincipalCentralJPanel());
        contenedorPrincipal.add(pnlEditar.getBarraSouthGuardar(), BorderLayout.SOUTH);
    }
    public AgregarNuevoMedico getpnlEditar(){
        return pnlEditar;
    }
    public void removePanelEditar(){
        pnlCentral.remove(pnlEditar.getPrincipalCentralJPanel());
        contenedorPrincipal.remove(pnlEditar.getBarraSouthGuardar());
    }
    public void setPanelCentralImagen(){
        pnlCentral.add(pnlImagen);
    }
}
