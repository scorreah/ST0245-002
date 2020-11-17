import java.util.TreeSet;
import javafx.util.Pair;
public class CalculoNumerico{
    public CalculoNumerico(){
    }
    public float calcularElGiniPonderado(String[][] laMatrizDelNodoDeLaIzquierda, String[][] laMatrizDelNodoDeLaDerecha){ //Gini del parametro completo
        float elGiniDeLaMatrizDeLaIzquierda = sacarGini(laMatrizDelNodoDeLaIzquierda);
        float elGiniDeLaMatrizDeLaDerecha = sacarGini(laMatrizDelNodoDeLaDerecha);
        float tamIzq = (float)laMatrizDelNodoDeLaIzquierda.length;
        float tamDer = (float)laMatrizDelNodoDeLaDerecha.length;
        float elGiniPonderado = ((elGiniDeLaMatrizDeLaIzquierda*tamIzq) + 
                (elGiniDeLaMatrizDeLaDerecha*tamDer)) /  (tamIzq + tamDer);
        return elGiniPonderado;
    }
    public float sacarGini(String[][] matrizNodo) {
        float estudiantesExito = 0;
        float estudiantesFracaso = 0;
        float estudiantesTotales = 0;
        for (int fila = 0; fila < matrizNodo.length; fila++){
            if (matrizNodo[fila][matrizNodo[0].length-1].equals("1"))
                estudiantesExito++; //cuantos estudiantes tienen el valor
            estudiantesTotales++;
        }
        estudiantesFracaso = estudiantesTotales - estudiantesExito;
        float gini  = 1 - (estudiantesExito/estudiantesTotales)*(estudiantesExito/estudiantesTotales) 
            - (estudiantesFracaso/estudiantesTotales)*(estudiantesFracaso/estudiantesTotales);
        return gini;
    }
    public int promedioNumerico(String[][] m, int columna) {
        int prom = 0;
        int suma = 0;
        int total = 0;
        for (int fila = 1; fila < m.length; fila++) {
            suma += Integer.parseInt(m[fila][columna]);
            total++;
        }
        prom = suma / total;
        return prom;
    }
    // IG = 1 - (p0)^2 - (p1)^2. P0 = exito/total P1 = NoExito/total
    public float laImpurezaDeLosDatosDeUnaMatriz(String[][] m){
        float losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][m[0].length-1].equals("1"))
                losQueTienenExito++;
        float tamaño = (float)m.length;
        float losQueNoTienenExito = tamaño - losQueTienenExito;
        float proporcionDeLosQueTienenExito = losQueTienenExito/tamaño-1.0f;
        float proporcionDeLosQueNoTieneExito = losQueNoTienenExito/tamaño-1.0f;
        float impureza = 1 - proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito - proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito;
        return impureza;         
    }
    public float sacarGini(String[][] m, int columna, double valor) {
        float estudiantesExito = 0;
        float estudiantesFracaso = 0;
        float estudiantesTotales = 0;
        for (int fila = 1; fila < m.length; fila++)
            if (Double.parseDouble(m[fila][columna])>=valor) {// por ejemplo, valor es 3, 10 SMLVM, Masculino
                if (m[fila][m[0].length-1].equals("1"))
                    estudiantesExito++; //cuantos estudiantes tienen el valor
                estudiantesTotales++;
            }
        estudiantesFracaso = estudiantesTotales - estudiantesExito;
        float gini  = 1.0f - (((estudiantesExito/estudiantesTotales)*(estudiantesExito/estudiantesTotales)) 
                + ((estudiantesFracaso/estudiantesTotales)*(estudiantesFracaso/estudiantesTotales)));
        return gini;
    }
    // IP = (Iizq*cuantosHayALaIzquierda + Ider*cuantosHayALaDerecha) / El numero total de datos
    public  float calcularLaImpurezaPonderada(String[][] m, int posVariable, double prom ){ //matriz m, columna, valor 
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 1; fila < m.length; fila++)
            if (Double.parseDouble(m[fila][posVariable])>=prom)// por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++; //cuantos estudiantes tienen el valor
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;  //
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor+1][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 1;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length)
        {
            if(Double.parseDouble(m[fila][posVariable])>=prom)
            {
                if(filaN1==0){
                    for (int i = 0; i < m[0].length ; i++) {
                        matrizLaVariableEsIgualAlValor[filaN1][i] = m[0][i];
                    }
                    filaN1++;
                }
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableEsIgualAlValor[filaN1][i] = m[fila][i];
                }
                fila++;filaN1++;
            }else
            {
                 if(filaN2==0){
                    for (int i = 0; i < m[0].length ; i++) {
                        matrizLaVariableNOEsIgualAlValor[filaN2][i] = m[0][i];
                    }
                    filaN2++;
                }
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableNOEsIgualAlValor[filaN2][i] = m[fila][i];
                }
                fila++;filaN2++;
            }
        }
        // ...
        float impurezaPonderada = calcularElGiniPonderado(matrizLaVariableEsIgualAlValor, matrizLaVariableNOEsIgualAlValor);
        return impurezaPonderada;
    }
   
}
