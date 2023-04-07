package mx.unam.ciencias.edd.proyecto2;


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

    protected void escritor(String codigo) {
        System.out.println(codigo);

}
}

