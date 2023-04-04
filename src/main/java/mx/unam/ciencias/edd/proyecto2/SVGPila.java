package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
public class SVGPila {
   protected static void graficarPila(Lista<Integer> lista){
    String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        int tamLista = lista.getElementos();
        int pixeles = 10 + (21*tamLista);
        svg = svg + "<svg width='54' height='"+pixeles+"'>"+"\n"+"<g>"+"\n";
        svg = svg + "<rect width='54' height='"+pixeles+"' stroke='white' fill='white'/>"+"\n";

        int i;
        int inicio = 10;
        for(i = 0 ;i < tamLista; i++){
            int tam = inicio +(20*i);
            String rectangulo = String.format
            ("<rect x='5' y='%d' width='44' height='20' stroke='black' stroke-width='1' fill='white'/>",tam);
            svg = svg + rectangulo + "\n";
            svg = svg + 
            String.format("<text fill='black' font-family='sans-serif' font-size='10' x='27' y='%d' text-anchor='middle'>%d</text>",tam+13,lista.get((tamLista-1)-i))
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
