
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.*;

public class API1 {
	
	private static HttpURLConnection connection;
	public static ArrayList<String> airports = new ArrayList<String>();
	/*i für Length des JSON-Arrays*/
	private static int i = 0;
	/*ArrayList wird bei run = true befüllt*/
	private static boolean run = true;
	/*Length für die Anzeige auf dem Menu*/
	private static int length;

	public API1() {
		
		URL url;
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		try {
			//url = new URL("http://api.aviationstack.com/v1/airports?access_key=faf61d05c46cadbb253f855003dea9a9&limit=6500");
			url = new URL("http://api.aviationstack.com/v1/airports?access_key=05b650b6f50eb22340cc69658fda274f&limit=6500");
			connection = (HttpURLConnection) url.openConnection();
			
			//Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000); // 5 Seconds
			connection.setReadTimeout(5000); // 5 Seconds
			
			int status = connection.getResponseCode(); // 200 equals a success
			
			/*Error Status*/
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			/*Success Status*/
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
					//responseContent.append("");
				}
				reader.close();
			}
			//System.out.println(responseContent.toString());
			/*Run wird false, wenn auf dem Menu "start" geklickt wird*/
			if(run == true) {
				parse(responseContent.toString());
			}
			
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
	
	}
	
	public static void parse(String responseContent) {
		JSONObject jsnobject = new JSONObject(responseContent);
		JSONArray jsonArray = jsnobject.getJSONArray("data");
		length = jsonArray.length();
	
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject airport = jsonArray.getJSONObject(i);
			if(jsonArray.toString() != null && i != (length-2) && run != false){
				airports.add((String) airport.get("airport_name"));
				GUI1.menu.Status(i, length);
			}else{
				i = 8000;
				run = false;
			}
			
		}
		    
	}
	
	/**
	 * Mit setrun wird der Status von run auf false gesetzt, damit soll bei parse das Befüllen der ArrayList beendet werden.
	 * Trigger der Klasse befindet sich bei Menu-Class
	 * @see Menu#JLstart.mouseClicked();
	 * @param status Übergabe des boolischen Wertes false, um {@link #parse(String)} zu beenden.
	 */
	public static void setrun(boolean status) {
			run = status;
	}
	
}
