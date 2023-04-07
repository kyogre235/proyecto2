package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.ArbolAVL;

public class SVGgenerador {
    /**constructor privado para evitar la creacion de instancias*/
    public SVGgenerador(){};

    public void generador(Linea args){
       String argumento = args.getLineaPlana();
       
            if(argumento.contains("Lista")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                svgLista(estructura,true);
            } else if(argumento.contains("Pila")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                svgPila(estructura);
            } else if(argumento.contains("Cola")){
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                svgLista(estructura, false);
            } else if(argumento.contains("ArbolBinarioCompleto")){
                ArbolBinarioCompleto<Integer> estructura = CreadorEsctructuras.creadorArbolBinarioCompleto(argumento);
                svgArbolCompleto(estructura);
            } else if(argumento.contains("ArbolBinarioOrdenado")){
                ArbolBinarioOrdenado<Integer> estructura = 
                CreadorEsctructuras.creadorArbolBinarioOrdenado(argumento);
                svgArbolOrdenado(estructura);
            } else if(argumento.contains("ArbolRojinegro")){
                ArbolRojinegro<Integer> estructura = CreadorEsctructuras.creadorArbolRojinegro(argumento);
                svgArbolRojinegro(estructura);
            } else if(argumento.contains("ArbolAVL")){
                ArbolAVL<Integer> estructura = CreadorEsctructuras.creadorArbolAVL(argumento);
                svgArbolAVL(estructura);
            } else if(argumento.contains("Grafica")){
                //coloca la grafica
                
                CreadorEsctructuras.creadorGrafica(argumento);
                
            } else {
                System.err.println("la escructura no esta bien escrita o no existe,"+"\n"
                +"tienes que poner el nombre de la esctructura iniciando con mayusculas\npor ejemplo:\n"+"Lista\nArbolBinarioCompleto\netc.");
            }
        
        return;

    }

    protected void svgLista(Lista<Integer> listaS, boolean esLista){
        SVGLista.graficarLista(listaS, esLista);
    }

    private void svgPila (Lista<Integer> lista){
        SVGPila.graficarPila(lista);
    }

    private void svgArbolCompleto(ArbolBinarioCompleto<Integer> arbol){
        SVGArbolBinarioCompleto.graficarArbol(arbol);
    }

    private void svgArbolOrdenado(ArbolBinarioOrdenado<Integer> arbol){

    }

    private void svgArbolRojinegro(ArbolRojinegro<Integer> arbol){

    }
    
    private void svgArbolAVL(ArbolAVL<Integer> arbol){

    }
    
}




