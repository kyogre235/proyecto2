package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
public class SVGLista {
    
    protected static void graficarLista(Lista<Integer> listaS, boolean esLista){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        int tamLista = listaS.getElementos();
        int pixeles = 20 + (54*tamLista);
        svg = svg + "<svg width='"+pixeles+"' height='100'>"+"\n"+"<g>"+"\n";
        svg = svg + "<rect x='0' y='14' width='"+pixeles+"' height='50' stroke='white' fill='white'/>"+"\n";
        Lista<Integer> lista = listaS;
        if(!esLista)
            lista = lista.reversa();
        int i; 
        int inicio = 10;
        for(i = 0; i<tamLista; i++){
            int tam = inicio +(54*i);
            String rectangulo = String.format
            ("<rect x='%d' y='30' width='44' height='20' stroke='black' stroke-width='1' fill='white'/>",tam);
            svg = svg + rectangulo + "\n";
            svg = svg + 
            String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='1'/>",tam-8,40,tam-2,40)
            +"\n";
            if(esLista)
                svg = svg + String.format("<polygon points='%d,40 %d,43 %d,37' fill='black' />",tam-9,tam-7,tam-7)+"\n";
            svg = svg + 
            String.format("<polygon points='%d,40 %d,43 %d,37' fill='black' />",tam-1,tam-3,tam-3)
            +"\n";
            svg = svg + 
            String.format("<text fill='black' font-family='sans-serif' font-size='10' x='%d' y='44' text-anchor='middle'>%d</text>",tam+22,lista.get(i))
            +"\n";
        }
        svg = svg + "<rect x='0' y='14' width='9' height='50' stroke='white' fill='white'/>"+"\n";
        svg = svg +"</g>"+"\n"+"</svg>";
        try {
            Lector l = new Lector();
            l.escritor(svg);
        } catch (Exception e) {
            System.err.println("no se ha podigo guardar el archivo");
        }
    }
}
