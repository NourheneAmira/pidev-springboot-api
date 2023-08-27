package com.esprit.tn.repository;



import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Event;
import com.esprit.tn.entities.KinderGarten;

@Repository
public interface KinderGartenReposiory extends  JpaRepository<KinderGarten,Long>{

}
