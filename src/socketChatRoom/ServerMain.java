package socketChatRoom;

public class ServerMain {
	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.startServer();
	}
}
