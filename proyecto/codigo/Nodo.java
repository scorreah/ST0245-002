import java.io.*;
import java.net.*;
import java.util.*;
import javafx.util.Pair;
public class Nodo{
    public Nodo izq;
    public Nodo der;
    public String mejorV;
    public int mejorC;
    public String[][] d; //O(N x M x 2(NxM/2))    O(N x M x 2^M)
    public String[][] i;
    public double exito;
    
    public Nodo(String[][] m){
        izq = null;
        der = null;
        Calculo n = new Calculo();
        Pair<Integer,String> respuesta = n.encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(m); //(Columna, condicion)
        mejorV = respuesta.getValue(); //Valor
        mejorC = respuesta.getKey();   //Columna
        Pair<String[][],String[][]> parejaDeMatrices = n.dividirUnaMatrizEnDosMatricesSin(m, respuesta.getKey(), respuesta.getValue());
        d = parejaDeMatrices.getKey();
        i = parejaDeMatrices.getValue();
        exito = n.PorcentajeDeExito(m);
    }
}
