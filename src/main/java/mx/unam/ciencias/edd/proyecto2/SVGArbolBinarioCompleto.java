package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;

public class SVGArbolBinarioCompleto {
    protected static void graficarArbol(ArbolBinarioCompleto<Integer> arbol){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        int nivel = 0;
        nivel = arbol.altura();
        svg = svg +"";
        int pixeles = 22 * nivel;
        svg = svg + "<svg width='200' height='"+pixeles+"'>"+"\n"+"<g>"+"\n";
        svg = svg + "<rect width='200' height='"+pixeles+"' stroke='white' fill='white'/>"+"\n";
        int i = 0, j = 0;
        double espacio = 0;
        Lista<VerticeArbolBinario<Integer>> lista = colaPuntos(arbol);
        svg = svg + "<circle cx='100' cy='8' r='5' stroke='black' stroke-width='1' fill='white' />\n";
        i = 1;
        lista.eliminaPrimero();
        while(!lista.esVacia()){
            VerticeArbolBinario<Integer> ver = lista.eliminaPrimero();
            if(j == Math.pow(2,i)){
                i++;
                j = 0;
            }
            espacio = espacioNivel(100,i);
                
            Double a = espacio + (espacio*j*2);
            
            svg = svg + String.format("<circle cx='%f' cy='%d' r='5' stroke='black' stroke-width='1' fill='white'/>", a ,14 *(i+1))+"\n";
            j++;
        }

        svg = svg +"</g>"+"\n"+"</svg>";
        try {
            Lector l = new Lector();
            l.escritor(svg);
        } catch (Exception e) {
            System.err.println("no se ha podido guardar el archivo");
        }
    }
    
    private static double espacioNivel(int h,int i){
        double regreso = h;
        for(int a = 0;a<i;a++)
        regreso = regreso/2;
        return regreso;
    }
    private static Lista<VerticeArbolBinario<Integer>> colaPuntos(ArbolBinarioCompleto<Integer> arbol){
        Lista<VerticeArbolBinario<Integer>> lista = new Lista<>();
        Cola<VerticeArbolBinario<Integer>> cola = new Cola<>();
        VerticeArbolBinario<Integer> vertice = arbol.raiz();
        
        cola.mete(vertice);
        
        while(!cola.esVacia()){
            vertice = cola.saca();
            lista.agregaInicio(vertice);
            if(vertice.hayIzquierdo())
                cola.mete(vertice.izquierdo());
            if(vertice.hayDerecho())
                cola.mete(vertice.derecho());
        }
        return lista;
    }
}
