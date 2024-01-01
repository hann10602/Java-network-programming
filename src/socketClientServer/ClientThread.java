package socketClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {
	private Socket socket;
	
	public ClientThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							this.socket.getInputStream()
					)
			);
			
			PrintWriter pw = new PrintWriter(this.socket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			String message;
			
			while(true) {
				message = br.readLine();
				System.out.println("Client: " + message);
				
				System.out.println("Server: ");
				message = sc.nextLine();
				pw.println(message);
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
