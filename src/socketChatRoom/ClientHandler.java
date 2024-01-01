package socketChatRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
	private Socket socket;
	private ChatServer chatServer;
	private String id;
	private InputStream input;
	private OutputStream output;
	
	public ClientHandler(Socket socket, String id, ChatServer chatServer) {
		super();
		this.socket = socket;
		this.id = id;
		this.chatServer = chatServer;
		try {
			this.input = socket.getInputStream();
			this.output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		try {
			byte[] buffer = new byte[1024];
			int byteRead;
			
			while((byteRead = this.input.read(buffer)) != -1) {
				String message = new String(buffer, 0, byteRead);
				chatServer.broadcastMessage(this.id , message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		try {
			this.output.write(message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
