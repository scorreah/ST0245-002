
/**
 * Write a description of class LinkedList here.
 * 
 * @author Mauricio Toro, David Gomez, Simon Correa 
 * @version  2020/09/10
 */

import java.lang.IndexOutOfBoundsException;
public class LinkedListMauricio <T>
{
    private Node<T> first;
    private int size; 

    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node<T> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public T get(int index) throws IndexOutOfBoundsException {
        Node<T> temp = getNode(index);
        return temp.data; 
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(T data, int index) { // Y si la lista está vacía? Y si voy a insertar en la posición 0?
        Node<T> nuevoNodo = new Node<T>(data);
        
        if(index == 0){
            Node<T> pas = first;
            first = nuevoNodo;
            first.next = pas;
            size++;
        }else if(index<=size && index>0){
            Node<T> temp = first;
            for (int i = 0; i <= index - 1; i++){
                if(i==index-1){
                    nuevoNodo.next = temp.next;
                    temp.next = nuevoNodo;
                    size++;
                    return;
                }
                temp = temp.next;            
            }
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    // Borra el dato en la posición index
    public void remove(int index) throws IndexOutOfBoundsException {
        if (size <= 0)
            throw new IndexOutOfBoundsException();
        Node<T> temp = first;
        if (index == 0) {						//que pasa si solo le queda un elemento
            first = first.next;
            size--;
            return;
        } else if (index > 0 && index < size) {

            for (int i = 0; i <= index - 1; i++) {  
                if (i == index-1) {
                    temp.next = temp.next.next;
                    size--;
                    return;
                }
                temp = temp.next;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // Verifica si está un dato en la lista
    public boolean contains(T data) {
        //Iterando hasta que lo encontremos
        Node<T> unNodo = first;

        while (unNodo != null){ //OJO con Null pointer exception           
            if (unNodo.data == data)
                return true;
            unNodo = unNodo.next;
        }

        return false;
        // OJO con Missing return statement

    }
    
    public int search(T data) {
        //Iterando hasta que lo encontremos
        Node<T> unNodo = first;
        int index = 0;

        while (unNodo != null){         
            if (unNodo.data == data)
                return index;
            unNodo = unNodo.next;
            index++;
        }

        return -1;
        // OJO con Missing return statement

    }
}
