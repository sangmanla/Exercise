import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
 
public class HttpRequestTest {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
		
		String urls[] = new String[200];
		String url = "http://webservices.nextbus.com/service/publicXMLFeed?command=messages&a=ttc&r=";
		
		int index = 0;
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/sam/Desktop/busnum.txt"));
		String line;
	    while ((line = br.readLine()) != null) {
	    	urls[index] = line;
	    	index++;
	    }

		HttpRequestTest http = new HttpRequestTest();
 
		for (String number : urls) {
			if(number == null) break;
			System.out.print("Bus number : " + number + "|");
			http.sendGet(url + number);
		}
		
		if(br!=null){
			br.close();
		}
 
//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost(args[0]);
 
	}
 
	// HTTP GET request
	private void sendGet(String url) throws Exception {
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		if(response.toString().length() != 146){
			System.out.println(response.toString());
		}
 
	}
 
	// HTTP POST request
	private void sendPost(String url) throws Exception {
 
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
}