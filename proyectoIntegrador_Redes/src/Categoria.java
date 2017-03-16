import java.io.Serializable;

public class Categoria implements Serializable {
	private String nombre;
	private String descripcion;
	private String imagen;
	
	public Categoria(String nombre, String descripion, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
}  
