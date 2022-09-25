
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
import modelo.Medico;

/**
 * Permite realizar el manejo de archivos de los medicos
 * 
 * Creado el 14 de Septiembre del 2022, 16:47 horas
 * 
 * @author Erik Andre Barroso Castillo
 * 
 * @version POO - 2022
 */
public class ManejarArchivoMedico {
    
    private FileOutputStream fichero = null;
    private ArrayList<Medico> lista = new ArrayList<>();
    private FileInputStream ficheroEntrada = null;
    private ObjectInputStream pasarDatosEntrada;
    private ArrayList<Medico> listaRecuperada = new ArrayList<>();
    private File archivo = new File("./src/medico.epf");
    
    /**
     * Constructor vacío para invocar la función de recuperar la lista de archivo sin enviar una lista
     */
    public ManejarArchivoMedico(){

    }
    
    /**
     * constructor para invocar la función de enviar una lista i guardar el archivo
     * @param lista 
     */
    public ManejarArchivoMedico(ArrayList<Medico> lista){
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
        }
        finally{
            fichero.close();
        }
        
    }
    
    /**
     * Devuelve un Arraylist de tipo paciente recuperado del archivo medico.epf
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Medico> getListaMedico() throws IOException, ClassNotFoundException{
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
     * Permite crear un nuevo archivo en caso de no existir para guardar el archivo
     * @return ArrayList<Medico>
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Medico> getListaMedicoSinArchivo() throws IOException, ClassNotFoundException{
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        try{
            fichero = new FileOutputStream(archivo);
            ObjectOutputStream pasarDatos = new ObjectOutputStream(fichero);
            pasarDatos.writeObject(new ArrayList<Medico>());
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
