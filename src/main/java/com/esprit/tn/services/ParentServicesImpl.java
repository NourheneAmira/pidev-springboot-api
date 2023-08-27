package com.esprit.tn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Parent;
import com.esprit.tn.repository.ParentRepository;



@Service
public class ParentServicesImpl implements ParentService {
@Autowired
private ParentRepository parentRepository;

@Override
public Parent retrieveParent(Long id) {
	return parentRepository.findById(id).get();
}
	}
	
	