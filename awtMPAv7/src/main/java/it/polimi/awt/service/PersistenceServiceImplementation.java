package it.polimi.awt.service;

import it.polimi.awt.model.Media;
import it.polimi.awt.model.Mountains;
import it.polimi.awt.repository.MPARepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersistenceServiceImplementation implements PersistenceService {

	@Autowired
	private MPARepository mpRepository;

	@Override
	public List<Mountains> findAllMountains() {
		
		return mpRepository.findAllMountains();
	}
	
	@Override
	public Mountains findMountainByName(String name) 
	{
		
		return mpRepository.findMountainByName(name);
	}


	@Override
	public void insertMountains(List<Mountains> mountains) {
		 mpRepository.insertMountains(mountains);
		
	}


	@Override
	public List<Media> findAllMedias(String mountain) {
		
		return mpRepository.findAllMedias(mountain);
	}


	@Override
	public void insertMedias(List<Media> medias, Mountains mountain) {
		mpRepository.insertMedias(medias, mountain);
		
	}
	
	
	
}
