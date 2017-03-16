import java.io.Serializable;
import processing.core.PApplet;

public class Producto implements Serializable {
	private String nombreCate;
	private String nombreProd;
	private float precioUnidad;
	
	public Producto(String nombreCate, String nombreProd, float precioUnidad) {
		this.nombreCate = nombreCate;
		this.nombreProd = nombreProd;
		this.precioUnidad = precioUnidad;
	}

}
