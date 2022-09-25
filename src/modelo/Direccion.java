/**
 * Creación de variables que son componentes de una dirección
 * 
 * Creado el 28 de Agosto del 2022, 1:17 horas
 * 
 * @author Marlon Jair Azua Barrera
 * 
 * @version POO - 2022
 */
package modelo;

import java.io.Serializable;

public class Direccion implements Serializable{
   private String ciudad;
   private String calle;
   private int numero;
   /**
    * Construnctor vacio
    */
   public Direccion(){}
   /**
    * Constructor que recive valores como parametros para luego dar valor a cada variable 
    * @param ciudad String
    * @param calle String
    * @param numero int
    */
   public Direccion(String ciudad, String calle, int numero){
      this.ciudad= ciudad;
      this.calle=calle;
      this.numero=numero;
   }
   /**
    * Metodo get que retorna el valor de ciudad
    * @return ciudad
    * 
    */
   public String getCiudad() {
      return ciudad;
   }
   /**
    * Metodo set cambia el valor de ciudad
    * @param ciudad String
    */
   public void setCiudad(String ciudad) {
      this.ciudad = ciudad;
   }
   /**
    * Metodo get que retorna el valor de calle
    * @return calle
    */
   public String getCalle() {
      return calle;
   }
   /**
    * Metodo set cambia el valor de calle
    * @param calle String
    */
   public void setCalle(String calle) {
      this.calle = calle;
   }
   /**
    * Metodo get que retorna el valor de numero
    * @return numero
    */
   public int getNumero() {
      return numero;
   }
   /**
    * Metodo set cambia el valor de numero
    * @param numero int
    */
   public void setNumero(int numero) {
      this.numero = numero;
   }

   /**
    * Metodo toString devuelve una cadena de texto con el valor de Dirección
    * @return String
    */
   @Override
   public String toString() {
      return "Dirección [calle= " + calle + ", ciudad= " + ciudad + ", numero= " + numero + "]";
   }
}

