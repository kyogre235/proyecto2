package mx.unam.ciencias.edd.proyecto2;

public class SVGLineas {
    
    private SVGLineas(){};

    protected static String graficarRectangulo(int x, int y, int ancho, int largo, int grosor){
        return String.format("<rect x='%d' y='%d' width='%d' height='%d' stroke='black' stroke-width='%d' fill='white'/>\n",x,y,ancho,largo,grosor);
    }

    protected static String graficarLinea(int x, int y, int x2, int y2, int grosor){
        return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='%d'/>\n",x,y,x2,y2,grosor);
    }
    
    protected static String graficarPoligono(int x, int y, int x2, int y2,int x3, int y3){
        return String.format("<polygon points='%d,%d %d,%d %d,%d' fill='black' />\n",x,y,x2,y2,x3,y3);
    } 
    protected static String graficarTexto(int size, int x, int y, int texto ){
        return String.format("<text fill='black' font-family='sans-serif' font-size='%d' x='%d' y='%d' text-anchor='middle'>%d</text>",size,x,y,texto)+"\n";
    }
    protected static String graficarCirculo(int x, int y, int radio, int ancho){
       return String.format("<circle cx='%f' cy='%f' r='%f' stroke='black' stroke-width='%d' fill='black' />\n",x,y,radio,ancho);
    }

    protected static String iniciarGraficos(){
        return "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
    }

    protected static String graficarArea(int ancho,int largo){
        return String.format("<svg width='%d' height='%d'>\n", ancho, largo)+"<g>\n"+
        String.format("<rect width='%d' height='%d' stroke='white' fill='white'/>\n", ancho, largo);
    }
    protected static String finalizarGrafica(){
        return "</g>\n</svg>";
    }
}
