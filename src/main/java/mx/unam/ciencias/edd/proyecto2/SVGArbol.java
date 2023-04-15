package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolBinario;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;

public class SVGArbol {
    protected void graficarArbol(ArbolBinario<Integer> arbol) {
        String svg = SVGLineas.iniciarGraficos();
        Cola<Boolean> colaB = new Cola<>();
        Lista<VerticeArbolBinario<Integer>> lista = new Lista<>();
        Cola<Integer> colaP = new Cola<>();
        BFS bfs = new BFS(arbol);
        colaB = bfs.getCola();
        lista = bfs.getLista();
        colaP = bfs.getColaP();
        int nivel = arbol.altura();
        int largo = 5 + (20 * (nivel + 1));
        double ancho = 240 * (nivel + 1);
        double radio = 9;
        double letra = 4.5;
        double reductor = 1;
        if (nivel > 5) {
            reductor = reducir(nivel);
            radio = radio * reductor;
            letra = letra * reductor;
            ancho = ancho / (reductor / 1.95);
        }
        VerticeArbolBinario<Integer> vertice;
        svg += SVGLineas.graficarArea(ancho, largo);
        int i = 0, j = 0;
        double espacio = ancho;
        vertice = arbol.raiz();

        double x = espacio;
        double y = 0;
        double x2;
        double y2;
        double xa;
        double consta = 20;
        boolean existe;

        while (!colaB.esVacia()) {
            existe = colaB.saca();

            if (j == Math.pow(2, i)) {
                i++;
                j = 0;
            }
            x = espacioNivel(espacio, i + 1) + (espacioNivel(espacio, i + 1) * j * 2);
            y = 15 + (consta * (i));

            if (existe) {
                xa = colaP.saca();
                vertice = lista.eliminaUltimo();
                int alt = vertice.altura();
                int balance = balanceSeguro(vertice);
                String bal = alt + "/" + balance;
                if (vertice.hayIzquierdo()) {
                    x2 = (x + (espacioNivel(espacio, i + 1) * j * 2)) / 2;
                    y2 = y + consta;
                    svg += SVGLineas.graficarLinea(x, y, x2, y2, 1);
                }

                if (vertice.hayDerecho()) {
                    x2 = x + (x - (espacioNivel(espacio, i + 1) * j * 2)) / 2;
                    y2 = y + consta;
                    svg += SVGLineas.graficarLinea(x, y, x2, y2, 1);
                }
                svg += imprimeVertice(x, y, radio, "black", 1, "black", vertice);
                svg += imprimeTexto(letra, x, y + (1 * reductor), vertice.get().toString(), xa, reductor, bal, radio);
                
                j++;
            } else
                
                j++;
               
        }
        svg += SVGLineas.finalizarGrafica();

        Lector l = new Lector();
        l.escritor(svg);
    }

    private static double reducir(int a) {
        double regreso = 1;
        int aux = a;
        aux = aux - 5;
        while (aux > 1) {
            regreso = regreso / 1.15;
            aux = aux - 1;
        }

        return regreso;
    }

    private static double espacioNivel(double a, double b) {
        double regreso = a;
        for (double c = 0; c < b; c++)
            regreso = regreso / 2;
        return regreso;
    }

    private static int balanceSeguro(VerticeArbolBinario<Integer> v) {
        if (v.hayIzquierdo() && v.hayDerecho())
            return v.izquierdo().altura() - v.derecho().altura();
        else if (!v.hayIzquierdo() && v.hayDerecho())
            return (-1) - v.derecho().altura();
        else if (v.hayIzquierdo() && !v.hayDerecho())
            return v.izquierdo().altura() - (-1);
        else
            return 0;
    }

    protected String imprimeVertice(double x, double y, double radio, String colorBorde, double ancho,
            String color, VerticeArbolBinario<Integer> vertice) {
        return SVGLineas.graficarCirculo(x, y, radio, colorBorde, ancho, color);
    }

    protected String imprimeTexto(double letra, double x, double y, String texto, double xa, double reductor,
            String bal, double radio) {
        String svg = SVGLineas.graficarTexto("white", letra, x, y + (1 * reductor), texto);

        if (xa == 0) {
            svg += SVGLineas.graficarTexto("black", letra, x, (y + (1 * reductor)) - (radio + 3), bal);
        }
        if (xa == 1) {
            svg += SVGLineas.graficarTexto("black", letra, x - (radio * 1.1), (y + (1 * reductor)) - (radio * 1.1), bal);
        }
        if (xa == 2) {
            svg += SVGLineas.graficarTexto("black", letra, x + (radio * 1.1), (y + (1 * reductor)) - (radio * 1.1), bal); 
        }

        return svg;
    }
}
