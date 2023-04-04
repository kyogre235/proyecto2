package mx.unam.ciencias.edd.proyecto2;

import java.text.Normalizer;

/**
 * Clase que guarda en un objeto una linea de texto,
 * en forma de String, ademas crea una version de la
 * cadena sin espacios, sin mayusculas, sin acentos
 * y sin la ñ, que facilitara la comparacion entre 
 * lineas, a la cual llamaremos linea "plana".
 */
public class Linea implements Comparable<Linea> {
    
    /** version de la linea guardada en formato plano */
    private String lineaPlana;
    
    /**
     * metodo constructor de la clase Linea,
     * tambien genera la linea plana
     * @param linea es el String que recibe
     */
    protected Linea(String linea){
        
        lineaPlana = Normalizer.normalize(linea,Normalizer.Form.NFD);
        lineaPlana = lineaPlana.replaceAll("\t", "");

    }
    /**
     * metodo que regresa la cadena dentro de Linea
     * @return la cadena dentro de Linea
     */
    public String getLineaPlana(){
        return lineaPlana;
    }


    protected static Character[] lineaChar(String linea){
        Character[] ch = new Character[linea.length()];
        int i;
        for(i=0;i<linea.length();i++){
            ch[i]=linea.charAt(i);
        }
        
        return ch;
    }
    /**
     * Compara la Linea que invoca el metodo con otra Linea
     * 
     * @return un n > 0 si la linea que llamo el metodo es mayor,
     * regresa un n < 0 si es menor y regresa n = 0 si es igual. 
     */
    @Override public int compareTo(Linea linea){
        //metodo por implementar
        //return temporal
        return this.lineaPlana.compareTo(linea.getLineaPlana());
        
    }
}
