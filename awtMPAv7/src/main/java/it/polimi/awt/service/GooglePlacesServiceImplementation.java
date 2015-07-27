package it.polimi.awt.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;









import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
 








import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



@Service
public class GooglePlacesServiceImplementation implements GooglePlacesService{






	@Override
	public String getLocationMountain(String name) {




		//https://maps.googleapis.com/maps/api/place/textsearch/json?query=monte%20rosa%20mountain&key=AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago&types=natural_feature

		List <String> urls = new ArrayList<String>();

		String otherWords="mountain%20pick";
		String key="AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago";
		String types="natural_feature";

		try {
			URL googleURL = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query="+otherWords+name+"&key="+key+"&types="+types);
		


		BufferedReader in = new BufferedReader(
				new InputStreamReader(googleURL.openStream()));

		String urlText;

		while ((urlText = in.readLine()) != null){

		//System.out.println("urlText11:"+urlText);
		
		//System.out.println("urlText22:"+urlText.replaceAll("\\s+",""));
		

		/*	JSONObject object = new JSONObject(urlPhotos);
			JSONArray results = object.getJSONArray("results");
			JSONObject geometry = results.getJSONObject(1);
			JSONObject location = geometry.getJSONObject(0);
			
			 for (int i = 0; i < results.length(); ++i) {
				    JSONObject geometry = results.getJSONObject(i);
				    //JSONArray results = object.getJSONArray("geometry");
				    
				    for (int xi = 0; xi < results.length(); ++xi) {
					    JSONObject loc = results.getJSONObject(xi);
					   urls.add(photo.getString("geometry"));
					}
				   urls.add(photo.getString("geometry"));
				}
			
		
		
*/

		}
		in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "39.7391536,-104.9847034";
		//return "41.698337,2.837753";
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	public boolean isMountain(String lat, String longi) {

		
		List <String> urls = new ArrayList<String>();
		boolean respuesta= true;

		String key="AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago";
		//https://maps.googleapis.com/maps/api/elevation/json?locations=39.7391536,-104.9847034&key=AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago
		
		try {
			URL elevationURL = new URL("https://maps.googleapis.com/maps/api/elevation/json?locations="+lat+","+longi+"&key="+key);

			

			BufferedReader in = new BufferedReader(
					new InputStreamReader(elevationURL.openStream()));

			String elevation="";

			System.out.println("urlverdadera---https://maps.googleapis.com/maps/api/elevation/json?locations=39.7391536,-104.9847034&key=AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago");
			System.out.println("url"+"https://maps.googleapis.com/maps/api/elevation/json?locations="+lat+","+longi+"&key="+key);
			
			boolean stop=false;
			
			while (!stop && ((elevation = in.readLine()) != null)){

			System.out.println("ojooooo"+elevation);

			if( elevation.contains("elevation"))
				stop=true;
			
			}
			
			String aa= elevation.substring(elevation.lastIndexOf(": ")+2,elevation.length()-1 );
	//		System.out.println("playa: "+ aa);
			//int elevationValue=Integer.parseInt();
			
			
			
			
			
				
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setDecimalSeparator('.');
			DecimalFormat format = new DecimalFormat("#.#");
			format.setDecimalFormatSymbols(symbols);
			float f = format.parse(aa).floatValue();
			if(f<1000)
			respuesta=false;
			
			in.close();


		} catch (IOException | ParseException| NumberFormatException/*| JSONException*/ e) {

			e.printStackTrace();
		} 
		//System.out.println("respuesta::::::::: "+respuesta);
		return respuesta;
	}
	
	
	@Override
	public String getCoordinates(String name) {
		
		String coordinates= getLocationMountain(name);
		
		
		String[] coordinatesSplit= getLocationMountain(name).split(",");
		String lat=coordinatesSplit[0];
		String longi=coordinatesSplit[1];
		
		boolean b= isMountain(lat, longi);
		
		return coordinates+","+b;
	}
	
	
	
	
	
}
