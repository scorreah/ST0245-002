
/**
 * Write a description of class as here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.LinkedList;
public class TecladoRoto{
    //Punto 2.1
    public static void teclado(String a){
        LinkedList<Character> texto = new LinkedList<>();
        LinkedList<Character> aux = new LinkedList<>();
        
        boolean inicio = false;
        for (int i = 0; i < a.length(); i++) {      //O(n)
            if (a.substring(i, i+1).equals("[")) {
                if(aux.size() != 0){
                    texto.addAll(0, aux);
                    aux.clear();
                }
                inicio = true;
                continue;
            }
            else if (a.substring(i, i+1).equals("]")) {   //beijuThis_is_a
                inicio = false;
                continue;
            }
            else if (inicio)    aux.addLast(a.charAt(i));
            else if (!inicio)   texto.addLast(a.charAt(i));
        }
        
        if (aux.size() != 0) texto.addAll(0, aux);
        aux.clear();
        Character[] txtRoto = new Character[texto.size()]; 
        txtRoto = texto.toArray(new Character[texto.size()]);
        for (int i = 0; i < txtRoto.length; i++) {      //O(n)
            System.out.print(txtRoto[i]);
        }
        System.out.println("");
        //int var = 0;
    }
}