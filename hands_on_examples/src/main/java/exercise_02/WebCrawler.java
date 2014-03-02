package exercise_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class WebCrawler {

	public static void main(String[] args) {
		String content = new URLConnectionReader().getText("http://www.retorte.ch/");
        System.out.println(content);
	}
	
}


/**
 * Taken from here: http://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code/4328733#4328733
 */
class URLConnectionReader {
    public String getText(String url)  {
    	try {
	        URL website = new URL(url);
	        URLConnection connection = website.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	
	        StringBuilder response = new StringBuilder();
	        String inputLine;
	
	        while ((inputLine = in.readLine()) != null) 
	            response.append(inputLine);
	
	        in.close();
	
	        return response.toString();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }

}