package socket;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketMain {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 99);
			
			while(true) {
				try {
					Thread.sleep(1000);

					System.out.println("Connect to server");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("Connect failed");
		}
	}
}
