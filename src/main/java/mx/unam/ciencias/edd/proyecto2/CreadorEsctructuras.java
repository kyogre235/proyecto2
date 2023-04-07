package mx.unam.ciencias.edd.proyecto2;


import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.ArbolAVL;
//faltan graficas
public class CreadorEsctructuras {
    /**constructor privado para que no se pueda instanciar la clase */
    private CreadorEsctructuras(){};
    
    protected static Lista<Integer> creadorLista(String args){
        Lista <Integer> lista = new Lista<>();
        String valor ="k";
        Character[] ch = Linea.lineaChar(args);
        int j = 0;
        valor = "k";

        for(j = 0; j < ch.length; j++){

            if(Character.isDigit(ch[j])){
                if(valor.contains("k"))
                    valor = "";
                valor = valor + ch[j];
            }

            if(!valor.contains("k") && (Character.isWhitespace(ch[j]))){
                lista.agrega(Integer.parseInt(valor));
                valor = "k";
            }
        }
        return lista;
    }

    
    protected static ArbolBinarioCompleto<Integer> creadorArbolBinarioCompleto(String args){
        ArbolBinarioCompleto <Integer> abc = new ArbolBinarioCompleto<>();
        String valor ="k";
        Character[] ch = Linea.lineaChar(args);
        int j = 0;
        valor = "k";

        for(j = 0; j < ch.length; j++){

            if(Character.isDigit(ch[j])){
                if(valor.contains("k"))
                    valor = "";
                valor = valor + ch[j];
            }

            if(!valor.contains("k") && (Character.isWhitespace(ch[j]))){
                abc.agrega(Integer.parseInt(valor));
                valor = "k";
            }
        }
        return abc;
    }

    protected static ArbolBinarioOrdenado<Integer> creadorArbolBinarioOrdenado(String args){
        ArbolBinarioOrdenado <Integer> abo = new ArbolBinarioOrdenado<>();
        String valor ="k";
        Character[] ch = Linea.lineaChar(args);
        int j = 0;
        valor = "k";

        for(j = 0; j < ch.length; j++){

            if(Character.isDigit(ch[j])){
                if(valor.contains("k"))
                    valor = "";
                valor = valor + ch[j];
            }

            if(!valor.contains("k") && (Character.isWhitespace(ch[j]))){
                abo.agrega(Integer.parseInt(valor));
                valor = "k";
            }
        }
        return abo;
    }

    protected static ArbolRojinegro<Integer> creadorArbolRojinegro(String args){
        ArbolRojinegro <Integer> arn = new ArbolRojinegro<>();
        String valor ="k";
        Character[] ch = Linea.lineaChar(args);
        int j = 0;
        valor = "k";

        for(j = 0; j < ch.length; j++){

            if(Character.isDigit(ch[j])){
                if(valor.contains("k"))
                    valor = "";
                valor = valor + ch[j];
            }

            if(!valor.contains("k") && (Character.isWhitespace(ch[j]))){
                arn.agrega(Integer.parseInt(valor));
                valor = "k";
            }
        }
        return arn;
    }
   
    protected static ArbolAVL<Integer> creadorArbolAVL(String args){
        ArbolAVL <Integer> aAVL = new ArbolAVL<>();
        String valor ="k";
        Character[] ch = Linea.lineaChar(args);
        int j = 0;
        valor = "k";

        for(j = 0; j < ch.length; j++){

            if(Character.isDigit(ch[j])){
                if(valor.contains("k"))
                    valor = "";
                valor = valor + ch[j];
            }

            if(!valor.contains("k") && (Character.isWhitespace(ch[j]))){
                aAVL.agrega(Integer.parseInt(valor));
                valor = "k";
            }
        }
        return aAVL;
    }
    //cambia rojinegro por grafica
    protected static ArbolRojinegro<Integer> creadorGrafica(String args){
        ArbolRojinegro <Integer> aAVL = new ArbolRojinegro<>();
        //aqui va el codigo faltante
        return aAVL;
    }

}
