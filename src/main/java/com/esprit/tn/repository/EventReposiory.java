package com.esprit.tn.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Category_event;
import com.esprit.tn.entities.Event;

@Repository
public interface EventReposiory extends  JpaRepository<Event,Long>{

	public List<Event> findByKinderGardeneventIdKindergarten(Long id);
	public List<Event> findTop10ByOrderByNbrparticipantsAsc();
    public List<Event> findByCategoryAndKinderGardeneventIdKindergarten(Category_event ctegory,Long idKinder);

}
