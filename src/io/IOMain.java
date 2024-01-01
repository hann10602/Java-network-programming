package io;

import java.io.File;

public class IOMain {
	public static void main(String[] args) {
		File file = new File("D:\\Downloads\\File\\paste-folder\\object.txt");
		ObjectEx o = new ObjectEx("hann", "123456", 18);
		
		IOObject ioo = new IOObject(file, o);
		
		ioo.writeObject();
		ioo.readObject();
	}
}