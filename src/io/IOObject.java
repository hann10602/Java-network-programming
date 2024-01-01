package io;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class IOObject {
	private File file;
	private ObjectEx information;

	public IOObject(File file, ObjectEx information) {
		super();
		this.file = file;
		this.information = information;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private static Image convertByteToImage(byte[] imageBytes) throws IOException {
		BufferedImage bufferedImage;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
		
		bufferedImage = ImageIO.read(inputStream);
		
		return bufferedImage;
	}
	
	private static Image convertImageToByte(Image image) {
		if(image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		bufferedImage.getGraphics().drawImage(bufferedImage, 0, 0, null);
		return bufferedImage;
	}
	
	public void writeObject() {
		try {
			FileOutputStream fos = new FileOutputStream(this.file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			if(!this.file.exists()) {
				this.file.createNewFile();
			}
			
			oos.writeObject(this.information);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readObject() {
		try {
			FileInputStream fis = new FileInputStream(this.file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			System.out.println(((ObjectEx) ois.readObject()).getAge());
			
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
