package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;
public class SVGArbolAVL{

    protected static void graficarArbol(ArbolAVL<Integer> arbol){
        String svg = "<?xml version='1.0' encoding='UTF-8' ?>"+"\n";
        Cola<Boolean> colaB = new Cola<>();
        Lista<VerticeArbolBinario<Integer>> lista = new Lista<>();
        Cola<Integer> colaP = new Cola<>();
        BFS bfs = new BFS(arbol);
        colaB = bfs.getCola();
        lista = bfs.getLista();
        colaP = bfs.getColaP();
        int nivel = arbol.altura();
        int largo = 22 * (nivel+1);
        int ancho = 155 * (nivel+1);
        double radio = 10;
        double letra = 5;
        double reductor = 1;
        if(nivel>5){
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
        double xa;
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
                xa = colaP.saca();
                vertice = lista.eliminaUltimo();
                int alt = vertice.altura();
                int balance = balanceSeguro(vertice);
                String bal = alt + "/" + balance;
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

                if(xa == 0){
                    svg = svg + String.format("<text fill='black' font-family='sans-serif' font-size='%f' x='%f' y='%f' text-anchor='middle'>%s</text>\n",letra,x,(y+(1*reductor))-(radio + 3),bal);
                }
                if(xa == 1){
                    svg = svg + String.format("<text fill='black' font-family='sans-serif' font-size='%f' x='%f' y='%f' text-anchor='middle'>%s</text>\n",letra,x-(radio*1.5),(y+(1*reductor))-(radio*.5),bal);
                }
                if(xa == 2){
                    svg = svg + String.format("<text fill='black' font-family='sans-serif' font-size='%f' x='%f' y='%f' text-anchor='middle'>%s</text>\n",letra,x+(radio*1.5),(y+(1*reductor))-(radio*.5),bal);
 
                }
                
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
        aux = aux - 4; 
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

    private static int balanceSeguro(VerticeArbolBinario<Integer> v){
        if(v.hayIzquierdo() && v.hayDerecho())
            return v.izquierdo().altura() - v.derecho().altura();
        else if(!v.hayIzquierdo() && v.hayDerecho())
            return (-1) - v.derecho().altura();
        else if(v.hayIzquierdo() && !v.hayDerecho())
            return v.izquierdo().altura() - (-1);
        else
            return 0;
    }
}