package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;

public class BFS{

    private Cola<Boolean> cola;
    private Lista<VerticeArbolBinario<Integer>> lista;
    private Cola<Integer> colaP;

    protected BFS(ArbolAVL<Integer> arbol){

        Cola<VerticeArbolBinario<Integer>> recorrido = new Cola<>();
        recorrido.mete(arbol.raiz());
        lista = new Lista<>();
        cola = new Cola<>();
        colaP = new Cola<>();
        VerticeArbolBinario<Integer> vertice;
        cola.mete(true);
        colaP.mete(0);
        while(!recorrido.esVacia()){
            vertice = recorrido.saca();
            lista.agregaInicio(vertice);
            if(vertice.hayIzquierdo()){
                recorrido.mete(vertice.izquierdo());
                cola.mete(true);
                colaP.mete(1);
            } else{
               
                cola.mete(false);
            }
               
            
            if(vertice.hayDerecho()){
                recorrido.mete(vertice.derecho());
                cola.mete(true);
                colaP.mete(2);
            } else
                cola.mete(false);
               
        }
    }
    protected Cola<Boolean> getCola(){
        return cola;
    }
    
    protected Lista<VerticeArbolBinario<Integer>> getLista(){
        return lista;
    }

    protected Cola<Integer> getColaP(){
        return colaP;
    }
}