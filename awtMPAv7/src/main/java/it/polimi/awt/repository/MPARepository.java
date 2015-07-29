package it.polimi.awt.repository;

import it.polimi.awt.model.Mountains;
import it.polimi.awt.model.Media;

import java.util.List;

public interface MPARepository {
	
	
	public Mountains findMountainByName(String name);
	public List<Mountains> findAllMountains();
	public void insertMountains (List<Mountains>  mountains);
	public List<Media> findAllMedias(int mountain);
	public void insertMedias (List<Media>  medias, Mountains mountain);
	public List<Media> findSavedMountains();

}
