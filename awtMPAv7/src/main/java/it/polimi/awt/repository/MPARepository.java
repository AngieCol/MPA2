package it.polimi.awt.repository;

import it.polimi.awt.model.Mountains;
import it.polimi.awt.model.Media;

import java.util.List;

public interface MPARepository {
	
	
	 Mountains findMountainByName(String name);
	 List<Mountains> findAllMountains();
	 void insertMountains (List<Mountains>  mountains);
	//List<Media> findAllMedias(String mountain);

}
