package mx.unam.ciencias.edd.proyecto2;


/**
 * Proyecto2
 */
public class Proyecto2 {
public static void main(String[] args) {
  Lector lector = new Lector();
  SVGgenerador generador = new SVGgenerador();
  Linea lista;
  try {
    
    lista = lector.lector(args[0]);
    System.out.println(lista.getLineaPlana());
    generador.generador(lista);
    
  } catch (Exception e) {
    System.err.println("Error con el archivo");
  }
  
}
    
}