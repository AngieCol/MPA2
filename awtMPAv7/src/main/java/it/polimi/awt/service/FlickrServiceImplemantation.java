package it.polimi.awt.service;

import it.polimi.awt.model.Mountains;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.GeoData;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;

@Service
public class FlickrServiceImplemantation implements FlickrService
{
	
	//@Autowired
	//private Media media;

	@Override
	public List<List<String>> getPhotosFlickr(String name, String lati, String longi) {
	
		Flickr f= new Flickr("02afc690957645cfd27f843fc86d9641", "214c85b50aea545f", new REST());

		SearchParameters searchParams=new SearchParameters();
		searchParams.setSort(SearchParameters.INTERESTINGNESS_DESC);

		String[] tags=new String[]{name};
		searchParams.setTags(tags);

		PhotosInterface photosInterface=f.getPhotosInterface();

	

		List<Photo> photosCollection = null;
		
		
		List<List<String>> listaMedias= new  ArrayList<List<String>>();
		
		
		try {
			photosCollection = photosInterface.search(searchParams,200,0);
		} catch (FlickrException e) {
			
			e.printStackTrace();
		}

		int i = 0;

		Photo photo = null;
		Iterator photoIterator = photosCollection.iterator();
		while (photoIterator.hasNext()) {
			i++;
			List<String> listaInfo= new ArrayList<String>();
			
			
			photo = (Photo) photoIterator.next();
			//System.out.println(i + " - DescriptionFLICKR: " + photo.getSmallUrl()+":::" +photo.getTitle());
			
			
			listaInfo.add(photo.getTitle());
			listaInfo.add(photo.getSmallUrl());
			
			if(photo.hasGeoData()){
				listaInfo.add(photo.getGeoData().getLatitude()+"");
				listaInfo.add(photo.getGeoData().getLongitude()+"");
			
			}
			else{
				listaInfo.add(lati);
				listaInfo.add(longi);
			}
			
			listaMedias.add(listaInfo);
			
			

		}
		
		
		
		
		return listaMedias;
		  
		 
	}
	
	
	
	
	
	

}
