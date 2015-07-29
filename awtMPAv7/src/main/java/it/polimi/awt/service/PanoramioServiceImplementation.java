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










import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;



@Service
public class PanoramioServiceImplementation implements PanoramioService{

	@Override
	public List<List<String>> getPhotosPanoramio( String latitude, String longitude,  String fromNumberPhoto, String toNumberPhoto, String size) {

		List<List<String>> listaMedias= new ArrayList<List<String>>();

		


		try {
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setDecimalSeparator('.');
			DecimalFormat format = new DecimalFormat("#.#");
			format.setDecimalFormatSymbols(symbols);

			float la = format.parse(latitude).floatValue();
			float lo = format.parse(longitude).floatValue();
			float minLa=la-10;
			float minLo=lo-10;
			float maxLa=la+10;
			float maxLo=lo+10;

			String minimumLongitude=minLo+"", minimumLatitude=minLa+"", maximumLongitude=maxLo+"", maximumLatitude=maxLa+"";


			


			URL panoramioURL = new URL("http://www.panoramio.com/map/get_panoramas.php?set=public&from="+fromNumberPhoto+"&to="+toNumberPhoto+"&minx="+minimumLongitude+"&miny="+minimumLatitude+"&maxx="+maximumLongitude+"&maxy="+maximumLatitude+"&size="+size+"&mapfilter=true");



			BufferedReader in = new BufferedReader(
					new InputStreamReader(panoramioURL.openStream()));

			String urlPhotos;

			while ((urlPhotos = in.readLine()) != null){

			//	System.out.println("***********************************************************************************");
				//System.out.println("ojoPANORAMIOOO"+urlPhotos);
				//System.out.println("***********************************************************************************");
				JSONObject object = new JSONObject(urlPhotos);
				JSONArray photosAll = object.getJSONArray("photos");


				for (int i = 0; i < photosAll.length(); ++i) {
					JSONObject photo = photosAll.getJSONObject(i);
					


					List <String> listaPhotosInfo = new ArrayList<String>();

					listaPhotosInfo.add(photo.getString("photo_title"));
					listaPhotosInfo.add(photo.getString("photo_file_url"));
					listaPhotosInfo.add(photo.getDouble("longitude")+"");
					listaPhotosInfo.add(photo.getDouble("latitude")+"");
					listaMedias.add(listaPhotosInfo);
					
					//System.out.println("holaaaa........"+photo.getDouble("longitude")+"***"+photo.getDouble("latitude")+"");
				}





			}
			in.close();


		} catch (IOException | JSONException |ParseException e) {

			e.printStackTrace();
		}
		return listaMedias;
	}



}
