package mx.unam.ciencias.edd.proyecto2.SVG;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;


public class SVGArbolBinarioOrdenado extends SVGArbol {

    protected void graficarArbol(ArbolBinarioOrdenado<Integer> arbol){
     super.graficarArbol(arbol);   
    }

    @Override
    protected String imprimeTexto(double letra, double x, double y, String texto, double xa, double reductor,
            String bal, double radio) {
        return SVGLineas.graficarTexto("white", letra, x, y + 1, texto);
    }
}
