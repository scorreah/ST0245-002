import java.io.*;
import java.net.*;
import java.util.*;
import javafx.util.Pair;

public class Lectura { 
    public static ArrayList<Integer> malas = new ArrayList<Integer>(Arrays.asList(0,2,3,11,12,14,15,16,17,18,19,20,21,22,23,24,25,26,30,31,32,33,34,37,38,39,40,41,43,44,46,47,48,49,50,51,56,57,58,61,62,63,64,0));
    public static String Matriz[][]= null;
    public static List<Integer> miLista = new ArrayList<Integer>(List.of(0, 1, 2, 3, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 43, 44, 46, 47, 48, 49, 50, 51, 56, 57, 58, 61, 62, 63, 64, 75, 76));
    public Lectura(String s) throws Exception {
        BufferedReader l1= new BufferedReader(new FileReader(s));
        String linea;
        int cont = 0;
        while((linea = l1.readLine()) != null) {
            cont++; 
        }
        l1.close();
        Lectura.Matriz=  new String[cont][32];
        BufferedReader l2= new BufferedReader(new FileReader(s));
        int z= 0;
        int v =0;
        while((linea=l2.readLine())!=null){
            String[] splitted = linea.split(";");
            for(int i =0; i< splitted.length; i++) {
                if(miLista.contains(i)){
                    continue;                
                }else{
                    Matriz[z][v]= splitted[i];
                    v++;
                }
            }
            v=0;
            z++;
        }
        l2.close();
    }

    public static void main(String[] args) throws Exception{
        
        /*Calculo n = new Calculo();
        Pair<Integer,String> respuesta=n.encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(Matriz);
        Pair<String[][],String[][]> parejaDeMatrices = n.dividirUnaMatrizEnDosMatricesSin(Matriz, respuesta.getKey(), respuesta.getValue());
        float mm = n.laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices.getKey());
        float mm1 = n.laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices.getValue());
        Pair<Integer,String> respuesta2=n.encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(parejaDeMatrices.getKey());
        Pair<String[][],String[][]> parejaDeMatrices1 = n.dividirUnaMatrizEnDosMatricesSin(parejaDeMatrices.getKey(), respuesta2.getKey(), respuesta2.getValue());
        float mm2 = n.laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices1.getKey());
        float mm3 = n.laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices1.getValue());
        
        Pair<Integer,String> respuesta3=n.encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(parejaDeMatrices.getValue());
        Pair<String[][],String[][]> parejaDeMatrices2 = n.dividirUnaMatrizEnDosMatricesSin(parejaDeMatrices.getValue(), respuesta3.getKey(), respuesta3.getValue());
        float mm4 = n.laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices2.getKey());
        float mm5 = n.laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices2.getValue());
        Pair<Integer,String> respuesta4=n.encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(parejaDeMatrices2.getKey());
        Pair<String[][],String[][]> parejaDeMatrices3 = n.dividirUnaMatrizEnDosMatricesSin(parejaDeMatrices2.getValue(), respuesta4.getKey(), respuesta4.getValue());
         Pair<Integer,String> respuesta5=n.encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(parejaDeMatrices3.getValue());
        Pair<String[][],String[][]> parejaDeMatrices4 = n.dividirUnaMatrizEnDosMatricesSin(parejaDeMatrices3.getValue(), respuesta5.getKey(), respuesta5.getValue());
        //System.out.println(n.calcularLaImpurezaPonderada(Matriz, 2, "B+"));
        */
        
    }
}
