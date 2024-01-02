package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerMain {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(8000);
			
			byte[] receiveData = new byte[1024];
			
			int count = 0;
			
			while(true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				
				String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
				
				if(receiveMessage.trim().length() > 0) {
					System.out.println("Receive message: " + receiveMessage);
				}
				
				count++;
				
				if(count == 10000000) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}
}
