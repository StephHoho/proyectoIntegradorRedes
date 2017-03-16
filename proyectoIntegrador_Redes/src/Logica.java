import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica implements Observer {
	private PApplet app;
	private Comunicacion com;
	private ArrayList<Producto> productos;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Categoria> categoria;

	public Logica(PApplet app) {
		this.app = app;
		this.com = new Comunicacion();
		com.addObserver(this);
		Thread thread = new Thread(com);
		thread.start();
		productos= new ArrayList<Producto>();
		usuarios= new ArrayList<Usuario>();
		categoria= new ArrayList<Categoria>();
	}

	public void pintar() {
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
