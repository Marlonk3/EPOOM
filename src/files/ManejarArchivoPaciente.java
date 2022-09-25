
package files;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Paciente;

/**
 * Permite realizar el manejo de archivos de los Paciente
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class ManejarArchivoPaciente {
    
    private FileOutputStream fichero = null;
    private ArrayList<Paciente> lista = new ArrayList<>();
    private FileInputStream ficheroEntrada = null;
    private ObjectInputStream pasarDatosEntrada;
    private ArrayList<Paciente> listaRecuperada = new ArrayList<>();
    private File archivo = new File("./src/Paciente.epf");
    
    /**
     * Constructor vacío para invocar la función de recuperar la lista de archivo sin enviar una lista
     */
    public ManejarArchivoPaciente(){
    
    }
    /**
     * constructor para invocar la función de enviar una lista i guardar el archiv
     * @param lista 
     */
    public ManejarArchivoPaciente(ArrayList<Paciente> lista){
        this.lista = lista;
    }
    /**
     * Guarda la lista en un archivo binario
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardarArchivo() throws FileNotFoundException, IOException{

        if(!archivo.exists()){
            archivo.createNewFile();
        }
        try{
            fichero = new FileOutputStream(archivo);
            ObjectOutputStream pasarDatos = new ObjectOutputStream(fichero);
            pasarDatos.writeObject(lista);
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No existen registros");
        }finally{
            fichero.close();
        }
        
    }
    
    /**
     * Devuelve un Arraylist de tipo paciente recuperado del archivo paciente.epf
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Paciente> getListaPaciente() throws IOException, ClassNotFoundException{
        try{
            //Lee el fichero de entrada
            ficheroEntrada = new FileInputStream(archivo);
            //Sirve de puente para pasar los datos
            pasarDatosEntrada = new ObjectInputStream(ficheroEntrada);
            //Asigna el objeto con un cast de Arraylist que se guarda en lista
            listaRecuperada = (ArrayList)pasarDatosEntrada.readObject();
            //Imprime cada elemento del ArrayList recuperado
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(EOFException e){
            JOptionPane.showMessageDialog(null, "No existen registros");
        }finally{
            try{
                ficheroEntrada.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return listaRecuperada;
    }
    /**
     * Permite crear un nuevo archivo en caso de no existir para posteriormente recuperarlo
     * @return ArrayList<Medico>
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Paciente> getListaPacienteSinArchivo() throws IOException, ClassNotFoundException{
        try{
            fichero = new FileOutputStream(archivo);
            ObjectOutputStream pasarDatos = new ObjectOutputStream(fichero);
            pasarDatos.writeObject(new ArrayList<Paciente>());
            //Lee el fichero de entrada
            ficheroEntrada = new FileInputStream(archivo);
            //Sirve de puente para pasar los datos
            pasarDatosEntrada = new ObjectInputStream(ficheroEntrada);
            //Asigna el objeto con un cast de Arraylist que se guarda en lista
            listaRecuperada = (ArrayList)pasarDatosEntrada.readObject();
            //Imprime cada elemento del ArrayList recuperado
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(EOFException e){
            JOptionPane.showMessageDialog(null, "No existen registros");
        }finally{
            try{
                ficheroEntrada.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return listaRecuperada;
        }
}
