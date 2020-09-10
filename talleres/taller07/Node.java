
/**
 * Write a description of class nd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Un nodo para una lista simplemente enlazada
public class Node<T> {
    public T data;
    public Node<T> next;
    
    public Node(T data) {
        next = null;
        this.data = data;
    }
    
}
