package io;

import java.io.File;

public class IOEx {
	public static void main(String[] args) {
		IOFile file = new IOFile(new File("D:\\Game\\afgg.txt"));
		
		file.readFile();
	}
}
