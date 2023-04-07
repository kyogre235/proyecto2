package mx.unam.ciencias.edd.proyecto2;


import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolRojinegro;

public class BFS{

    private Cola<Boolean> cola;
    private Lista<VerticeArbolBinario<Integer>> lista;
    private Cola<Integer> colaP;

    protected BFS(ArbolBinario<Integer> arbol){

        Cola<VerticeArbolBinario<Integer>> recorrido = new Cola<>();
        recorrido.mete(arbol.raiz());
        lista = new Lista<>();
        cola = new Cola<>();
        colaP = new Cola<>();
        ArbolRojinegro<Integer> aux = new ArbolRojinegro<>();
        aux.agrega(0);
        ArbolBinario<Integer>aux2 = aux; 
        VerticeArbolBinario<Integer> vertice;
        VerticeArbolBinario<Integer> fantasma = aux2.raiz();
        cola.mete(true);
        colaP.mete(0);
        while(!recorrido.esVacia()){
            vertice = recorrido.saca();
            if(fantasma != vertice)
            lista.agregaInicio(vertice);
        if(arbol.getElementos() == lista.getElementos())
            break;
            
            if(vertice.hayIzquierdo()){
                recorrido.mete(vertice.izquierdo());
                cola.mete(true);
                colaP.mete(1);
            } else{
                recorrido.mete(fantasma);
                cola.mete(false);
            }
               
            
            if(vertice.hayDerecho()){
                recorrido.mete(vertice.derecho());
                cola.mete(true);
                colaP.mete(2);
            } else{
                recorrido.mete(fantasma);
                cola.mete(false);
            }
                
               
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