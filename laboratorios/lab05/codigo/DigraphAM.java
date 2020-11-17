
import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
import java.util.ArrayList;
public class DigraphAM extends Graph
{
    //matriz que contiene los arcos entre los vertics
    private int [][] grafoAM;
    
    /**
     * Constructor de DiagraphAM
     */
    public DigraphAM(int vertices) {
        super(vertices);
        this.size = vertices;
        grafoAM = new int[vertices+1][vertices+1];
    }

    /**
     * Metodo que agrega un arco entre dos vertices
     */
    public void addArc(int source, int destination, int weight)
    {
        grafoAM[source][destination] = weight;
    }

    /**
     * Metodo que retorna el un ArrayList con el numero de todos los vertices que tengan una conexion
     * con uno
     */
    public ArrayList<Integer> getSuccessors(int vertice)
    {
        ArrayList<Integer> respuesta = new ArrayList<>();
        for (int i = 0; i < size; i++)
            if (grafoAM[vertice][i] != 0)
                respuesta.add(i);
        return respuesta;
    }

    /**
     * Metodo que retorna el valor o peso de un arco entre dos vertices
     */
    public int getWeight(int source, int destination)
    {
        return grafoAM[source][destination];
    }
}