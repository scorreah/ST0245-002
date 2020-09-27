
/**
 * Write a description of class Lugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vertice extends Lugar
{
    private long id;
    private double y;
    private double x;
    private String name;
    
    public Vertice (long id, double y, double x, String name) {
        this.id = id;
        this.y = y;
        this.x = x;
        this.name = name;
    }
    
    public Vertice (long id, double y, double x) {
        this(id, y, x, "");
    }
    
    public long getId() {
        return this.id;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public String getName() {
        return this.name;
    }
}
