import java.util.TreeSet;
import javafx.util.Pair;
public class Calculo{
    public Calculo(){
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
        for (int fila = 1; fila < matrizNodo.length; fila++){
            if (matrizNodo[fila][matrizNodo[0].length-1].equals("1"))
                estudiantesExito++; //cuantos estudiantes tienen el valor
            estudiantesTotales++;
        }
        estudiantesFracaso = estudiantesTotales - estudiantesExito;
        float gini  = 1 - (estudiantesExito/estudiantesTotales)*(estudiantesExito/estudiantesTotales) 
            - (estudiantesFracaso/estudiantesTotales)*(estudiantesFracaso/estudiantesTotales);
        return gini;
    }

    public TreeSet<String> sacarLosValoresDiferentesSinRepetirDeUnaVariable(String[][] m, int posVariable){  //almacenar posibles respuestas de cada columna en un arbol
        TreeSet<String> respuesta = new TreeSet();
        for (int fila = 1; fila < m.length; fila++){ //fila 
            if(m[fila][posVariable]==null||m[fila][posVariable].equals("")){
                continue;
            }
            respuesta.add(m[fila][posVariable]);
        }
        return respuesta;  
    }

    public double promedioNumerico(String[][] m, int columna) {
        double prom = 0;
        double suma = 0;
        double total = 0;
        for (int fila = 1; fila < m.length; fila++) {
            suma += Double.parseDouble(m[fila][columna]);
            total++;
        }
        prom = suma / total;
        return prom;
    }

