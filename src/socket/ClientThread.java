package socket;

import java.net.Socket;

public class ClientThread extends Thread {
	private Socket socket;
	
	public ClientThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true) {
			try {
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
