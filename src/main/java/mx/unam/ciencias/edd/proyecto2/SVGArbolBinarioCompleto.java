package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;

public class SVGArbolBinarioCompleto {
    protected static void graficarArbol(ArbolBinarioCompleto<Integer> arbol){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        int nivel = 0;
        nivel = arbol.altura();
        svg = svg +"";
        int pixeles = 10 * nivel;
        svg = svg + "<svg width='200' height='"+pixeles+"'>"+"\n"+"<g>"+"\n";
        svg = svg + "<rect width='200' height='"+pixeles+"' stroke='white' fill='white'/>"+"\n";
        int i;
        
        for(i = 1;i <= nivel;i++){

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
