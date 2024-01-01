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
	
	public void writeObject(String message, String user) {
		try {
			FileOutputStream fos = new FileOutputStream(this.file, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
			
			String timeStr = currentTime.format(dtf);
			
			bw.append(timeStr + " " + user + ": " + message);
			bw.newLine();
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readObject() {
		try {
			FileInputStream fis = new FileInputStream(this.file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			System.out.println(((ObjectEx) ois.readObject()).toString());
			
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
