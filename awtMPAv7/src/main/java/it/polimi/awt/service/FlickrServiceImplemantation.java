package it.polimi.awt.service;

import it.polimi.awt.model.Mountains;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;

@Service
public class FlickrServiceImplemantation implements FlickrService
{
	
	//@Autowired
	//private Media media;

	@Override
	public List<String> getPhotosFlickr(String name) {
	
		Flickr f= new Flickr("02afc690957645cfd27f843fc86d9641", "214c85b50aea545f", new REST());

		SearchParameters searchParams=new SearchParameters();
		searchParams.setSort(SearchParameters.INTERESTINGNESS_DESC);

		String[] tags=new String[]{name};
		searchParams.setTags(tags);

		PhotosInterface photosInterface=f.getPhotosInterface();

	

		List<Photo> photosCollection = null;
		List<String> listaUrls= new ArrayList<String>();
		try {
			photosCollection = photosInterface.search(searchParams,20,0);
		} catch (FlickrException e) {
			
			e.printStackTrace();
		}

		int i = 0;

		Photo photo = null;
		Iterator photoIterator = photosCollection.iterator();
		while (photoIterator.hasNext()) {
			i++;
			photo = (Photo) photoIterator.next();
			System.out.println(i + " - Description: " + photo.getSmallUrl());
			listaUrls.add(photo.getSmallUrl());

		}
		
		
		
		
		return listaUrls;
		  
		 
	}

}
