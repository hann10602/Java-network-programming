package socketLocal;

public class SocketMain {
	public static void main(String[] args) {
		SocketObject o = new SocketObject("localhost");
		
		o.checkPort();
	}
}
