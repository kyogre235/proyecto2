package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;

public class SVGArbolBinarioOrdenado {
    protected static void graficarArbol(ArbolBinarioOrdenado<Integer> arbol){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        Cola<Boolean> colaB = new Cola<>();
        Lista<VerticeArbolBinario<Integer>> lista = new Lista<>();

        DFS bfs = new DFS(arbol);
        colaB = bfs.getCola();
        lista = bfs.getLista();
       
        int nivel = arbol.altura();
        int largo = 22 * (nivel+1);
        int ancho = 155 * (nivel+1);
        double radio = 10;
        double letra = 5;
        double reductor = 1;
        if(nivel>6){
            reductor = reducir(nivel);
            radio = radio*reductor;
            letra = letra*reductor;
        }
        VerticeArbolBinario<Integer> vertice;
        svg = svg + "<svg width='"+ancho+"' height='"+largo+"'>"+"\n"+"<g>"+"\n";
        svg = svg + "<rect width='"+ancho+"' height='"+largo+"' stroke='white' fill='white'/>"+"\n";
        int i=0 , j=0;
        double espacio = ancho;
        vertice = arbol.raiz();
        
        double x = espacio;
        double y = 5;
        double x2;
        double y2;
        double consta = 19;
        boolean existe;

        while(!colaB.esVacia()){
            existe = colaB.saca();
            
            if(j == Math.pow(2,i)){
                i++;
                j = 0;
            }
            x = espacioNivel(espacio,i+1)+(espacioNivel(espacio, i+1)*j*2);
            y = consta * (i+1);

            
             
            if(existe){
                vertice = lista.eliminaUltimo();

                if(vertice.hayIzquierdo()){
                    x2 = (x+(espacioNivel(espacio, i+1)*j*2))/2;
                    y2 = y + consta;
                    svg = svg + String.format("<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='black' stroke-width='1' />",x,y,x2,y2)+"\n";
            
                }
                    
                if(vertice.hayDerecho()){
                    x2 = x +(x-(espacioNivel(espacio, i+1)*j*2))/2;
                    y2 = y + consta;
                    svg = svg + String.format("<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='black' stroke-width='1' />",x,y,x2,y2)+"\n";
                        
                }                   
                svg = svg + String.format("<circle cx='%f' cy='%f' r='%f' stroke='black' stroke-width='1' fill='black' />\n",x,y,radio);

               svg = svg + String.format("<text fill='white' font-family='sans-serif' font-size='%f' x='%f' y='%f' text-anchor='middle'>%d</text>\n",letra,x,y+(1*reductor),vertice.get());

                j++;
            } else
                j++;        
        }
        svg = svg +"</g>"+"\n"+"</svg>";
       
        Lector l = new Lector();
        l.escritor(svg);
    }

    private static double reducir(int a){
        double regreso = 1;
        int aux = a;
        aux = aux - 6; 
        while(aux > 1){
            regreso = regreso / 2;
            aux = aux - 1;
        }
        
        return regreso;
    }

    private static double espacioNivel(double a, double b){
        double regreso = a;
        for (double c = 0;c < b ; c++)
            regreso = regreso / 2;
        return regreso;
    }
}
