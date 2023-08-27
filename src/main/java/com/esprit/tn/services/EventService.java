package com.esprit.tn.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Category_event;
import com.esprit.tn.entities.Event;
import com.esprit.tn.entities.Parent;



public interface EventService    {
	List<Event> retrieveAllEvents(); 
	List<Event> retrieveEventsOrdrybyNbrParticipants(); 
	List<Event> retrieveEventsByCategory(Category_event category,Long idKinder); 
	Event addEvent (Event e,Long id);
	void deleteEvent(String id);
	Event updateEvent(Event e);
    Event retrieveEvent(Long id);
    public List<Parent> AnnulerInterested(long idUser, long id);
    Collection<Parent> addParticipation (Long idUser, Long id);
	Float getPriceTotale(Long idEvent);
	public List<Parent> addInterested(long idUser, long id);

}
