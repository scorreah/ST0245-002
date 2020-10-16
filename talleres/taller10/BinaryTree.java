/**
 * La clase BinaryTree intenta dar un conocimiento a los
 * estudiantes acerca del manejo de un arbol binario de enteros.  
 * Aquí se espera crear una estrcutura concreta del árbol binario,
 * cabe aclarar que esta estrucutra ya esta implementada.
 * @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
 * @author Mauricio Toro, Andres Paez, David Gomez, Simón Correa
 *
 */

public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        if (root == null) {
            root = new Node(n);
            return;
        }
        insertarAux(root, n, null);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n, Node ant) { //Complejidad O(log(n))
        //...
        if (node == null) {
            if (n >= ant.data) {
                ant.right = new Node(n); 
            } else {
                ant.left = new Node(n);
            }
        }
        else if (n < node.data) insertarAux(node.left , n, node); //T(n) = T(n/2)
        else insertarAux(node.right, n, node);                    //T(n) = T(n/2)        
    }                                                       //T(n) = T(n/2)   O(log(n))   

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n) { //Complejidad O(log(n))
        if (node == null) 
            return false;
        //Si estoy aquí es porque no retornó falso, y si es así
        //es porque el nodo no es null
        if (node.data == n)
            return true; //Pero si es igual, no sería que encontramos el nodo que buscabamos?
        if (n < node.data) {
            //boolean estaALaIzquierda = buscarAux(node.left, n);
            return buscarAux(node.left, n);//Está a la izquierda?
        }
        return buscarAux(node.right, n); // T(n) = T(n/2) + c es O(log n)
    }

    public void visualizar() {
        System.out.print("Inserta el siguiente codigo en la pagina: ");
        System.out.println("http://www.webgraphviz.com/");
        visualizarAux(root);
    }

    private void visualizarAux(Node n) {  //Complejidad O(n) || con n la cantidad de nodos
        if (n.left == null){ 
            return;
        }else{
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.left.data + "\"");
        }
        if (n.right == null){
            return;
        }else{
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.right.data + "\"");
        }
        visualizarAux(n.left);  //T(n) = T(n/2) + c
        visualizarAux(n.right); //T(n) = T(n/2) + c
    }                           //T(n) = 2T(n/2) + c

    // /**
    // * @param n el dato del nodo que se busca borrar.
    // * Metodo auxiliar de buscarAux.
    // * 
    // */
    // public void borrar(int n) {
    // borrarAux(root, n);
    // }

    // /**
    // * @param node es la raíz del arbol
    // * @param n el data del nodo que se busca borrar
    // * nota: metodo recursivo.
    // * borra un dato respetando claro las desigualdades en el árbol
    // */ 
    // private Node borrarAux(Node node, int n) {
    // //Node ant = nodoAnterior(node, n);
    // //Node nuevo = nodo
    // //return elMayorDeLosMenores(node);
    // }

    private int elMayorDeLosMenores(Node node){
        return elMayorYNoEsNull(node.left);
    }

    private int elMayorYNoEsNull(Node node) {
        if (node.left == null && node.right == null)
            return node.data;
        else
            return elMayorYNoEsNull(node.right);
    }

    /*

    Los metodos posteriores son para imprimir el arbol de manera
    que sirven para debuggeo
     */

    /**
     * @param node el nodo desde el cual se imprimirá
     * imprime el arbol desde el nodo node
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            System.out.println(node.data);
            recursivePrintAUX(node.right);            
        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

}