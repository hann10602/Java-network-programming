package file;

import java.io.File;
import java.io.IOException;

public class FileObject {
	private File file;

	public FileObject(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public void getFolderTree(File file, Integer level) {
		StringBuilder branch = new StringBuilder();

		for(int i = 0; i < level; i++) {
			branch.append("   ");
		}
		
		branch.append("|__ " + file.getName());
		
		System.out.println(branch);
		
		if(file.isDirectory()) {
			for(File subFile : file.listFiles()) {
				getFolderTree(subFile, level + 1);
			}
		}
	}
	
	public void createFile() {
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void renameFile(String newName) {
		try {
			String path = this.file.getParentFile().getPath();
			
			deleteFile();
			
			File file = new File(path + "\\" + newName);
			
			file.createNewFile();
			
			setFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFile() {
		this.file.delete();
	}
}
