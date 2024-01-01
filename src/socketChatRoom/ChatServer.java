package socketChatRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 5000;
	private List<ClientHandler> clients = new ArrayList<>();
	
	public void startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Server started listening on port: " + PORT);
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
				ClientHandler clientHandler = new ClientHandler(clientSocket, System.currentTimeMillis() + "", this);
				clients.add(clientHandler);
				new Thread(clientHandler).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void broadcastMessage(String id, String message) {
		for(ClientHandler client : clients) {
			if(!(client.getId().equals(id))) {
				client.sendMessage(id + ": " + message);
			}
		}
	}
}
