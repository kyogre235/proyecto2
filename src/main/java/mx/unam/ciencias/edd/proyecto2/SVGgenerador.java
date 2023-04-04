package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Cola;

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
                System.out.println(estructura.toString());
                svgArbolCompleto(estructura);
            } else if(argumento.contains("ArbolBinarioOrdenado")){
                
                ArbolBinarioOrdenado<Integer> estructura = 
                CreadorEsctructuras.creadorArbolBinarioOrdenado(argumento);
                
            } else if(argumento.contains("ArbolRojinegro")){
                
                ArbolRojinegro<Integer> estructura = CreadorEsctructuras.creadorArbolRojinegro(argumento);
                
            } else if(argumento.contains("ArbolAVL")){
                //coloca el AVL
                
                CreadorEsctructuras.creadorArbolAVL(argumento);
                
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


    

    
}




