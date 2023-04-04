package mx.unam.ciencias.edd.proyecto2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Lector {
   
    public Lector (){};

    protected Linea lector(String archivo) throws IOException{
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
            throw new IOException("este archivo no existe");
        }
    }

    protected void escritor(String codigo)throws IOException {
        try {
            File archivo = new File("Esctructura.svg");  

            if(!archivo.exists())
                archivo.createNewFile();

            FileWriter escritorArchivo = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritorArchivo);

            buffer.write(codigo);
            buffer.close();
        } catch (IOException e) {
            throw new IOException("accion no valida");
        }
    }

}

