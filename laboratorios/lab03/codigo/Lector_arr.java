
/**
 * Write a description of class sdsd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.net.*;
import java.util.LinkedList;
import java.io.*;
public class Lector_arr {
    public static LinkedList<Lugar> lector() throws Exception {
        BufferedReader l1= new BufferedReader(new FileReader("medellin_colombia-grande.txt"));
        String linea;
        LinkedList<Lugar> lista = new LinkedList<>();
        while((linea=l1.readLine())!=null) {
            
            if(linea.contains("Arcos")) {  //Arcos. Formato: ID ID distancia nombre"
                while((linea=l1.readLine())!=null) {       //Lee la linea siguiente
                    String[] s = linea.split(" ");
                    String lugar = "";
                    if (s.length >= 3) {
                        for (int i = 3; i < s.length; i++) {
                             lugar = lugar + s[i];
                        }
                        lista.add(new Arco(Long.parseLong(s[0]),Long.parseLong(s[1]),Double.parseDouble(s[2]), lugar));
                    } 
                }
                break;
            }else if (linea.equalsIgnoreCase("Vertices. Formato: ID coordenadaY coordenadaX nombre") ||
                      linea.equalsIgnoreCase("")) continue;
            else {
                String[] s = linea.split(" ");
                
                if(s.length<4) {
                    lista.add(new Vertice(Long.parseLong(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2])));
                }else {
                    lista.add(new Vertice(Long.parseLong(s[0]),Double.parseDouble(s[1]),Double.parseDouble(s[2]), s[3]));
                }
            }
        }
        l1.close();
        return lista;
    }  
    
    
}