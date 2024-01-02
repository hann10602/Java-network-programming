package udpIP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DNSClient {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			InetAddress serverAddress = InetAddress.getByName("localhost");
			int serverPort = 8000;
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("Nhập vào domain name: ");
				String domainName = sc.nextLine();
				
				byte[] sendData = domainName.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
				socket.send(sendPacket);
				
				byte[] receiveData = new byte[1024];
				
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				
				String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
				
				System.out.println("IP: " + response);
				socket.close();
 			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
