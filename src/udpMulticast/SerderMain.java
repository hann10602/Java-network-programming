package udpMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SerderMain {
	public static void main(String[] args) {
		try {
			InetAddress group = InetAddress.getByName("230.0.0.1");
			MulticastSocket socket = new MulticastSocket();
			
			String message = "Hello from the sender";
			
			byte[] sendData = message.getBytes();
			
			while(true) {
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, 8000);
				socket.send(sendPacket);
				
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
