package com.esprit.tn.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.tn.entities.Category_event;
import com.esprit.tn.entities.Event;
import com.esprit.tn.entities.KinderGarten;
import com.esprit.tn.entities.Parent;
import com.esprit.tn.repository.EventReposiory;
import com.esprit.tn.repository.KinderGartenReposiory;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventReposiory eventrepository;
	@Autowired
	EventService eventService;
	@Autowired
	ParentService parentService;
	@Autowired
	KinderGartenReposiory kindRepository;
	@Autowired
	NotificationService notifService;
	private static final Logger l = LogManager.getLogger(EventServiceImpl.class);

	@Override
	public List<Event> retrieveAllEvents() {

		List<Event> events = (List<Event>) eventrepository.findAll();
		for (Event event : events) {
			l.info("Event" + event);
		}
		return events;

	}

	@Override
	public Event addEvent(Event e,Long id) {
		KinderGarten kinder= kindRepository.findById(id).get();
		e.setKinderGardenevent(kinder);
		e.setNbr_interssants(0);
        e.setNbr_places_occupes(0);
        e.setNbr_participants(0);
        e.setNbr_ignorer(0);
        e.setNbr_invites(0);
	    eventrepository.save(e);
	   notifService.addNotification(e.getIdEvent());
	return e;
		
	}

	@Override
	public void deleteEvent(String id) {
		eventrepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Event updateEvent(Event e) {
		
		e.setKinderGardenevent(e.getKinderGardenevent());
		return eventrepository.save(e);
	}

	@Override
	public Event retrieveEvent(Long id) {
		return eventrepository.findById(id).get();
	}

	@Override
	public Collection<Parent> addParticipation(Long idUser, Long id) {
		Event event =eventrepository.findById(id).get();
		Parent parent=parentService.retrieveParent(idUser);
		List<Parent>listParent=new ArrayList<>();
		listParent.add(parent);
		event.setParent1s(listParent);
		event.setNbr_participants(event.getNbr_participants()+1);
		eventService.updateEvent(event);
		return event.getParent1s();
	}

	@Override
	public Float getPriceTotale(Long idEvent) {
	Event event =eventService.retrieveEvent(idEvent);
		return (float) (event.getEntry_price()*event.getNbr_participants());
	}

	@Override
	public List<Event> retrieveEventsOrdrybyNbrParticipants() {
		return eventrepository.findTop10ByOrderByNbrparticipantsAsc();
	}

	@Override
	public List<Event> retrieveEventsByCategory(Category_event category,Long idKinder) {
		return eventrepository.findByCategoryAndKinderGardeneventIdKindergarten(category, idKinder);
	}

	@Override
	public List<Parent> addInterested(long idUser, long id) {
		Event event =eventService.retrieveEvent(id);
		Parent parent=parentService.retrieveParent(idUser);
		List<Parent>listParent=new ArrayList<>();
		// paent ili jibtou bil id 
		listParent.add(parent);
		event.setParent1s(listParent);
		event.setNbr_interssants(event.getNbr_interssants()+1);
		eventService.updateEvent(event);
		return listParent;
	}

	@Override
	public List<Parent> AnnulerInterested(long idUser, long id) {
		Event event =eventService.retrieveEvent(id);
		Parent parent=parentService.retrieveParent(idUser);
		List<Parent>listParent=new ArrayList<>();
		listParent=(List<Parent>) event.getParent1s();
		listParent.remove(parent);
		event.setParent1s(listParent);
		event.setNbr_interssants(event.getNbr_interssants()-1);
		eventService.updateEvent(event);
		return listParent;
	}

	

}