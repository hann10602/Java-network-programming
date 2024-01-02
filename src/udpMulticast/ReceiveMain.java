package udpMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMain {
	public static void main(String[] args) {
		try {
			InetAddress group = InetAddress.getByName("230.0.0.1");
			MulticastSocket socket = new MulticastSocket(8000);
			socket.joinGroup(group);
			
			while(true) {
				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);

				String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

				System.out.println("Message: " + receiveMessage);
			}
			
//			socket.leaveGroup(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
