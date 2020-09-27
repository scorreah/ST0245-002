
/**
 * Write a description of class Lugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arco extends Lugar
{
    private long id;
    private long id2;
    private double distancia;
    private String name;
    
    public Arco (long id, long id2, double distancia, String name) {
        this.id = id;
        this.id2 = id2;
        this.distancia = distancia;
        this.name = name;
    }
    
    public Arco (long id, long id2, double distancia) {
        this(id, id2, distancia, "desconocido");
    }
    
    public long getId() {
        return this.id;
    }
    
    public long getId2() {
        return this.id2;
    }
    
    public double getDistancia() {
        return this.distancia;
    }
    
    public String getName() {
        return this.name;
    }
}
