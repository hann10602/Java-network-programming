package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockerMain {
	public static void main(String[] args) {
		int port = 99;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				
				ClientThread ct = new ClientThread(clientSocket);
				
				ct.start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
