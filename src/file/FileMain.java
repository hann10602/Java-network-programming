package file;

import java.io.File;

public class FileMain {
	public static void main(String[] args) {
		FileObject file = new FileObject(new File("D:\\Game\\afgg.txt"));
		
		file.renameFile("asdf.txt");
	}
}
