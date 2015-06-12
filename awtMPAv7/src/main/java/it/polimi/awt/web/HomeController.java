package it.polimi.awt.web;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import it.polimi.awt.service.DBpediaService;
import it.polimi.awt.service.DBpediaServiceImplementation;
import it.polimi.awt.service.FlickrService;
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
	
	//@Autowired
	//private DBpediaService DBService;
	
	@Autowired
	private PersistenceService ps;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/twitter", method = RequestMethod.GET)
	public String home() {
		//DBService.getMoreKeyworks();
		System.out.println(""+ps.findAll()); 
	   return "home";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/flickr")
	public String flickr(@RequestParam("name") String name, Model model) {
		System.out.println("llegó a controller flickr");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++   nameeeeeeeeeee :"+name);
		model.addAttribute("listaUrls",flickerService.getPhotosFlickr(name));
		return "flickrHome";
	}
	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/panoramio")
	public String panoramio(Model model) {
		System.out.println("llegó a controller panoramio");
		
		String minimumLongitude="45", minimumLatitude="25", maximumLongitude="180", maximumLatitude="160",  fromNumberPhoto="0",  toNumberPhoto="100", size="medium";
		
		
		//System.out.println("+++++++++++++++++++++++++++++++++++++++++++   nameeeeeeeeeee :"+name);
		model.addAttribute("listaUrlsPanoramio", panoramioService.getPhotosPanoramio(minimumLongitude, minimumLatitude, maximumLongitude, maximumLatitude,  fromNumberPhoto,  toNumberPhoto, size));
		
		
		
		return "panoramioHome";
	}
}