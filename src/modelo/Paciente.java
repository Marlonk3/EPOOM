/**
 * Crea y hereda atributos de la clase persona para poder establecer los datos que debe llevar un paciente en el Hostital "El paciente feliz"
 * 
 * Creado el 28 de Agosto del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */

package modelo;

import java.io.Serializable;

public class Paciente extends Persona implements Serializable{
    private boolean esAlergico;
    private int totalVacunasCovid;
     /**
      * Constructor Vacio
      */
    public Paciente(){}
    /**
     * Constructor da valor a las variables locales y a las variables heredadas de la clase Persona
     * @param esAlergico boolean
     * @param totalVacunasCovid int
     * @param nombre String
     * @param apellidos String
     * @param telefono String
     * @param cedula String
     * @param calle String
     * @param ciudad String
     * @param numero int
     */
    public Paciente(boolean esAlergico, int totalVacunasCovid, String nombre, String apellidos, String telefono, String cedula, String calle, String ciudad, int numero) {
        super(nombre, apellidos, telefono, cedula, calle, ciudad, numero);
        this.esAlergico = esAlergico;
        this.totalVacunasCovid = totalVacunasCovid;
    }
    
    /**
     * Metodo get devuele el valor de esAlergico
     * @return boolean
     */
    public boolean getEsAlergico() {
        return esAlergico;
    }
    /**
     * Metodo get devuele el valor de totalVacunasCovid
     * @return int
     */
    public int getTotalVacunasCovid() {
        return totalVacunasCovid;
    }
    /**
     * Metodo set permite cambiar el valor de la variable esAlergico
     * @param esAlergico boolean
     */
    public void setEsAlergico(boolean esAlergico) {
        this.esAlergico = esAlergico;
    }
    /**
     * Metodo set permite cambiar el valor de la variable totalVacunasCovid
     * @param totalVacunasCovid int
     */
    public void setTotalVacunasCovid(int totalVacunasCovid) {
        this.totalVacunasCovid = totalVacunasCovid;
    }

    /**
     * Metodo toString permite devolver una cadena de texto con todos los valores de las variables incluyendo las heredadas
     * @return String
     */
    @Override
    public String toString() {
        return "Paciente [esAlergico=" + esAlergico + ", totalVacunasCovid=" + totalVacunasCovid +" "+super.toString() +"]";
    }
    
    
    
    
    
}
