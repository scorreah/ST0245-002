 
import java.util.Arrays;

/**
 * La clase Colmena tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez, Simón Correa, David Gomez
 * @version 1
 */

public class Colmena {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Abeja elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public Colmena() {
        //...
        size = 0;
        elements = new Abeja[DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        //...
        return size; //O(1)
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(Abeja e) {
        //...
        int laUltimaPosicion = size;
        if (size == elements.length) {
            Abeja[] aux = new Abeja[size*2];
            for (int i = 0; i < elements.length; i++) {
                aux[i] = elements[i];
            }
            elements = aux;
        }
        elements[size] = e;
        size++;
    }    
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public Abeja get(int i) throws IndexOutOfBoundsException{
        //...
        if (i<0 || i >= size) {
            throw new IndexOutOfBoundsException("Index : "+ i);
            
        } else {
            return elements[i];
        }
        
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, Abeja e) throws IndexOutOfBoundsException{
        //...
        Abeja temp;
        if (index < 0 || index > size) {                                //c_1  = 4
            throw new IndexOutOfBoundsException("Index : "+ index);     //
        } else if (index == size) {                                     //c_3 = 2
            add(e);
        } else {                                                        //c_4 = 1
            for (int i = index; i < size+1; i++) {                      //c_5 = 1  
                temp = elements[i];
                elements[i] = e;
                e = temp;                                               //T(n) = c_5 + c_6(n+1)         c_6 = 8
            }
            size++;
        }
    } 

    /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index) throws IndexOutOfBoundsException{
        //... falta hacer trim cuando falta la mitad
        Abeja temp;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index : "+ index);
        } else if (index == size-1) {
            elements[index] = null;
            size--;
        } else {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i+1];
            }
            size--;
        }
    }
}
