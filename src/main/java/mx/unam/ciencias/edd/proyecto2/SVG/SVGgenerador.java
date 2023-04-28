package mx.unam.ciencias.edd.proyecto2.SVG;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.proyecto2.*;

public class SVGgenerador {
    /**constructor privado para evitar la creacion de instancias*/
    public SVGgenerador(){};

    public void generador(Linea args){
       String argumento = args.getLineaPlana();
       
            if(argumento.contains("Lista")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                SVGLista.graficarLista(estructura, true);
                
            } else if(argumento.contains("Pila")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                SVGPila.graficarPila(estructura);

            } else if(argumento.contains("Cola")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                SVGLista.graficarLista(estructura, false);

            } else if(argumento.contains("ArbolBinarioCompleto")){
                ArbolBinarioCompleto<Integer> estructura = CreadorEsctructuras.creadorArbolBinarioCompleto(argumento);
                SVGArbolBinarioCompleto a = new SVGArbolBinarioCompleto();
                a.graficarArbol(estructura); 

            } else if(argumento.contains("ArbolBinarioOrdenado")){
                ArbolBinarioOrdenado<Integer> estructura = CreadorEsctructuras.creadorArbolBinarioOrdenado(argumento);
                SVGArbolBinarioOrdenado a = new SVGArbolBinarioOrdenado();
                 a.graficarArbol(estructura);

            } else if(argumento.contains("ArbolRojinegro")){
                ArbolRojinegro<Integer> estructura = CreadorEsctructuras.creadorArbolRojinegro(argumento);
                SVGArbolRojinegro a = new SVGArbolRojinegro();
                a.graficarArbol(estructura); 

            } else if(argumento.contains("ArbolAVL")){
                ArbolAVL<Integer> estructura = CreadorEsctructuras.creadorArbolAVL(argumento);
                SVGArbolAVL a = new SVGArbolAVL();
                a.graficarArbol(estructura); 
                
            } else if(argumento.contains("Grafica")){
                Grafica<Integer> estructura = CreadorEsctructuras.creadorGrafica(argumento);
                SVGGrafica a = new SVGGrafica();
                a.graficarGrafica(estructura);
        
            } else if(argumento.contains("Arreglo")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                SVGArreglo.graficarArreglo(estructura);
            } else {
                System.err.println("la escructura no esta bien escrita o no existe,"+"\n"
                +"tienes que poner el nombre de la esctructura iniciando con mayusculas\npor ejemplo:\n"+"Lista\nArbolBinarioCompleto\netc.");
            }
    }
}




