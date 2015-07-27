package it.polimi.awt.service;

import java.util.List;


public interface PanoramioService {
	List<List<String>> getPhotosPanoramio( String latitude, String longitude,  String fromNumberPhoto, String toNumberPhoto, String size);
}
	
	


	
	
	

