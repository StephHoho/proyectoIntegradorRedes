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

	public Logica(PApplet app) {
		this.app = app;
		this.com = new Comunicacion();
		com.addObserver(this);
		Thread thread = new Thread(com);
		thread.start();
		productos= new ArrayList<Producto>();	
	}

	public void pintar() {

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
