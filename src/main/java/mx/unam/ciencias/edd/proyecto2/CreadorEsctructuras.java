package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.SVG.SVGLineas;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.Grafica;
/**
 * Clase que crea la Esctrructura de 
 * datos que este especificada en el texto de entrada
 */
public class CreadorEsctructuras {
    /**constructor privado para que no se pueda instanciar la clase */
    private CreadorEsctructuras(){};

    /**
     * metodo estatico que crea una Lista<Integer> a partir de la entrada recibida
     * @param args es un String con los datos nesesarios
     * @return una Lista<Integer>
     */
    public static Lista<Integer> creadorLista(String args){
        Lista <Integer> lista = new Lista<>();
        lista = creadorEsc(args);
        return lista;
    }

    /**
     * metodo estatico que crea un ArbolBinarioCompleto<Integer> a partir de la entrada recibida
     * @param args es un String con los datos nesesarios
     * @return un ArbolBinarioCompleto<Integer>
     */
    public static ArbolBinarioCompleto<Integer> creadorArbolBinarioCompleto(String args){
        Lista <Integer> lista = new Lista<>();
        lista = creadorEsc(args);
        ArbolBinarioCompleto <Integer> abc = new ArbolBinarioCompleto<>(lista);
        return abc;
    }

    /**
     * metodo estatico que crea un ArbolBinarioOrdenado<Integer> a partir de la entrada recibida
     * @param args es un String con los datos nesesarios
     * @return un ArbolBinarioOrdenado<Integer>
     */
    public static ArbolBinarioOrdenado<Integer> creadorArbolBinarioOrdenado(String args){
        Lista <Integer> lista = new Lista<>();
        lista = creadorEsc(args);
        ArbolBinarioOrdenado <Integer> abo = new ArbolBinarioOrdenado<>(lista);
        return abo;
    }

    /**
     * metodo estatico que crea un ArbolRojinegro<Integer> a partir de la entrada recibida
     * @param args es un String con los datos nesesarios
     * @return un ArbolRojinegro<Integer>
     */
    public static ArbolRojinegro<Integer> creadorArbolRojinegro(String args){
        Lista <Integer> lista = new Lista<>();
        lista = creadorEsc(args);        
        ArbolRojinegro <Integer> arn = new ArbolRojinegro<>(lista);
        return arn;
    }

    /**
     * metodo estatico que crea un ArbolAVL<Integer> a partir de la entrada recibida
     * @param args es un String con los datos nesesarios
     * @return un ArbolAVL<Integer>
     */
    public static ArbolAVL<Integer> creadorArbolAVL(String args){
        Lista <Integer> lista = new Lista<>();
        lista = creadorEsc(args);
        ArbolAVL <Integer> aAVL = new ArbolAVL<>(lista);
        return aAVL;
    }


    /**
     * metodo estatico que crea una Grafica<Integer> a partir de la entrada recibida
     * @param args es un String con los datos nesesarios
     * @return una Grafica<Integer>
     */
    public static Grafica<Integer> creadorGrafica(String args){
        Grafica<Integer> grafica = new Grafica<>();
        Lista <Integer> lista = new Lista<>();
        lista = creadorEsc(args);
        if(lista.getElementos() % 2 != 0)
               throw new IllegalArgumentException("la lista debe tener una cantidad de elementos par");
        int a = 0;
        int b = 0;
        while(!lista.esVacia()){
            a = lista.eliminaPrimero();
            b = lista.eliminaPrimero();
            if(a == b){
                if(grafica.contiene(a)){
                    System.err.println("un elemento no puede ser aislado, ya esta conectado a otro vertice");
                    System.exit(1);
                }      
                grafica.agrega(a);
            } else{
                boolean A = grafica.contiene(a);
                boolean B = grafica.contiene(b);
                if(!A && !B){
                    grafica.agrega(a);
                    grafica.agrega(b);
                    grafica.conecta(a,b);
                } else if(A && !B){
                    grafica.agrega(b);
                    grafica.conecta(a, b);
                } else if(!A && B){
                    grafica.agrega(a);
                    grafica.agrega(b);
                    grafica.conecta(a, b);
                } else
                    grafica.conecta(a, b);  
            }

        }
        return grafica;
    }
    /**
     * metodo privado que genera una Lista<Integer> la cual se pasa como argumento
     * al constructor de la estructura que se quiera generar.
     * @param args es un String con los datos nesesarios
     * @return una Lista<Integer>
     */
    private static Lista<Integer> creadorEsc(String args){
        Lista <Integer> lista = new Lista<>();
        String valor ="k";
        Character[] ch = Linea.lineaChar(args);
        int j = 0;
        for(j = 0; j < ch.length; j++){

            if(Character.isDigit(ch[j])){
                if(valor.contains("k"))
                    valor = "";
                valor = valor + ch[j];
                if (j > 0 && ch[j - 1] == '-')
                    valor = '-' + valor;
            }

            if(!valor.contains("k") && (Character.isWhitespace(ch[j]))){
                lista.agrega(Integer.parseInt(valor));
                valor = "k";
            }
        }
        if(lista.esVacia()){
            System.out.println(SVGLineas.graficaVacia());
            System.exit(1);
        }
        return lista;
    }

}
