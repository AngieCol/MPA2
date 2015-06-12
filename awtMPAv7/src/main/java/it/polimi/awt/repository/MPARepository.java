package it.polimi.awt.repository;

import it.polimi.awt.model.Mountains;

import java.util.List;

public interface MPARepository {
	
	
	 List<Mountains> findMountainByName(String name);

}
