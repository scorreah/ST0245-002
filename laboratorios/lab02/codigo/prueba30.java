/**

 * Write a description of class prueba30 here.

 *

 * @author (your name)

 * @version (a version number or a date)

 */

public class prueba30

{

    public static void main(String[] args){

        int n = 10000000;

        for(int i = 0; i<20; i++){

            int[] uno = new int[n];

            int nums = n;

            for(int j = 0; j<uno.length; j++){

                uno[j]=nums;

                nums--;

            }

            long ti = System.currentTimeMillis();

            merge1 s = new merge1();

            s.sort(uno,0, (uno.length-1));

            long tf = System.currentTimeMillis();

            n = n+1000000;

            System.out.println(tf-ti);

        }

    }

}