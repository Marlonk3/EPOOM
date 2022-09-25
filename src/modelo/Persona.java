/**
 * Clase Persona con sus atributos y métodos accesores
 * 
 * Creado el 28 de Agosto del 2022, 13:34 horas
 * 
 * @author Erik Andre Barroso Castillo
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */
package modelo;
import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.Random;
import javax.swing.JOptionPane;
public abstract class Persona implements Serializable{
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String cedula;
    protected String carnet;
    protected Direccion direccion = new Direccion();
    
    /**
     * Constructor vacio
     */
    public Persona(){}
    
    /**
     * Contructor que recibe las variables como parámetros para asignar valores a los atributos de la clase Persona
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param cedula
     * @param calle 
     * @param ciudad 
     * @param numero 
     */
    public Persona(String nombre, String apellidos, String telefono, String cedula, String calle, String ciudad, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cedula = cedula;
        direccion.setCalle(calle);
        direccion.setCiudad(ciudad);
        direccion.setNumero(numero);
        generarCarnet();
    }
    
    /**
     * Método getNombre: retorna una cadena de carácteres del atributo nombre.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método getApellidos: retorna el valor del atributo apellidos.
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    
    /**
     * Método getTelefono: retorna el valor del atributo teléfono.
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Método getCedula: retorna el valor del atributo cedula.
     * @return cédula
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Método getCarnet: retorna el valor del atributo carnet
     * @return carnet
     */
    public String getCarnet() {
        return carnet;
    }
    
    /**
     * Método getCiudad: retorna el valor de la variable ciudad.
     * @return 
     */
    public String getCiudad(){
        return direccion.getCiudad();
    }
    
    /**
     * Método getCalle: retorna el valor del atributo calle de la instancia de Dirección mediante su método accesor.
     * @return direccion.getCalle
     */
    public String getCalle(){
        return direccion.getCalle();
    }
    
    /**
     * Método getNumero: retorna el valor del atributo numero de la instancia de Dirección mediante su método accesor.
     * @return direccion.getNumero
     */
    public int getNumero(){
        return direccion.getNumero();
    }
    
    /**
     * Método setNombre: recibe como parámetro una variable y es asignado en el atributo nombre.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método setApellidos: recibe como parámetro una variable y es asignado en el atributo apellidos.
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método setTelefono: recibe como parámetro una variable y es asignado en el atributo teléfono.
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método setCedula: recibe como parámetro una variable y es asignado en el atributo cedula.
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Método setCiudad: recibe como parámetro una variable y es asignado en el atributo ciudad de la instancia de Dirección, mediante su método setter,
     * @param ciudad 
     */
    public void setCiudad(String ciudad){
        this.direccion.setCiudad(ciudad);
    }
    
    /**
     * Método setCalle: recibe como parámetro una variable y es asignado en el atributo calle de la instacia de Dirección, mediante su método setter.
     * @param calle 
     */
    public void setCalle(String calle){
        this.direccion.setCalle(calle);
    }
    
    /**
     * Método setNumero: recibe como parámetro una variable y es asignado en el atributo numero de la instancia de Dirección, mediante su método setter.
     * @param numero int
     */
    public void setNumero(int numero){
        this.direccion.setNumero(numero);
    }
    /**
     * Metodo ToString permite devolver una cadena de caracteres concatenando el valor de todas las variables 
     * @return String
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", cedula=" + cedula + ", carnet=" + carnet + ", " + direccion.toString() + '}';
    }
    
    /**
     * Metodo generarCarnet permite crear un codigo basado en los  2 primeros dígitos y 2 últimos de la cédula de identidad, las dos últimas letras del nombre, las dos primeras letras de ambos apellidos, un n´umero aleatorio que empieza desde el número 10 hasta el 1000 haciendo uso de las librerias java.util.StringTokenizer y java.util.Random;
     */
    public void generarCarnet(){
        StringTokenizer separadorPalabras = new StringTokenizer(apellidos);
        int contadorPalabras = separadorPalabras.countTokens();
        String primerApellido= separadorPalabras.nextToken();
        String carnetGenerado;
        Random ran = new Random();
        int valorAleatorio= ran.nextInt(1000) + 10;
        if(contadorPalabras >=2){
            String segundoApellido= separadorPalabras.nextToken();
            carnetGenerado= cedula.substring(0, 2)+cedula.substring(8, 10)+nombre.substring(nombre.length()-2)+primerApellido.substring(0,2)+segundoApellido.substring(0,2)+valorAleatorio;
            //pasa todas las mayusculas a minusculas
            carnet = carnetGenerado.toLowerCase();
        }
        else{
            try{
                carnetGenerado= cedula.substring(0, 2)+cedula.substring(8, 10)+nombre.substring(nombre.length()-2)+primerApellido.substring(0,2)+valorAleatorio;
                //pasa todas las mayusculas a minusculas
                carnet = carnetGenerado.toLowerCase();
            }catch(StringIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null, "Ingrese correctamente su nombre, apellido o cedula");
            }
            
        }
    }
}
