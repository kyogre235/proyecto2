package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.proyecto2.SVG.SVGgenerador; 

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
    generador.generador(lista);
    
  } catch (ArrayIndexOutOfBoundsException e) {
    lista = lector.lectorEntradaEstandar();
    generador.generador(lista);
  }
  
}
    
}