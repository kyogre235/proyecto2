package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;

public class SVGgenerador {
    /**constructor privado para evitar la creacion de instancias*/
    private SVGgenerador(){};

    public static void generador(Lista<String> args){
        int i;
        String argumento;
        for(i=0; i < args.getLongitud();i++){
            argumento = args.get(i);

            if(argumento.contains("Lista")){
                args.elimina("Lista");
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(args);
                break;
            } else if(argumento.contains("Pila")){
                args.elimina("pila");
                Pila<Integer> estructura = CreadorEsctructuras.creadorPila(args);
                break;
            } else if(argumento.contains("Cola")){
                args.elimina("Cola");
                Cola<Integer> estructura = CreadorEsctructuras.creadorCola(args);
                break;
            } else if(argumento.contains("ArbolBinarioCompleto")){
                args.elimina("ArbolBinarioCompleto");
                ArbolBinarioCompleto<Integer> estructura = 
                CreadorEsctructuras.creadorArbolBinarioCompleto(args);
                break;
            } else if(argumento.contains("ArbolBinarioOrdenado")){
                args.elimina("ArbolBinarioOrdenado");
                ArbolBinarioCompleto<Integer> estructura = 
                CreadorEsctructuras.creadorArbolBinarioCompleto(args);
                break;
            } else if(argumento.contains("ArbolRojinegro")){
                args.elimina("ArbolRojinegro");
                ArbolRojinegro<Integer> estructura = CreadorEsctructuras.creadorArbolRojinegro(args);
                break;
            } else if(argumento.contains("ArbolAVL")){
                //coloca el AVL
                args.elimina("ArbolAVL");
                CreadorEsctructuras.creadorArbolAVL(args);
                break;
            } else if(argumento.contains("Grafica")){
                //coloca la grafica
                args.elimina("Grafica");
                CreadorEsctructuras.creadorGrafica(args);
                break;
            }
        }
        return;

    }
}

