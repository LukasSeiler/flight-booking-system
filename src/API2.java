
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

public class API2 {
	
	private static HttpURLConnection connection;
	public static ArrayList<String> ort = new ArrayList<String>();
	static String ortschaft;

	public API2(String plz) {
		
		URL url;
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		try {
			url = new URL("https://swisspost.opendatasoft.com/api/records/1.0/search/?dataset=plz_verzeichnis_v2&q=&facet=postleitzahl&refine.postleitzahl="+plz+"&fields=ortbez27");
			connection = (HttpURLConnection) url.openConnection();
			
			//Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000); // 5 Seconds
			connection.setReadTimeout(5000); // 5 Seconds
			
			int status = connection.getResponseCode(); // 200 equals a success
			//System.out.println(status);
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
					responseContent.append("");
				}
				reader.close();
			}
			parse(responseContent.toString());
			
			
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
		JSONArray jsonArray = jsnobject.getJSONArray("records");
		
		for (int i = 0; i < jsonArray.length(); i++) {
		    JSONObject airport = jsonArray.getJSONObject(i);
			if(!(jsonArray.toString() == null)){
				JSONObject fields = airport.getJSONObject("fields");
				ortschaft = fields.getString("ortbez27");
				
			}else {
				System.out.println("Null");
				break;
			}
		}
		
	}

}
