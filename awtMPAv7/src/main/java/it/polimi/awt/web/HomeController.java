package it.polimi.awt.web;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import it.polimi.awt.model.Media;
import it.polimi.awt.model.Mountains;
import it.polimi.awt.service.DBpediaService;
import it.polimi.awt.service.DBpediaServiceImplementation;
import it.polimi.awt.service.FlickrService;
import it.polimi.awt.service.GooglePlacesService;
import it.polimi.awt.service.PanoramioService;






import it.polimi.awt.service.PersistenceService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;










import org.springframework.web.bind.annotation.RequestParam;












//import com.aetrion.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.collections.Collection;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;


/**
 * Handles requests for the application home page.
 */

@Controller
//@RequestMapping(value = "/flickr")
public class HomeController {

	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private FlickrService flickerService;


	@Autowired
	private PanoramioService panoramioService;

	@Autowired
	private DBpediaService DBService;


	@Autowired
	private PersistenceService ps;




	@Autowired
	private GooglePlacesService gs;


	/**
	 * External Research
	 */
	@RequestMapping(value = "/ResultExternalSearch")
	public String searchExternalResoures(@RequestParam(value="name") String name, Model model) {







		List<List<String>> medias= new ArrayList<List<String>>();
		List<Media> mediasInf= new ArrayList<Media>();

		if (name != null && name !="")
		{
			
			boolean isMountain=false;
			String longitude="", latitude="", fromNumberPhoto="0",  toNumberPhoto="100", size="medium";
			System.out.println("antes de la consulta");
			Mountains m= ps.findMountainByName(name.toUpperCase());
			System.out.println("despuéss de la consulta");
			
			if(m==null)
			{
				String[] coordinatesAndIsMountain=gs.getCoordinates(name.replaceAll(" ", "%20")).split(",");
				System.out.println("coordinatesAndIsMountain:::"+coordinatesAndIsMountain[2]+":::");
				isMountain= coordinatesAndIsMountain[2].contains("true");
				longitude=coordinatesAndIsMountain[1];
				latitude=coordinatesAndIsMountain[0];
				model.addAttribute("isIndb","This mountain is not in the database");
				
				
				
				m= new Mountains();//nuevo
				m.setLatitudeDecimal(latitude);//nuevo
				m.setLongitudeDecimal(longitude);//nuevo
				m.setName(name);//nuevo
				List<Mountains> mons= new ArrayList<Mountains>();//nuevo
				mons.add(m);//nuevo
				
				System.out.println("antes de insertar la montaña");
				ps.insertMountains(mons);//nuevo
				
			}
		
			else{
				longitude=m.getLongitudeDecimal();
				latitude=m.getLatitudeDecimal();
				System.out.println("Montañaaaaaaa::::"+ m.getName()+"-"+longitude+"-"+latitude);
				isMountain=true;
				model.addAttribute("isIndb","This mountain is already in the database");

				
				
			}
			


			if(isMountain)
			{


				
				medias.addAll(flickerService.getPhotosFlickr(name, latitude, longitude));
				System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");


				medias.addAll(panoramioService.getPhotosPanoramio(latitude, longitude, fromNumberPhoto, toNumberPhoto, size));
				System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
				System.out.println("mediaSize::"+medias.size());

				if (medias.size()==0)
					return "notFound";
				else{
					
					model.addAttribute("name", name);

					
					for(int p=0;p<medias.size();p++)
					{
						
							Media med= new Media();
							med.setTitle(medias.get(p).get(0));
							med.setUrl(medias.get(p).get(1));
							med.setLatitudeDecimal(medias.get(p).get(2));
							med.setLongitudeDecimal(medias.get(p).get(3));

							System.out.println(medias.get(p).get(0));
						
							mediasInf.add(med);

					}
					
					model.addAttribute("listaMedias",mediasInf);
					
					
					
					return "Results";

				}



			}
			else
				model.addAttribute("error", "Your keyword is not a mountain, please write a valid name of a mountain");
			return "errorPage";
		}
		else 
		{
			model.addAttribute("error", "You have to insert the name of a mountain. Please fill the field of the search.");
			return "errorPage";
		}

	}


	/**
	 * External Research
	 */
	
	//nuevo
	@RequestMapping(value = "/MapSearch")
	public String SearchInMap(@RequestParam(value="selected") List<Media> mediasInf, @RequestParam(value="name") String name , Model model) {
		Mountains m= ps.findMountainByName(name.toUpperCase());
		
		if(m!=null)
		{
			ps.insertMedias(mediasInf, m);
		}
		
		return "map";
	}








	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/twitter", method = RequestMethod.GET)
	public String home(Model model) {



		//return "home";
		//model.addAttribute("mountainMatrix",flickerService.getPhotosFlickr("hi"));
		System.out.println();
		return "map";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/flickr")
	public String flickr(@RequestParam("name") String name, Model model) {
		System.out.println("llegó a controller flickr");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++   nameeeeeeeeeee :"+name);
		//	model.addAttribute("listaUrls",flickerService.getPhotosFlickr(name));
		return "flickrHome";
	}


	/**
	 * 
	 */
	@RequestMapping(value = "/showMountain")
	public String showAll(Model model) {

		model.addAttribute("lista",ps.findAllMountains());
		System.out.println("la cargó?");
		return "Mountains";
	}





	/**
	 * 
	 */
	@RequestMapping(value = "/panoramio")
	public String panoramio(Model model) {
		System.out.println("llegó a controller panoramio");

		String minimumLongitude="45", minimumLatitude="25", maximumLongitude="180", maximumLatitude="160",  fromNumberPhoto="0",  toNumberPhoto="100", size="medium";


		//System.out.println("+++++++++++++++++++++++++++++++++++++++++++   nameeeeeeeeeee :"+name);
		//	model.addAttribute("listaUrlsPanoramio", panoramioService.getPhotosPanoramio(minimumLongitude, minimumLatitude, maximumLongitude, maximumLatitude,  fromNumberPhoto,  toNumberPhoto, size));



		return "panoramioHome";
	}
}