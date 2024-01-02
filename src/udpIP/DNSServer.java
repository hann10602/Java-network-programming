package udpIP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DNSServer {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(8000);
			
			System.out.println("DNS server is running...");
			
			String[][] dnsTable = {
					{"www.example.com", "192.168.42.1"},
					{"www.ngocha.com", "122.119.42.1"},
					{"www.mny.com", "12.178.42.1"},
			};
			
			while (true) {
				byte[] receiveData = new byte[1024];
				
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				
				String domainName = new String(receivePacket.getData(), 0, receivePacket.getLength());
				
				domainName = domainName.trim();
				domainName = domainName.toLowerCase();
				
				String response = "Not found";
				
				for(String[] entry : dnsTable) {
					if(entry[0].equals(domainName)) {
						response = entry[1];
						break;
					}
				}
				
				InetAddress clientAddress = receivePacket.getAddress();
				int clientPort = receivePacket.getPort();
				byte[] responseData = response.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
				
				socket.send(sendPacket);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
