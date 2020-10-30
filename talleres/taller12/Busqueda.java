
/**
 * Write a description of class m here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.LinkedList;
public class Busqueda{
    public static boolean hayCaminoDFS(Graph g, int o, int d){
        boolean[] lista = new boolean[g.size()];
        return hayCaminoDFS(g, o, d, lista);
    }
    public static boolean hayCaminoDFS(Graph g , int o, int d, boolean[] f){
        f[o]=true;
        boolean control = false;
        if(o == d)return true;
        for(Integer s: g.getSuccessors(o)){
            if(!f[s]){
                if(hayCaminoDFS(g, s, d, f))return true;
            }
        }    
        return control;
    }
    public static boolean hayCaminoBFS(
    Graph g, int o, int d) {
        if(o==d)return true;
        LinkedList<Integer> v = new LinkedList<>();
        v.add(o);
        boolean[] lista = new boolean[g.size()];
        return hayCaminoBFS(g, d, v, lista);        
    }
    
    public static boolean hayCaminoBFS(
    Graph g, int d, LinkedList<Integer> v, boolean[] f) { 
        for (Integer nodo: v) {
            for(Integer s : g.getSuccessors(nodo)){
                if(s==d)return true;
                if(!f[s]){
                    f[s]= true;
                    v.add(s);
                }
            } 
            v.poll();
        }
        if(v.size()==0)return false;
        return hayCaminoBFS(g, d, v, f);
    }
}