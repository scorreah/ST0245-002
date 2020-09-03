
/**
 * Write a description of class Abeja here.
 * 
 * @author Simón Correa 
 * @version 2020/09/02
 */
public class Abeja
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private double z; //Altura
    

    /**
     * Constructor for objects of class Abeja
     */
    public Abeja()
    {
        // initialise instance variables
        x = 0;
        y = 0;
        z = 0;
    }
    
    /**
     * Constructor for objects of class Abeja
     */
    public Abeja(double x, double y, double z)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 
     * @return     coordinate x
     */
    public double x()
    {
        // put your code here
        return x;
    }
    
    /**
     * 
     * @return     coordinate y
     */
    public double y()
    {
        // put your code here
        return y;
    }
    
    /**
     *
     * @return     coordinate z
     */
    public double z()
    {
        // put your code here
        return z;
    }
    
    /**
     *
     * @param   coordinate x
     */
    public void setX(double x)
    {
        // put your code here
        this.x = x;
    }
    
    /**
     *
     * @param   coordinate y
     */
    public void setY(double y)
    {
        // put your code here
        this.y = y;
    }
    
    /**
     *
     * @param   coordinate z
     */
    public void setZ(double z)
    {
        // put your code here
        this.z = z;
    }
}
