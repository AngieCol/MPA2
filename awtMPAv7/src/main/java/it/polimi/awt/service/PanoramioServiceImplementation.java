package it.polimi.awt.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;






import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



@Service
public class PanoramioServiceImplementation implements PanoramioService{

	@Override
	public List<String> getPhotosPanoramio(String minimumLongitude, String minimumLatitude, String maximumLongitude, String maximumLatitude, String fromNumberPhoto, String toNumberPhoto, String size) {

		
		
		
		List <String> urls = new ArrayList<String>();

		try {
			URL panoramioURL = new URL("http://www.panoramio.com/map/get_panoramas.php?set=public&from="+fromNumberPhoto+"&to="+toNumberPhoto+"&minx="+minimumLongitude+"&miny="+minimumLatitude+"&maxx="+maximumLongitude+"&maxy="+maximumLatitude+"&size="+size+"&mapfilter=true");

			

			BufferedReader in = new BufferedReader(
					new InputStreamReader(panoramioURL.openStream()));

			String urlPhotos;

			while ((urlPhotos = in.readLine()) != null){

			

				JSONObject object = new JSONObject(urlPhotos);
				JSONArray photosAll = object.getJSONArray("photos");
			
			
				 for (int i = 0; i < photosAll.length(); ++i) {
					    JSONObject photo = photosAll.getJSONObject(i);
					   urls.add(photo.getString("photo_file_url"));
					}
				
			
			


			}
			in.close();


		} catch (IOException | JSONException e) {

			e.printStackTrace();
		}
		return urls;
	}



}
