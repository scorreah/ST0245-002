         
import java.util.*;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {
 
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca  (String string){
        Stack<Integer> pila = new Stack<>();
        //char[] s = string.toCharArray();
        for (String s: string.split(" ")) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int n = pila.pop();
                int m = pila.pop();
                int res = 0;
                switch (s) {
                    case "+":
                        res = m+n; //m+n
                        break;
                    
                    case "-":
                        res = m-n;  //m-n
                        break;
                        
                    case "*":
                        res = m*n;  //m*n
                        break;
                        
                    case "/":
                        res = m/n;  //m/n
                        break;
                }
                pila.push(res);
            } else {
                pila.push(Integer.parseInt(s));
            }
        }
        return pila.pop();
    }

    /**
    * @param neveras es una estructura de datos para representar el almacen con las neveras
    * @param solicitudes es una estructura de datos para representar las solicitudes
    */
    public static void asignarSolicitudes  (Stack<Nevera> neveras, Queue<Solicitud> solicitudes){
        while (solicitudes.peek() != null) {
            Solicitud s = solicitudes.poll();
            int k = s.cantidad;
            s.info();
            System.out.print(" [");
            for (int i = 0; i < k; i++) {
                if(neveras.size()==0){
                    System.out.print(" No hay mas neveras disponibles");
                    break;
                }
                neveras.pop().info();
            }
            System.out.println("])");
        }
    }
    
    public static void main(String args[]){
        Stack<Nevera> nev = new Stack<Nevera>();
        nev.push(new Nevera(1, "Haceb"));
        nev.push(new Nevera(2, "lg"));
        nev.push(new Nevera(3, "ibm"));
        nev.push(new Nevera(4, "Haceb"));
        nev.push(new Nevera(5, "lg"));
        nev.push(new Nevera(6, "ibm"));
        nev.push(new Nevera(7, "Haceb"));
        nev.push(new Nevera(8, "lg"));
        nev.push(new Nevera(9, "ibm"));
        nev.push(new Nevera(8, "lg"));
        nev.push(new Nevera(9, "ibm"));
        Queue<Solicitud> solicitudes = new LinkedList<Solicitud>();
        Solicitud S1 = new Solicitud("exito", 1);
        solicitudes.add(S1);
        Solicitud S2 = new Solicitud("olimpica", 4);
        solicitudes.add(S2);
        solicitudes.add(new Solicitud("la14", 2));
        solicitudes.add(new Solicitud("eafit", 10));
        asignarSolicitudes(nev, solicitudes);    
        
    }
    
    // /**
    // * @param stack es una pila ya implementada que se crea en el test
    // * Este método se encarga de poner la pila stack en orden inverso
    // * Nota: recuerde que la funcion pop() no solo expulsa la última 
    // * posición de una pila si no que tambien devuelve su valor.
    // * @return una pila que haga el inverso de stack
    // */
    // public static Stack<Integer> inversa (Stack<Integer> stack){
        // //...
    // }
    
    
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola (Queue<String> queue){
        //...
    }
    
   
}

class Nevera {
    int id;
    String marca;
    public Nevera (int id, String marca){
        this.id = id;
        this.marca = marca;
    }
    
    public void info() { 
        System.out.print("("+ this.id + ",'"+ this.marca + "')");
    }
}

class Solicitud {
    String cliente;
    int cantidad;
    public Solicitud (String cliente, int cantidad) {
        this.cliente = cliente;
        this.cantidad = cantidad;
    }
    
    public void info() {
        System.out.print("[(' " + this.cliente + "')");
    }
}
