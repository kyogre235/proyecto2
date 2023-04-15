package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.Color;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class SVGArbolRojinegro extends SVGArbol{
    protected void graficarArbol(ArbolRojinegro<Integer> arbol){
        super.graficarArbol(arbol);
    }

    @Override
    protected String imprimeTexto(double letra, double x, double y, String texto, double xa, double reductor,
            String bal, double radio) {
        return SVGLineas.graficarTexto("white", letra, x, y + 1, texto);
    }
    @Override
    protected String imprimeVertice(double x, double y, double radio, String colorBorde, double ancho,
            String color, VerticeArbolBinario<Integer> vertice){
                ArbolRojinegro<Integer> a = new ArbolRojinegro<>();
                if(a.getColor(vertice) == Color.NEGRO)
                 return SVGLineas.graficarCirculo(x, y, radio, colorBorde, ancho, "black");
                else
                   return SVGLineas.graficarCirculo(x, y, radio, "red", ancho, "red");
    }
}
