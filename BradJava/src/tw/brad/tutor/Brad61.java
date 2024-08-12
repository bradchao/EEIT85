package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad61 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvMovingRoad.aspx");
			URLConnection conn =  url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			bin.close();
			
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		
		for (int i=0; i<root.length(); i++) {
			JSONObject element = root.getJSONObject(i);
			String name = element.getString("Name");
			String addr = element.getString("MaintainUnit");
			String tel = element.getString("Tel");
			System.out.printf("%s : %s : %s\n", name, addr, tel);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
