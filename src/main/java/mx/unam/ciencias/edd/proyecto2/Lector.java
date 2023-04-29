package mx.unam.ciencias.edd.proyecto2;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Clase que lee el texto que se reciba de entrada, 
 *  ya sea por archivo o por entrda estandar.
 * 
 *  Tambien imprime el SVG en la salida Estandar.
 */
public class Lector {
    /** Constructor vacio */
    public Lector (){};

    /**
     * metodo que genera la inatancia de la Clase Linea en la que se
     * guradan los datos para generar una estructura y graficarla en un SVG
     * @param archivo es el nombre del archivo de texto en el que se tiene la informacion
     * @return una instancia de la clase Linea
     */
    public Linea lector(String archivo){
        Linea linea = new Linea("");
        String l = "";
        try (BufferedReader lectorplano = new BufferedReader(new FileReader(archivo))) {   
            String lineaActual;  

            while ((lineaActual = lectorplano.readLine()) != null){
                if(!lineaActual.contains("#")){
                    l = l + lineaActual + " ";
                }   
            } 
            linea = new Linea(l);
            lectorplano.close(); 
            return linea;
        } catch (IOException e) {  
            System.err.println("este archivo no existe, revisa que no este bien escrito");
            System.exit(0);
        }
        return linea;
    }
    /**
     * metodo que genera la inatancia de la Clase Linea en la que se
     * guradan los datos para generar una estructura y graficarla en un SVG
     * @return una instancia de la clase Linea
     */
    protected Linea lectorEntradaEstandar() {
        Linea linea = new Linea("");
        String l = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                if (!lineaActual.contains("#")) {
                    l = l + lineaActual + " ";
                }
            }
            reader.close();
            linea = new Linea(l);
            return linea;
        } catch (IOException e) {
            System.err.println("ha habido un error al leer la entrada estandar, por favor revise que todo este correcto");
            System.exit(1);
        }
        return linea;
    }  
    /**
     * metodo que imprime en la salida estandar el texto del SVG
     */
    public void escritor(String codigo) {
        System.out.println(codigo);
    }
}

