/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y calcular su distancia.
 * 
 * @author Mauricio Toro, Andres Paez, Daniel Mesa 
 * @version 2
 */
//Nota: Hacen falta algunas partes de las lineas de codigo, estas estan indicadas con una linea, ¡debes completarlas!
public class Punto {

    private double x, y;

    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Punto(double x, double y) {
      this.x = x;
      this.y = y;			
    }

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
			return this.x;
    }

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y() {
			return this.y;
    }

    /**
     * Método para obtener el radio polar, en este caso se puede obtener por medio del teorema de pitágoras.
     * 
     *
     * @return radio polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */
    
    public double radioPolar() {
      double radio = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
		  return radio;
    }


    /**
     * Método para obtener el ángulo polar, en este caso se puede obtener por medio de la tangente inversa.
     * 
     *
     * @return angulo polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */
    public double anguloPolar() {
      
      double angulo = 0;

        if ((x > 0) && (y > 0)) { //1er cuadrante
            angulo = Math.atan(y/x);

        } else if (((x < 0)&&(y > 0)) || (x < 0)&&(y < 0)){ //2ndo y 3er cuadrante
            angulo = Math.atan(y/x)+Math.PI;

        } else if((this.x > 0)&&(this.y< 0)){ //4rto cuadrante  
            angulo = Math.atan(y/x) + (2*Math.PI);
        }
        return angulo;

    }

    /**
     * Método para obtener la distacia euclidiana. La distacia
     * euclidiana o euclídea es la distancia "ordinaria" (que se mediría con una regla) entre 
     * dos puntos de un espacio euclídeo, la cual se deduce a partir del teorema de Pitágoras.
     * En otras palabras es halla el radio polar a la diferencia entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> Ver más <a/>
     */
  
    public double distanciaEuclidiana(Punto otro) {
      
      double dx = this.x - otro.x;
      double dy = this.y - otro.y;
      double dist =  Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
      return dist;
    }
}
