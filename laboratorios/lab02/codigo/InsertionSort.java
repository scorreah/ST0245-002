/**
 * Write a description of class InsertionSort here.
 * 
 * @author David Gomez, Simon Correa
 * @version 2020/08/25
 */
public class InsertionSort
{
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

            for(cont2 = cont1-1;cont2>=0 && array[cont2] > aux; cont2--) {  //c_4 = 2 c_5= 5    T(n) = (c_4 + c_5*(n-1))*n
                array[cont2+1] = array[cont2];                                          
                array[cont2] = aux;                                             //c_6 = 6?    T(n) = c_6(n-1)n

            }
        }
        return array;                   //c_7       T(n)= = c_1 + c_2*n + c_3*n + (c_4 + c_5*(n-1))*n + c_6(n-1)(n) + c_7
    } 
}