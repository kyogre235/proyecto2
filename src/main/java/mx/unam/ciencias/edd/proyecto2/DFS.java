package mx.unam.ciencias.edd.proyecto2;


import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.ArbolRojinegro;

public class DFS {
    private Cola<Boolean> cola;
    private Lista<VerticeArbolBinario<Integer>> lista;

    protected DFS (ArbolBinario<Integer> arbol){
        Cola<VerticeArbolBinario<Integer>> recorrido = new Cola<>();
        recorrido.mete(arbol.raiz());
        lista = new Lista<>();
        cola = new Cola<>();
        ArbolRojinegro<Integer> aux = new ArbolRojinegro<>();
        aux.agrega(0);
        ArbolBinario<Integer>aux2 = aux; 
       
        VerticeArbolBinario<Integer> vertice;
        VerticeArbolBinario<Integer> fantasma = aux2.raiz();
        cola.mete(true);
        
        while(!recorrido.esVacia()){
            vertice = recorrido.saca();
            if(fantasma != vertice)
                lista.agregaInicio(vertice);
            if(arbol.getElementos() == lista.getElementos())
                break;
            if(vertice.hayIzquierdo()){
                recorrido.mete(vertice.izquierdo());
                cola.mete(true);
                
            } else{
                recorrido.mete(fantasma);
                cola.mete(false);
            }
               
            
            if(vertice.hayDerecho()){
                recorrido.mete(vertice.derecho());
                cola.mete(true);
                
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

}
