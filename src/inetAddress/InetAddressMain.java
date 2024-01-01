package inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	public static void main(String[] args) {
		try {
			InetAddress webAddress = InetAddress.getByName("www.wikipedia.org");
			System.out.println(webAddress.getHostName() + ": " + webAddress.getHostAddress());
			

			InetAddress local = InetAddress.getLocalHost();
			System.out.println("localhost: " + local.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
