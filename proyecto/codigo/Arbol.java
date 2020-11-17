import java.io.*;
import java.net.*;
import java.util.*;
import javafx.util.Pair;
public class Arbol{
    public Arbol(){}

    public Nodo arbolDeDesicion(String[][] m){  
        return arbolDeDesicionAux(m, 0);       
    }
    
    public Nodo arbolDeDesicionAux(String[][] m, int cont){
        if(cont > 7) return null;
        Nodo f = new Nodo(m);
        if((f.d).length<= 150 || (f.i).length<= 150) return f;
        cont = cont+1;
        f.der = arbolDeDesicionAux(f.d, cont);
        f.izq = arbolDeDesicionAux(f.i, cont);
        return f;
    }
    
    public int testing(String[][] m, Nodo n) {
        int cont = 0;
        for (int i = 1; i < m.length; i++) { //filas
            String[] s = new String[m[0].length];
            for (int j = 0; j < m[0].length; j++) { //columnas
                s[j] = m[i][j];
            }
            if (testingAux(s, n)) cont++;
        }
        return cont;
    }
    
    public boolean testingAux(String[] f, Nodo n) {
        if (n.der == null && n.izq == null) {
            return Double.parseDouble(f[f.length -1]) == n.exito;
        }
        try {
            double c = Double.parseDouble(f[n.mejorC]);
            double v = Double.parseDouble(n.mejorV);
            if (c >= v) {
                return testingAux(f, n.der);
            } else {
                return testingAux(f, n.izq);
            }
        } catch(NumberFormatException e ) {
            String v = f[n.mejorC];
            if(v.equals(n.mejorV)) return testingAux(f, n.der);
            
        }
        return testingAux(f, n.izq);
    }
    
    public double[] details(String[][] m, Nodo n) {
        double truePos = 0;
        double trueNeg = 0;
        double falsePos = 0;
        double falseNeg = 0;
        double totPos = 0;
        double totNeg = 0;
        double[] res = new double[3];
        for (int i = 1; i < m.length; i++) { //filas
            String[] s = new String[m[0].length];
            for (int j = 0; j < m[0].length; j++) { //columnas
                s[j] = m[i][j];
            }
            if (Double.parseDouble(s[s.length-1]) == 1) {
                if (testingAux(s, n)) truePos++;
                totPos++;
            } else {
                if (testingAux(s, n)) trueNeg++;
                totNeg++;
            }
        }
        falsePos = totPos - truePos;
        falseNeg = totNeg - trueNeg;
        res[0] = (truePos + trueNeg) / (m.length-1); //Exactitud
        res[1] = truePos / (truePos + falsePos);     //Precision
        res[2] = truePos / (falseNeg + truePos);     //Recall (Sensibilidad)
        return res;
    }
    
    public void visualizar(Nodo root) {
        System.out.print("Inserta el siguiente codigo en la pagina: ");
        System.out.println("http://www.webgraphviz.com/");
        visualizarAux(root);
    }

    private void visualizarAux(Nodo n) {  //Complejidad O(n) || con n la cantidad de nodos
        if (n.izq == null){ 
            return;
        }else{
            System.out.println("\"" + n.mejorV + "("+ n.mejorC+ ", "+n.exito+")"+"\"" + " -> " + "\"" + n.izq.mejorV + "("+ n.izq.mejorC+ ", "+n.izq.exito+")" + "\"");
        }
        if (n.der == null){
            return;
        }else{
            System.out.println("\"" + n.mejorV + "("+ n.mejorC+ ", "+n.exito+")"+"\"" + " -> " + "\"" + n.der.mejorV + "("+ n.der.mejorC + ", "+n.der.exito+")" + "\"");
        }
        visualizarAux(n.izq);  //T(n) = T(n/2) + c
        visualizarAux(n.der); //T(n) = T(n/2) + c
    } 
}
