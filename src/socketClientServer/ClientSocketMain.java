package socketClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketMain {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 99);
			

			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							clientSocket.getInputStream()
					)
			);
			
			PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			String message;
			
			while(true) {
				System.out.println("Client: ");
				message = sc.nextLine();
				pw.println(message);
				pw.flush();
				
				message = br.readLine();
				System.out.println("Server: " + message);
			}
		} catch (IOException e) {
			System.out.println("Connect failed");
		}
	}
}
