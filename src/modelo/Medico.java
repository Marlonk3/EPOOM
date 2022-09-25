/**
 * La clase medico realiza la creación de metodos y variables, ademas hereda de la clase persona para establecer los datos a recoger de los medicos del Hospital “El paciente feliz”
 * 
 * Creado el 29 de Agosto del 2022, 16:47 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @version POO - 2022
 */
package modelo;

import java.io.Serializable;

public class Medico extends Persona implements Serializable{
   private int licencia;
   private String especialidad;
   private int anios;
   private int meses;
   private String horaInicio;
   private String horaFin;
   /**
    * Constructor por defecto
    */
   public Medico() {}
   /**
    * Constructor que da valores a las variables locales y a las heredadas 
    * @param nombre String
    * @param apellidos String
    * @param telefono String
    * @param cedula String
    * @param calle String
    * @param ciudad String
    * @param numero int
    * @param licencia int
    * @param especialidad String
    * @param anios int
    * @param meses int
    * @param horaInicio String
    * @param horaFin String
    */
   public Medico(String nombre, String apellidos, String telefono, String cedula, String calle, String ciudad,
         int numero, int licencia, String especialidad, int anios, int meses, String horaInicio, String horaFin) {
      super(nombre, apellidos, telefono, cedula, calle, ciudad, numero);
      this.licencia = licencia;
      this.horaInicio = horaInicio;
      this.horaFin = horaFin;
      this.especialidad= especialidad;
      establecerTiempoExperiencia(meses, anios);
   }

   /**
    * Metodo get permite devolver el valor de licencia
    * @return int
    */
   public int getLicencia() {
      return licencia;
   }
   /**
    * Metodo get permite devolver el valor de especialidad
    * @return String
    */
   public String getEspecialidad() {
      return especialidad;
   }
   /**
    * Metodo get permite devolver el valor de anios
    * @return int
    */
   public int getAnios() {
      return anios;
   }
   /**
    * Metodo get permite devolver el valor de meses
    * @return int
    */
   public int getMeses() {
      return meses;
   }
   /**
    * Metodo get permite devolver el valor de horaInicio
    * @return int
    */
   public String getHoraInicio() {
      return horaInicio;
   }
   /**
    * Metodo get permite devolver el valor de horaFin
    * @return int
    */
   public String getHoraFin() {
      return horaFin;
   }
   /**
    * Metodo set permite cambiar el valor de licencia
    * @param licencia int
    */
   public void setLicencia(int licencia) {
      this.licencia = licencia;
   }
   /**
    * Metodo set permite cambiar el valor de horaInicio
    * @param horaInicio int
    */
   public void setHoraInicio(String horaInicio) {
      this.horaInicio = horaInicio;
   }
   /**
    * Metodo set permite cambiar el valor de horaFin
    * @param horaFin int
    */
   public void setHoraFin(String horaFin) {
      this.horaFin = horaFin;
   }
   /**
    * Controla la llegada de mese y años permitiendo que no exista errores de logica al momento de que los meses digitados por el usuario no sean 12
    * @param meses int
    * @param anios int
    */
   public void establecerTiempoExperiencia(int meses, int anios) {
      this.anios = anios;
      if (meses == 12) {
         this.anios++;
         this.meses = 0;
      } else {
         this.meses = meses;
      }
   }
   /**
    * Metodo toString devuelve una cadena de caracteres con el valor de todas las variables
      @return String
    */
   @Override
   public String toString() {
      return "Medico [anios=" + anios + ", especialidad=" + especialidad + ", horaFin=" + horaFin + ", horaInicio="
            + horaInicio + ", licencia=" + licencia + ", meses=" + meses + " "+super.toString()+"]";
   }
   public void setEspecialidad(String especialidad) {
      this.especialidad = especialidad;
   }
   public void setAnios(int anios) {
      this.anios = anios;
   }
   public void setMeses(int meses) {
      this.meses = meses;
   }
   
}
