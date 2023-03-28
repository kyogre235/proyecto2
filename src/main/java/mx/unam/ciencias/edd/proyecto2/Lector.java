package mx.unam.ciencias.edd.proyecto2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import mx.unam.ciencias.edd.Lista;
public class Lector {
   
    public Lector (){};

    protected Lista<Linea> lector(String archivo) throws IOException{
        Lista<Linea> listaLeidos = new Lista<>();
        Linea linea = new Linea("");

        try (BufferedReader lectorplano = new BufferedReader(new FileReader(archivo))) {   
            String lineaActual;  

            while ((lineaActual = lectorplano.readLine()) != null){
                if(!lineaActual.contains("#")){
                    linea = new Linea(lineaActual);
                    listaLeidos.agrega(linea); 
                }
                
            } 
            lectorplano.close(); 
            return listaLeidos;
        } catch (IOException e) {  
            throw new IOException("este archivo no existe");
        }
    }
}

