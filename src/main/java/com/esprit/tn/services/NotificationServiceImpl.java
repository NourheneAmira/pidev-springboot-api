
package com.esprit.tn.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.esprit.tn.entities.Event;
import com.esprit.tn.entities.Notification;
import com.esprit.tn.entities.Parent;
import com.esprit.tn.entities.Notification;
import com.esprit.tn.repository.EventReposiory;
import com.esprit.tn.repository.NotificationRepository;
import com.esprit.tn.repository.ParentRepository;
import com.esprit.tn.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	NotificationRepository Notificationrepository;
	@Autowired
	EventService eventService;
	@Autowired
	ParentRepository parentReposotory;
	@Autowired
	EventReposiory eventRepository;
	@Autowired
	ParentService parentService;
	private static final Logger l = LogManager.getLogger(NotificationServiceImpl.class);
	
	

	@Override
	public String addNotification(Long idEvent) {
		Event event =eventService.retrieveEvent(idEvent);
		// l parents qui appartiennet a cette kinger garten
		List<Parent>parents=parentReposotory.findByKinderGartennIdKindergarten(event.getKinderGardenevent().getIdKindergarten());
		for(Parent p:parents)
		{
Notification notification = new Notification();
			
			
			notification.setEvents(event);
			notification.setParents(p);
			notification.setMessage("nouveau  événement ");
			Notification notif=Notificationrepository.save(notification);
			
		}	return "nouveau un événement ";
		}

	@Override
	public List<Notification> retrieveNotificationsByParent(Long idParent) {
		return Notificationrepository.findByParentsId(idParent);
	}
	
	@Override
	public List<Notification> retrieveAllNotifications() {

		List<Notification> Notifications = (List<Notification>) Notificationrepository.findAll();
		for (Notification Notification : Notifications) {
			l.info("Notification" + Notification);
		}
		return Notifications;

	}

	@Override
	public String addNotificationByDate(Long idkinder) {
		//liste des evenement ili 3mliyt hom l idkinder
		List<Event>events=eventRepository.findByKinderGardeneventIdKindergarten(idkinder);
		for(Event e:events)
		{
			if(verifyTwoDateWithYear(e.getDate_event(), new Date())==true)
			{
				Notification notification =new Notification();
				notification.setEvents(e);
				for(Parent p:e.getParent1s())
				{
					
					notification.setParents(p);
					notification.setMessage("Aujourdhui vous avez un événement ");
					Notification notif=Notificationrepository.save(notification);
					return "Aujourdhuis vous avez  un événement ";

				}
				
			}
			
		}
		
		return "Aucun évenement Aujourdhui";
	}

	@Override
	public boolean verifyTwoDateWithYear(Date startDate, Date endDate) {
		
		// caledar est une classe abstarait
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			int year = calendar.get(Calendar.YEAR);
			int mois=calendar.get(Calendar.MONTH);
			int jour=calendar.get(Calendar.DATE);
		    
			
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(endDate);
			int year2 = calendar2.get(Calendar.YEAR);
			int mois2=calendar2.get(Calendar.MONTH);
			int jour2=calendar2.get(Calendar.DATE);
			
			 if(year == year2 && mois==mois2 && jour==jour2 )
			 {
				 return true;
			 }

else
	    return false;

	}

}



