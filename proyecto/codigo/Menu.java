
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Menu
{
    public Menu () {}
    
    public static void main() throws Exception{
        System.gc();
        Lectura un = new Lectura("4_train_balanced_135000.csv");
        //Scanner scan = new Scanner(System.in);

        Arbol ensayo = new Arbol();
        long startTime = System.currentTimeMillis();
        //String s = scan.nextLine();
        Nodo nuevo = ensayo.arbolDeDesicion(un.Matriz);
        long finalTime = System.currentTimeMillis();
        //s = scan.nextLine();
        //System.out.println("Listo");
        System.out.println("Tiempo tardado: " + (finalTime - startTime));
        //ensayo.visualizar(nuevo);
        
         Lectura testing = new Lectura("4_test_balanced_45000.csv"); //4_test_balanced_45000.csv
        double[] detalles = ensayo.details(testing.Matriz, nuevo);
        System.out.println("Exactitud: "+ ((ensayo.testing(testing.Matriz, nuevo) * 100) / testing.Matriz.length));
        System.out.println("Exactitud: "+ detalles[0]);
        System.out.println("Precision: "+ detalles[1]);
        System.out.println("Recall(Sensibilidad): "+ detalles[2]);
        
        
    }
}