    public Pair<Integer,String> encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(String[][] m){
        float laImpurezaMenorDentreTodoElmundo = 1;
        String elMejorValorDentreTodoElMundo = "";
        int laPosDeLaVariableDondeEstaElMejorValor = -1;
        TreeSet<String> valores = new TreeSet<>();
        float impurezaPonderadaDeEstaColumnaConEsteValor;
        float giniValor = 1.0f;
        float giniMenor = 1.0f;
        for (int columna = 0; columna < m[0].length - 1; columna++) { //Recorre todas las columnas excepto la del exito
            try { //En caso de ser numerico
                Double.parseDouble(m[1][columna]);
                double promedio = promedioNumerico(m, columna); //Promedio de valores de la columna
                CalculoNumerico nodito = new CalculoNumerico();
                impurezaPonderadaDeEstaColumnaConEsteValor = nodito.calcularLaImpurezaPonderada(m, columna, promedio);
                if (impurezaPonderadaDeEstaColumnaConEsteValor < laImpurezaMenorDentreTodoElmundo){
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor;  //0
                    laPosDeLaVariableDondeEstaElMejorValor = columna;
                    giniValor = nodito.sacarGini(m, columna, promedio);
                    giniMenor = 1.0f;
                    giniMenor = giniValor;
                    elMejorValorDentreTodoElMundo = String.valueOf(Math.round(promedio * 100.0) / 100.0);
                }

            } catch(NumberFormatException e ) {
                valores = sacarLosValoresDiferentesSinRepetirDeUnaVariable(m, columna); //Saca las posibles soluciones de la columna
                if(valores.size()==0){
                    continue;
                }else{
                impurezaPonderadaDeEstaColumnaConEsteValor = calcularLaImpurezaPonderada(m, columna, valores.first());
                if (impurezaPonderadaDeEstaColumnaConEsteValor < laImpurezaMenorDentreTodoElmundo){
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor;  //0
                    laPosDeLaVariableDondeEstaElMejorValor = columna;                              //sexo
                    giniMenor = 1.0f;
                    elMejorValorDentreTodoElMundo = "";
                    for (String unValor : valores) {
                        giniValor = sacarGini(m, columna, unValor);
                        if (giniValor < giniMenor) {
                            giniMenor = giniValor;
                            elMejorValorDentreTodoElMundo = unValor;                                        //mujer
                        }
                    }
                }  
            }
            }

        }   
        Pair<Integer,String> respuesta = new Pair(laPosDeLaVariableDondeEstaElMejorValor, elMejorValorDentreTodoElMundo);  // (posSexo, mujer)
        return respuesta;
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
    
    public double PorcentajeDeExito(String[][] m){
        double losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][m[0].length-1].equals("1"))
                losQueTienenExito++;
        double tamaño = m.length;
        double por = (losQueTienenExito*100)/tamaño;
        if(por>=51)return 1;
        return 0;
    }
      

    public float sacarGini(String[][] m, int columna, String valor) {
        float estudiantesExito = 0;
        float estudiantesFracaso = 0;
        float estudiantesTotales = 0;
        for (int fila = 0; fila < m.length; fila++){
            if(m[fila][columna]==null)continue;
            if (m[fila][columna].equalsIgnoreCase(valor)) {// por ejemplo, valor es 3, 10 SMLVM, Masculino
                if (m[fila][m[0].length-1].equals("1"))
                    estudiantesExito++; //cuantos estudiantes tienen el valor
                estudiantesTotales++;
            }
        }
        estudiantesFracaso = estudiantesTotales - estudiantesExito;
        float gini  = 1.0f - (((estudiantesExito/estudiantesTotales)*(estudiantesExito/estudiantesTotales)) 
                + ((estudiantesFracaso/estudiantesTotales)*(estudiantesFracaso/estudiantesTotales)));
        return gini;
    }
    // IP = (Iizq*cuantosHayALaIzquierda + Ider*cuantosHayALaDerecha) / El numero total de datos
    public  float calcularLaImpurezaPonderada(String[][] m, int posVariable, String valor){ //matriz m, columna, valor 
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 0; fila < m.length; fila++){
            if(m[fila][posVariable]==null)continue;
            if (m[fila][posVariable].equals(valor))// por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++; //cuantos estudiantes tienen el valor
            }
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;  //
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor+1][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length)
        {
            if(m[fila][posVariable] == null){
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableNOEsIgualAlValor[filaN2][i] = m[fila][i];
                }
                fila++;filaN2++;
            }
            if(m[fila][posVariable].equals(valor))
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

    public  Pair<String[][],String[][]> dividirUnaMatrizEnDosMatrices(String[][] m, int posVariable, String valor){
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][posVariable].equals(valor)) // por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++;
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length)
        {
            if(m[fila][posVariable].equals(valor))
            {
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableEsIgualAlValor[filaN1][i] = m[fila][i];
                }
                fila++;filaN1++;
            }else
            {
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableNOEsIgualAlValor[filaN2][i] = m[fila][i];
                }
                fila++;filaN2++;
            }
        }
        // ...
        Pair<String[][],String[][]> parejaDeMatrices = new Pair(matrizLaVariableEsIgualAlValor,matrizLaVariableNOEsIgualAlValor);
        return parejaDeMatrices;
    }

    public  float calcularLaImpurezaPonderada(String[][] m, int posVariable, int prom ){ //matriz m, columna, valor 
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 1; fila < m.length; fila++)
            if (Integer.parseInt(m[fila][posVariable])>=prom)// por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++; //cuantos estudiantes tienen el valor
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;  //
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length)
        {
            if(Integer.parseInt(m[fila][posVariable])>=prom)
            {
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableEsIgualAlValor[filaN1][i] = m[fila][i];
                }
                fila++;filaN1++;
            }else
            {
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
    //---------------------------

    public  Pair<String[][],String[][]> dividirUnaMatrizEnDosMatricesSin(String[][] m, int posVariable, String valor){
        try{
            double value = Double.parseDouble(valor);
            return dividirUnaMatrizEnDosMatricesSin(m, posVariable, value);
        }catch(NumberFormatException e ){
            int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        }
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 0; fila < m.length; fila++)
            if (m[fila][posVariable].equals(valor)) // por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++;
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor+1][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 1;
        int filaN1 = 0;
        int filaN2=0;
        int v = 0;
        while(fila<m.length)
        {
            if(m[fila][posVariable].equals(valor))
            {
                if(filaN1==0){
                    for (int i = 0; i < m[0].length ; i++) {
                        matrizLaVariableEsIgualAlValor[filaN1][i] = m[0][i];
                        v++;
                    }
                    filaN1++;
                    v=0;
                }
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableEsIgualAlValor[filaN1][i] = m[fila][i];
                    v++;
                }
                fila++;filaN1++;
                v=0;
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
        Pair<String[][],String[][]> parejaDeMatrices = new Pair(matrizLaVariableEsIgualAlValor,matrizLaVariableNOEsIgualAlValor);
        return parejaDeMatrices;
    }

    public  Pair<String[][],String[][]> dividirUnaMatrizEnDosMatricesSin(String[][] m, int posVariable,double valor){
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
        for (int fila = 1; fila < m.length; fila++)
            if (Double.parseDouble(m[fila][posVariable]) >= valor) // por ejemplo, valor es 3, 10 SMLVM, Masculino
                enCuantosEstudiantesLaVariableEsIgualAlValor++;
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;
        String[][] matrizLaVariableEsIgualAlValor = new String[enCuantosEstudiantesLaVariableEsIgualAlValor+1][m[0].length];
        String[][] matrizLaVariableNOEsIgualAlValor = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 1;
        int filaN1 = 0;
        int filaN2=0;
        int v = 0;
        while(fila<m.length)
        {
            if(Double.parseDouble(m[fila][posVariable]) >= valor)
            {
                if(filaN1==0){
                    for (int i = 0; i < m[0].length ; i++) {
                        matrizLaVariableEsIgualAlValor[filaN1][i] = m[0][i];
                        v++;
                    }
                    filaN1++;
                    v=0;
                }
                for (int i = 0; i < m[0].length ; i++) {
                    matrizLaVariableEsIgualAlValor[filaN1][i] = m[fila][i];
                    v++;
                }
                fila++;filaN1++;
                v=0;
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
        Pair<String[][],String[][]> parejaDeMatrices = new Pair(matrizLaVariableEsIgualAlValor,matrizLaVariableNOEsIgualAlValor);
        return parejaDeMatrices;
    }

}