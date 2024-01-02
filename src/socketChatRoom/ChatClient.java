package socketChatRoom;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String url = "localhost";
	private static final int PORT = 5000;
	
	public void startClient() {
		try {
			Socket socket = new Socket(url, PORT);
			System.out.println("Connected to server");
			
			ClientListener client = new ClientListener(socket);
			new Thread(client).start();
			
			OutputStream output = socket.getOutputStream();
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				String message = sc.nextLine();
				output.write(message.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
