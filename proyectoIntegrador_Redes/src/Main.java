import java.net.InetAddress;
import java.net.UnknownHostException;
import processing.core.PApplet;
import processing.data.XML;

@SuppressWarnings("serial")
public class Main extends PApplet {
	PApplet app;
	Logica log;
	
	XML pasteleria;

	public void settings() {
		size(900, 581);
	}

	public void setup() {
		background(255);
		app = this;
		log = new Logica(this);
		
		pasteleria = loadXML("../data/pasteleria.xml");
		XML nuevoPastel = parseXML("<user></user>");
		nuevoPastel.setString("id", "nombre");
		nuevoPastel.setString("correo", "password");
		XML nuevoProducto = parseXML("<producto></producto>");
		nuevoPastel.setString("nombre", "precio");
		XML categoria = parseXML("<categoria>Pasteles</categoria>");
		XML nuevaCompra = parseXML("<compra></compra>");
		nuevoPastel.setString("user", "id");
		XML nuevosProductos = parseXML("<productos></prodctos>");
		nuevoPastel.setString("cant", "id");

		nuevoProducto.addChild(categoria);
		pasteleria.addChild(nuevoProducto);	
		saveXML(pasteleria, "../data/pasteleria.xml");
		
	}

	private void creandoXML(){
		pasteleria = parseXML("<usuarios></usuarios>");
		XML user = parseXML("<user></user>");
		XML categoria = parseXML("<categoria>Pasteles</categoria>");
		XML categoriaB = parseXML("<categoria>Caramelos</categoria>");

		user.setString("id", "nombre");
		user.setString("correo", "password");
		user.addChild(categoria);
		
		pasteleria.addChild(categoria);
		pasteleria.addChild(categoriaB);

		XML[] hijosCategoria = pasteleria.getChildren();

		for (int i = 0; i < hijosCategoria.length; i++) {
			System.out.println(hijosCategoria[i].toString());
			
			XML[] hijosDeCadaCategoria = hijosCategoria[i].getChildren();
			for (int j = 0; j < hijosDeCadaCategoria.length; j++) {
				System.out.println(hijosDeCadaCategoria[j].toString());	
			}
		}

		
	}




		
		

	public void draw() {
		log.pintar();

	}

	/*public void keyPressed() {
		log.keyPressed();
	}

	public void mouseClicked() {
		log.mouse(mouseX, mouseY);
	}*/

	public static void main(String[] args) {
		PApplet.main("Main");
	}
}
