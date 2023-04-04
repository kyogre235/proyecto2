package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;

public class SVGgenerador {
    /**constructor privado para evitar la creacion de instancias*/
    public SVGgenerador(){};

    public void generador(Linea args){
       String argumento = args.getLineaPlana();
       
            if(argumento.contains("Lista")){
                
                Lista<Integer> estructura = CreadorEsctructuras.creadorLista(argumento);
                System.out.println(estructura.toString());
                svgLista(estructura);
            } else if(argumento.contains("Pila")){
                
                Pila<Integer> estructura = CreadorEsctructuras.creadorPila(argumento);
                
            } else if(argumento.contains("Cola")){
                
                Cola<Integer> estructura = CreadorEsctructuras.creadorCola(argumento);
                
            } else if(argumento.contains("ArbolBinarioCompleto")){
                
                ArbolBinarioCompleto<Integer> estructura = 
                CreadorEsctructuras.creadorArbolBinarioCompleto(argumento);
                
            } else if(argumento.contains("ArbolBinarioOrdenado")){
                
                ArbolBinarioCompleto<Integer> estructura = 
                CreadorEsctructuras.creadorArbolBinarioCompleto(argumento);
                
            } else if(argumento.contains("ArbolRojinegro")){
                
                ArbolRojinegro<Integer> estructura = CreadorEsctructuras.creadorArbolRojinegro(argumento);
                
            } else if(argumento.contains("ArbolAVL")){
                //coloca el AVL
                
                CreadorEsctructuras.creadorArbolAVL(argumento);
                
            } else if(argumento.contains("Grafica")){
                //coloca la grafica
                
                CreadorEsctructuras.creadorGrafica(argumento);
                
            } else {
                System.err.println("la escructura no esta bien escrita o no existe");
            }
        
        return;

    }

    protected void svgLista(Lista<Integer> lista){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        int tamLista = lista.getElementos();
        int pixeles = 20 + (54*tamLista);
        svg = svg + "<svg fill='white' width='"+pixeles+"' height='100'>"+"\n"+"<g>"+"\n";
        svg = svg + "<rect x='0' y='14' width='"+pixeles+"' height='50' stroke='white' fill='white'/>"+"\n";
        int i;
        svg = svg + "<rect x='10' y='30' width='44' height='20' stroke='black' stroke-width='1' fill='white'/>"+"\n";
        svg = svg + 
        String.format("<text fill='black' font-family='sans-serif' font-size='10' x='%d' y='44' text-anchor='middle'>%d</text>",32 ,lista.get(0))
        +"\n";
        int inicio = 10;
        for(i = 1; i<tamLista; i++){
            int tam =inicio +(54*i) ;
            
            String rectangulo = String.format
            ("<rect x='%d' y='30' width='44' height='20' stroke='black' stroke-width='1' fill='white'/>",tam);
            svg = svg + rectangulo + "\n";
            svg = svg + 
            String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='1'/>",tam-8,40,tam-2,40)
            +"\n";
            svg = svg + 
            String.format("<polygon points='%d,40 %d,43 %d,37' fill='black' />",tam-9,tam-7,tam-7)
            +"\n";
            svg = svg + 
            String.format("<polygon points='%d,40 %d,43 %d,37' fill='black' />",tam-1,tam-3,tam-3)
            +"\n";
            svg = svg + 
            String.format("<text fill='black' font-family='sans-serif' font-size='10' x='%d' y='44' text-anchor='middle'>%d</text>",tam+22,lista.get(i))
            +"\n";

        }

        svg = svg +"</g>"+"\n"+"</svg>";

        try {
            Lector l = new Lector();
            l.escritor(svg);
        } catch (Exception e) {
            System.err.println("no se ha podigo guardar el archivo");
        }

    }
}

//<line x1='54' y1='40' x2='64' y2='40' stroke='black' stroke-width='1'/>
//ref = 64
//String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='1'/>",tam-10,tam-24,tam,tam-24,)
//"<rect x='%d' y='50' width='44' height='80'/>"

//<polygon points="55,40 57,43 57,37" fill='black' />
//String.format("<polygon points="%d,40 %d,43 %d,37" fill='black' />",tam-9,tam-7,tam-7)

//<polygon points='63,40 61,43 61,37' fill='black' />
//String.format("<polygon points='%d,40 %d,43 %d,37' fill='black' />",tam-1,tam-3,tam-3);

//<text fill='black' font-family='sans-serif' font-size='10' x='32' y='44' text-anchor='middle'>14</text>
//ref = 10
//String.format("<text fill='black' font-family='sans-serif' font-size='10' x='%d' y='44' text-anchor='middle'>%d</text>",tam+22,lista.get(i)))