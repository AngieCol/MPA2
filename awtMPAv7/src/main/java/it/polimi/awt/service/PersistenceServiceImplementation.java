package it.polimi.awt.service;

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

//	@Override
	public List<Mountains> findAll() {
		
		return mpRepository.findAllMountains();
	}
	
	
	public Mountains findMountainByName(String name) 
	{
		
		return mpRepository.findMountainByName(name);
	}
	
	
	
}
