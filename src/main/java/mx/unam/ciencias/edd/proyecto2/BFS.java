package mx.unam.ciencias.edd.proyecto2;


import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolRojinegro;
/**
 * clase que recorre los arboles en forma bfs de forma iterativa
 * para poder graficarlos en un svg;
 * toma en cuenta la posicion de cada elemento con respecto al nivel en el que esta.
 */
public class BFS{
    /**
     * Cola en la que se registra el estado de cada posiscion en el arbol
     * el valor true representa que en ese sitio hay un elemento.
     * el valor false representa que en ese sitio no hay elemento.
     */
    private Cola<Boolean> cola;
    /**lista en la que se colocan los elementos conforme se van recorriendo */
    private Lista<VerticeArbolBinario<Integer>> lista;
    /**
     * Cola en la que se registra si el vertice es izquierdo o derecho 
     * con respecto a su padre, o si es la raiz.
     * 
     * el valor 0 representa que es la raiz.
     * el valor 1 representa que es hijo izquierdo.
     * el valor 2 representa que es hijo derecho.
     */
    private Cola<Integer> colaP;
    /**
     * metodo constructor de la clase
     * @param arbol es la estructura que recibe
     */
    public BFS(ArbolBinario<Integer> arbol){
        // en esta parte se inicializa las colas y la lista que se va a utilizar
        Cola<VerticeArbolBinario<Integer>> recorrido = new Cola<>();
        recorrido.mete(arbol.raiz());
        lista = new Lista<>();
        cola = new Cola<>();
        colaP = new Cola<>();

        //se instancia este arbol con el unico proposito de obtener 
        //un vertice ajeno al arbol sobre el que se trabajo 
        ArbolRojinegro<Integer> aux = new ArbolRojinegro<>();
        aux.agrega(0);
        ArbolBinario<Integer>aux2 = aux; 
        VerticeArbolBinario<Integer> vertice;
        VerticeArbolBinario<Integer> fantasma = aux2.raiz();

        //como metimos a la raiz en la cola, se agregan 
        //tambien en la cola de posicion y  en la de hijo
        cola.mete(true);
        colaP.mete(0);

        //en este ciclo se recorre el arbol
        while(!recorrido.esVacia()){
         vertice = recorrido.saca();
            if(fantasma != vertice)
            lista.agregaInicio(vertice);

            // como siempre agregamos vertices a la cola, esta clasusula no saca del ciclo
            // una vez hemos recorrido todos los vertices del arbol
            if(arbol.getElementos() == lista.getElementos())
                break;

            // si el vertice no tiene alguno de sus hijos, se agrega a la cola del recorrido
            // el vertice externo que previamente habiamos conseguido
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

    /**
     * metodo que regresa la cola de booleanos
     * @return una Cola<Boolean>
     */
    public Cola<Boolean> getCola(){
        return cola;
    }

    /**
     * metodo que regresa la lista con los elemetos en orden bfs
     * @return una lista<VerticeArbolBinario<Integer>>
     */
    public Lista<VerticeArbolBinario<Integer>> getLista(){
        return lista;
    }

    /**
     * metodo que regresa la cola de posicion
     * @return una Cola<Integer>
     */
    public Cola<Integer> getColaP(){
        return colaP;
    }
}