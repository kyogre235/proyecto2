package mx.unam.ciencias.edd.proyecto2.SVG;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.Lector;

/**
 * Clase que genera un String con las instrucciones nesesarias para imprimir
 * una Lista en formato SVG
 */
public class SVGLista {
    
    /**
     * metodo estatico encardado de imprimr el SVG.
     * @param Lista es la estructura en donde estan los datos a imprimir.
     */
    protected static void graficarLista(Lista<Integer> listaS, boolean esLista) {

        String svg = SVGLineas.iniciarGraficos();
        int tamLista = listaS.getElementos();
        int pixeles = 20 + (54 * tamLista);

        svg += SVGLineas.graficarArea(pixeles, 60);

        Lista<Integer> lista = listaS;
        if (!esLista)
            lista = lista.reversa();
        int i;
        int inicio = 10;

        for (i = 0; i < tamLista; i++) {
            int tam = inicio + (54 * i);

            svg += SVGLineas.graficarRectangulo(tam, 20, 44, 20, 1);
            svg += SVGLineas.graficarLinea(tam - 8, 30, tam - 2, 30, 1);

            if (esLista)
                svg += SVGLineas.graficarPoligono(tam - 9, 30, tam - 7, 33, tam - 7, 27);

            svg += SVGLineas.graficarPoligono(tam - 1, 30, tam - 3, 33, tam - 3, 27);
            svg += SVGLineas.graficarTexto("black",10, tam + 22, 34, lista.get(i).toString());

        }
        svg += "<rect x='0' y='14' width='9' height='50' stroke='white' fill='white'/>" + "\n";

        svg += SVGLineas.finalizarGrafica();
        Lector l = new Lector();
        l.escritor(svg);
    }
}
