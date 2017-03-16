import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {
	private final int puerto = 5000;
	private DatagramSocket socket;
	private final String ADDRESS = "223.2.2.2";
	private InetAddress ips;
	private String mensaje;

	public Comunicacion() {
		try {
			socket = new DatagramSocket(puerto);
			ips = InetAddress.getLocalHost();
			System.out.println("mi ip es: " + ips);
		} catch (Exception e) {
		}
	}

	public void run() {

		while (true) {
			System.out.println("entro al run");
			try {
				String mensaje = recibir();
				setChanged();
				notifyObservers(mensaje);
				clearChanged();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void enviar(byte[] data, InetAddress ip, int port) throws IOException {
		DatagramPacket paquete = new DatagramPacket(data, data.length, ip, port);
		socket.send(paquete);
	}

	public String recibir() {
		try {
			byte[] paquete = new byte[1000];
			DatagramPacket packet = new DatagramPacket(paquete, paquete.length);
			socket.receive(packet);
			System.out.println("mensaje recibido");
			mensaje = new String(packet.getData(), 0, packet.getLength());

			return mensaje;

		} catch (Exception e) {
		}
		return null;
	}

	public byte[] serializar(Object mensaje) throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bytes);
		os.writeObject(mensaje);
		os.close();
		return bytes.toByteArray();

	}

	public Object deserializar(byte[] bytes) throws Exception {
		ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes);
		ObjectInputStream is = new ObjectInputStream(byteArray);
		Object aux = is.readObject();
		is.close();
		return aux;

	}

}
