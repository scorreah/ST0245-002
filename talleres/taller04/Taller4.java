/**
 *La clase Taller4 dos tiene como objetivo dar solución al taller 4
 *
 *@autor Mauricio Toro, Camilo Paez, David Gomez, Simón Correa
 *@version 1
 */
public class Taller4 {

    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arrayMax(int[] array, int n) {
        return arrayMaxAux(array, n, 0);
    }

    private static int arrayMaxAux(int[] array, int n, int target){
        if(n==0){
            return target; //c_1= 3
        }   else    {
            target = Math.max(target, array[n]);//c_2 = 6
            return arrayMaxAux(array, n-1, target); //T(n) = c_2 + T(n-1)
        }
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        return groupSumAux(start, nums, target);
    }

    public static boolean groupSumAux(int start, int[] nums, int target) {
        if (start == nums.length){ //
            return target==0;//c_2 = 4
        }else{
            return groupSumAux(start+1, nums, target-nums[start]) || groupSumAux(start+1, nums, target); //c_3 = 5 o 7
        } //T(n) = c_3 + T(n-1) + T(n-1)
    }

    /*
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */

    public static long fibonacci(int n) {
        //... 
        //0+1+1+2+3+5+8+13+21+34+...+ n =  n0 = 0,n1 = 1,n2 = 2,n3 = 4,n4 = 7,n5 = 15,n6 = 23,n7 =36
        // s_k = s_k-1 + s_k-2
        // s_n = 
        if (n==1 || n==2)
            return 1;   //c_1 = 5
        else if (n==0)
            return 0;   //c_2 = 3
        else 
            return fibonacci(n-1) + fibonacci(n-2);  //T(n) = T(n-1) + T(n-2)

    }

    public static void main(String args[]) {
        for (int n = 42; n <= 62; n++) {
            long ti = System.currentTimeMillis();
            
            //int[] arreglo = new int[] {12,324,43,2,3,43,2,3,43,12,324,43,2,3,43,2,3,43,8,12};
            
            //fibonacci(n);
            arrayMax(new int[n], n-1);

            long tf = System.currentTimeMillis();

            System.out.println(tf - ti);

        }
    }

}