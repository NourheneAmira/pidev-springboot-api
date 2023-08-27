package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Parent;


public interface ParentService    {
	/* List<Parent> retrieveAllParents(); 
	 Parent addParent (Parent e);
	 void deleteParent(String id);
	 Parent updateParent(Parent e);*/
    Parent retrieveParent(Long id);

}
