package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLObject {
	private String urlStr;
	private URL url;

	public URLObject(String url) {
		this.urlStr = urlStr;
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrlStr() {
		return urlStr;
	}

	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public void getContent() {
		try {
			InputStreamReader isr = new InputStreamReader(this.url.openStream());
			BufferedReader br = new BufferedReader(isr);
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getStatus() {
			try {
				HttpURLConnection conn = (HttpURLConnection) this.url.openConnection();
				
				Integer code = conn.getResponseCode();
				
				if(code == 200) {
					System.out.println("Website is active");
				} else {
					System.out.println("Website is inactive with code " + code);
				}
				
				} catch (IOException e) {
				System.out.println("Website is connect failed");
			}
	}
}
