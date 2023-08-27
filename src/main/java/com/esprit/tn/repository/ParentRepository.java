package com.esprit.tn.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Parent;



@Repository
public interface ParentRepository extends  JpaRepository<Parent,Long>{
	 List<Parent> findByKinderGartennIdKindergarten(Long id);
	 
         
}
