package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress serverAddress = InetAddress.getByName("localhost");
			int serverPort = 8000;
			
			int i = 0;
			
			while(i < 100) {
				String message = "Hello, UDP server " + i;
				byte[] sendData = message.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
				socket.send(sendPacket);
				i++;
			}
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
