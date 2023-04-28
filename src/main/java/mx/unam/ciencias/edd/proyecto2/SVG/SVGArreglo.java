package mx.unam.ciencias.edd.proyecto2.SVG;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.proyecto2.Lector;

public class SVGArreglo {
    protected static void graficarArreglo(Lista<Integer> listaS){
        String svg = SVGLineas.iniciarGraficos();
        int tamLista = listaS.getElementos();
        int pixeles = 20 + (44 * tamLista);

        svg += SVGLineas.graficarArea(pixeles, 60);

        Lista<Integer> lista = listaS;
       
        int i;
        int inicio = 10;

        for (i = 0; i < tamLista; i++) {
            int tam = inicio + (44 * i);

            svg += SVGLineas.graficarRectangulo(tam, 20, 44, 20, 1);
            svg += SVGLineas.graficarTexto("black", 10, tam + 22, 34, lista.get(i).toString());

        }
        svg += "<rect x='0' y='14' width='9' height='50' stroke='white' fill='white'/>" + "\n";

        svg += SVGLineas.finalizarGrafica();
        Lector l = new Lector();
        l.escritor(svg);
    }
}
