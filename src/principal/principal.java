/**
 * Permite dar visibilidad al FramePrincipal
 * 
 * Creado el 29 de Agosto del 2022, 20:25 horas
 * 
 * @author Marlon Jair Azua Barrera
 * @author Erik Andre Barroso Castillo
 * @version POO - 2022
 */
package principal;

import gui.FrmPrincipal;
import java.io.IOException;


public class principal {
    public static void main(String[] args) throws IOException {
        
        new FrmPrincipal().setVisible(true);
        
    }
}
