package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.ArbolAVL;
//faltan graficas
public class CreadorEsctructuras {
    /**constructor privado para que no se pueda instanciar la clase */
    private CreadorEsctructuras(){};
    

    protected static Lista<Integer> creadorLista(Lista<String> args){
        Lista <Integer> lista = new Lista<>();
        //aqui va el codigo faltante
        return lista;
    }

    protected static Pila<Integer> creadorPila(Lista<String> args){
        Pila <Integer> pila = new Pila<>();
        //aqui va el codigo faltante
        return pila;
    }

    protected static Cola<Integer> creadorCola(Lista<String> args){
        Cola <Integer> cola = new Cola<>();
        //aqui va el codigo faltante
        return cola;
    }

    protected static ArbolBinarioCompleto<Integer> creadorArbolBinarioCompleto(Lista<String> args){
        ArbolBinarioCompleto <Integer> abc = new ArbolBinarioCompleto<>();
        //aqui va el codigo faltante
        return abc;
    }

    protected static ArbolBinarioOrdenado<Integer> creadorArbolBinarioOrdenado(Lista<String> args){
        ArbolBinarioOrdenado <Integer> abo = new ArbolBinarioOrdenado<>();
        //aqui va el codigo faltante
        return abo;
    }

    protected static ArbolRojinegro<Integer> creadorArbolRojinegro(Lista<String> args){
        ArbolRojinegro <Integer> arn = new ArbolRojinegro<>();
        //aqui va el codigo faltante
        return arn;
    }
    //cambia rojinegro por AVL
    protected static ArbolAVL<Integer> creadorArbolAVL(Lista<String> args){
        ArbolRojinegro <Integer> aAVL = new ArbolRojinegro<>();
        //aqui va el codigo faltante
        return aAVL;
    }

    //cambia rojinegro por grafica
    protected static ArbolRojinegro<Integer> creadorGrafica(Lista<String> args){
        ArbolRojinegro <Integer> aAVL = new ArbolRojinegro<>();
        //aqui va el codigo faltante
        return aAVL;
    }

}
