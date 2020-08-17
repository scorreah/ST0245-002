import java.io.*;
import java.net.*;
import java.util.*;

public class Lectura { 
    public static String Matriz[][]= null;
    public Lectura() throws Exception {
        BufferedReader l1= new BufferedReader(new FileReader("0_test_balanced_5000.csv"));
        String linea;      
        int cont = 0;
        while((linea = l1.readLine()) != null) {
            cont++; 
        }
        l1.close();
        Lectura.Matriz=  new String[78][cont];
        BufferedReader l2= new BufferedReader(new FileReader("0_test_balanced_5000.csv"));
        int z= 0;
        while((linea = l2.readLine())!=null){
            String[] splitted = linea.split(";");
            for(int i =0; i< splitted.length; i++) {
                Matriz[i][z]= splitted[i];
            }
            z++;
        }
        l2.close();
    }
    public static void main(String[] args) throws Exception{
        Lectura un = new Lectura();
        for(int i = 0; i<78;i++) {
            System.out.println(Matriz[i][10]);
        }
    }
}
