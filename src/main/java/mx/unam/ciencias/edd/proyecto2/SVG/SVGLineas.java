package mx.unam.ciencias.edd.proyecto2.SVG;
/**
 * clase en donde estan los formatos para crear diferentes estructuras en un SVG
 * digamos que es una clase con plantillas
 */
public class SVGLineas {
    /** constructor privado para evitar la creacion de instancias */
    private SVGLineas(){};

    protected static String graficarRectangulo(double x, double y, double ancho, double largo, double grosor){
        return String.format("<rect x='%f' y='%f' width='%f' height='%f' stroke='black' stroke-width='%f' fill='white'/>\n",x,y,ancho,largo,grosor);
    }

    protected static String graficarLinea(double x, double y, double x2, double y2, double grosor){
        return String.format("<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='black' stroke-width='%f'/>\n",x,y,x2,y2,grosor);
    }
    
    protected static String graficarPoligono(double x, double y, double x2, double y2,double x3, double y3){
        return String.format("<polygon points='%f,%f %f,%f %f,%f' fill='black' />\n",x,y,x2,y2,x3,y3);
    } 
    protected static String graficarTexto(String color, double size, double x, double y, String texto ){
        return String.format("<text fill='%s' font-family='sans-serif' font-size='%f' x='%f' y='%f' text-anchor='middle'>%s</text>",color, size,x,y,texto)+"\n";
    }
    protected static String graficarCirculo(double x, double y, double radio,String colorBorde, double ancho,String color){
       return String.format("<circle cx='%f' cy='%f' r='%f' stroke='%s' stroke-width='%f' fill='%s' />\n",x,y,radio,colorBorde,ancho,color);
    }

    protected static String iniciarGraficos(){
        return "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
    }

    protected static String graficarArea(double ancho,double largo){
        return String.format("<svg width='%f' height='%f'>\n", ancho, largo)+"<g>\n"+
        String.format("<rect width='%f' height='%f' stroke='white' fill='white'/>\n", ancho, largo);
    }
    public static String graficaVacia(){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?><svg width='200' height='200'><g><rect width='200' height='200' stroke='white' fill='white'/></g></svg>";
        return svg; 
    }
    protected static String finalizarGrafica(){
        return "</g>\n</svg>";
    }
}
