package mx.unam.ciencias.edd.proyecto2.SVG;

import mx.unam.ciencias.edd.Grafica;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.VerticeGrafica;
import mx.unam.ciencias.edd.proyecto2.Lector;

public class SVGGrafica {
  protected void graficarGrafica(Grafica<Integer> grafica){
    Lista<VerticeGrafica<Integer>> vertices = new Lista<>();
    double intervalo = 360/grafica.getElementos();
    double radio = 250;
    grafica.paraCadaVertice(v -> {vertices.agregaFinal(v);});

    String svg = SVGLineas.iniciarGraficos();
    svg += SVGLineas.graficarArea(540, 540);
    double x, x2;
    double y, y2;
    int i = -1;
    
    for(VerticeGrafica<Integer> vertice : vertices){
        i++;
        x = (Math.cos(Math.toRadians(intervalo * i)) * radio) + radio + 20;
        y = (Math.sin(Math.toRadians(intervalo * i)) * radio) + radio + 20;

        for (VerticeGrafica<Integer> vecino : vertice.vecinos()) {
            int i2 = vertices.indiceDe(vecino);
            x2 = (Math.cos(Math.toRadians(intervalo * i2)) * radio) + radio + 20;
            y2 = (Math.sin(Math.toRadians(intervalo * i2)) * radio) + radio + 20;
            svg += SVGLineas.graficarLinea(x,y,x2,y2,1); 
        }
    }

    for(i = 0; i < grafica.getElementos(); i++){
        x = (Math.cos(Math.toRadians(intervalo * i)) * radio) + radio + 20;
        y = (Math.sin(Math.toRadians(intervalo * i)) * radio) + radio + 20;
        svg += SVGLineas.graficarCirculo(x, y, 10, "black", 1, "white");
        svg += SVGLineas.graficarTexto("black", 5, x, y+2, vertices.get(i).get().toString());
    }
    
    svg += SVGLineas.finalizarGrafica();

    Lector l = new Lector();
    l.escritor(svg);
  }
}
