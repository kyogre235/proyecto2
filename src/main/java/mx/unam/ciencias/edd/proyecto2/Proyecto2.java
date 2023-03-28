package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.Lista;
/**
 * Proyecto2
 */
public class Proyecto2 {
public static void main(String[] args) {
  Lector lector = new Lector();
 
  Lista<Linea> lista = new Lista<>();
  try {
    
    lista = lector.lector(args[0]);
    System.out.println(lista.toString());
    
  } catch (Exception e) {
    System.out.println("si");
  }
  
}
    
}