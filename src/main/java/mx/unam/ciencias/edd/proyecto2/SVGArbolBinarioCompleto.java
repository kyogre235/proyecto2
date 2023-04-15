package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;


public class SVGArbolBinarioCompleto extends SVGArbol {
    protected void graficarArbol(ArbolBinarioCompleto<Integer> arbol){
        super.graficarArbol(arbol);
    }

   @Override
    protected String imprimeTexto(double letra, double x, double y, String texto, double xa, double reductor,
            String bal, double radio){
                return SVGLineas.graficarTexto("white", letra, x, y + 1, texto);
    }
}

