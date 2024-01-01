package socketLocal;

import java.io.IOException;
import java.net.Socket;

public class SocketObject {
	private String url;
	
	public SocketObject(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void checkPort() {
		int startPort = 1;
		int endPort = 65536;
		
		for(int i = startPort; i < endPort; i++) {
			try {
				Socket socket = new Socket(this.url, i);
				
				System.out.println("Port " + i + " is active");
				
				socket.close();
			} catch (IOException e) {
			}
		}
		
		System.out.println("Scan port complete");
	}
}
