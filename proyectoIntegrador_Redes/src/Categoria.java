import java.io.Serializable;

import processing.core.PApplet;
import processing.core.PImage;

public class Categoria extends Producto implements Serializable {
	private String nombre;
	private String descripcion;
	private PImage imagen;
	
	public Categoria(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

}  
