
import java.util.ArrayList;
public class Point2
{
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node (int data) {
            this.data=data;
        }
    }

    public Node root;

    public void insert (int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        insertarAux(root, data, null);
    }

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
    } 

    public void buildingTree (int [] preOrder) {
        for(int i = 0; i< preOrder.length; i++){
            insert(preOrder[i]);
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void posOrder(Node node) {
        if (node == null) {
            return;
        } else {
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.data);          
        }
    }

    public void exercise21 (int [] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(root);
        System.out.println();
    }

    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}
