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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GooglePlacesServiceImplementation implements GooglePlacesService{





	@Override
	public String getLocationMountain(String name) {




		//https://maps.googleapis.com/maps/api/place/textsearch/json?query=monte%20rosa%20mountain&key=AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago&types=natural_feature

		List <String> urls = new ArrayList<String>();

		String otherWords="mountain%20pick%20";
		String key="AIzaSyBEHHQjgBqP-KV1XRr8TKa5uUSFw4c5Ago";
		String types="natural_feature";
		
		boolean isMountain=false;
		

		try {
			URL googleURL = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query="+otherWords+name+"&key="+key+"&types="+types);
		


		BufferedReader in = new BufferedReader(
				new InputStreamReader(googleURL.openStream()));

		String urlText;

		
		System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu::::");
		
		System.out.println("url::: "+"https://maps.googleapis.com/maps/api/place/textsearch/json?query="+otherWords+name+"&key="+key+"&types="+types);
		
		Boolean out= false;
		
		String lati="";
		String longi="";
		
		while (!((urlText = in.readLine()).contains("\"status\" : \"OK\"")) && !(urlText.contains("\"status\" : \"ZERO_RESULTS\""))  && urlText!=null && !out)
		{

			
			
			if(urlText.contains("\"lat\" ")){
				String prov=urlText.trim().split(" : ")[1];
				
				lati=prov.substring(0, prov.length()-1);
				
				System.out.println("urllllll text:::"+prov.substring(0, prov.length()-1) );
			}

			if(urlText.contains("\"lng\" ")){
				longi= urlText.trim().split(" : ")[1];
				
			}

		  System.out.println(""+urlText);
		  
		  if(longi!="" && lati!="")
		  {
			  isMountain=isMountain(lati, longi);
			 if( isMountain)
				 out=true;
			 System.out.println("es montaña:::"+isMountain);
		  }

		}	
				
			
			

		System.out.println("coordenadas:"+longi+","+lati+","+isMountain);
		
		
		
		
		in.close();
		
		

		
		if(urlText.contains("\"status\" : \"ZERO_RESULTS\"") || !isMountain)
			return "notFound";
		
		else 
			return lati+","+longi+","+isMountain;
		
		
		} catch (Exception   e) {
			
			e.printStackTrace();
			return "notFound";
		}
		
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
			if(f<700)
			respuesta=false;
			
			in.close();


		} catch (IOException | ParseException| NumberFormatException/*| JSONException*/ e) {

			e.printStackTrace();
		} 
		//System.out.println("respuesta::::::::: "+respuesta);
		return respuesta;
	}
	
	/*
	@Override
	public String getCoordinates(String name) {
		
		String coordinates= getLocationMountain(name);
		
		if(!coordinates.equals("0"))
		{
		
		String[] coordinatesSplit= getLocationMountain(name).split(",");
		String lat=coordinatesSplit[0];
		String longi=coordinatesSplit[1];
		
		boolean b= isMountain(lat, longi);
		
		return coordinates+","+b;
		
		}
		
		else
			return coordinates;
	}
	
	
	*/
	
	
}
