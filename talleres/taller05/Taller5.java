
/**
 * La clase Taller5 tiene la intención de resolver el taller número 5.
 *
 * @author Mauricio Toro, Andres Paez, David Gomez, Simon Correa
 * @version 1
 */

public class Taller5 {  

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma (int[]array){
        //...
        int suma = 0;                                   //c_1 = 1
        for (int i = 0; i < array.length; i++) {        //c_2 = 2       T(n) = c_2 + c_3*n
            suma+= array[i];                            //c_4           T(n) = c_4*n
        }

        return suma;                                    //c_5           T(n) = c_1 + c_2 + (c_3 + c_4)*n + c_5
    }

    /**
     * @param num es el numero el cual se utiliza para ser multiplicado.
     * El método mul tiene la intención de hacer la multiplicación
     * de 1 a n por el numero mul
     * mediante una funcion cíclica (while/for/...)
     * 
     */
    public static void mul (int num){
        //...

    }

    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     * 
     */
    public static int[] insertionSort (int[] array){
        //...
        int aux;
        int cont1;
        int cont2;
        for(cont1=1; cont1 <array.length; cont1++) {       //c_1 c_2    T(n) = c_1 + c_2*n
            aux = array[cont1];                            //c_3*n

            for(cont2 = cont1-1;cont2>=0 && array[cont2] > aux; cont2--) {  //c_4 c_5       T(n) = c_4 + c_5*n
                array[cont2+1] = array[cont2];
                array[cont2] = aux;

            }
        }
        return array;
    } 

    public static void main(String[] args){

        // for (int n = 10000000; n < 100000000; n = n + 10000000){ 

            // long ti = System.currentTimeMillis();

            // suma(new int[n]);

            // long tf = System.currentTimeMillis();

            // System.out.println(tf-ti);      

        // }
        
        for (int n = 10000000; n < 12000000; n = n + 100000){ 

            long ti = System.currentTimeMillis();

            //insertionSort(new int[n]);
            suma(new int[n]);

            long tf = System.currentTimeMillis();

            System.out.println(tf-ti);      

        }
    }

}

