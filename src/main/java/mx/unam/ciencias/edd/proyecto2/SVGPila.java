package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
public class SVGPila {

    protected static void graficarPila(Lista<Integer> lista){
        String svg = SVGLineas.iniciarGraficos();
        int tamLista = lista.getElementos();
        int pixeles = 10 + (21*tamLista);
        
        svg += SVGLineas.graficarArea(54,pixeles);
        
        int i;
        int inicio = 10;
        for(i = 0 ;i < tamLista; i++){
            int tam = inicio +(20*i);
            svg += SVGLineas.graficarRectangulo(5, tam, 44, 20, 1);
            svg += SVGLineas.graficarTexto("black",10, 27, tam + 13, lista.get((tamLista-1)-i).toString());
        }
        svg += SVGLineas.finalizarGrafica(); 
        
        Lector l = new Lector();
         l.escritor(svg);
        
   } 
}
