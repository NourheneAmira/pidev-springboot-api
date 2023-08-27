package com.esprit.tn.services;

import java.util.Date;
import java.util.List;

import com.esprit.tn.entities.Notification;


public interface NotificationService    {
	String addNotification (Long idEvent);
	String addNotificationByDate (Long idEvent);
     List<Notification> retrieveNotificationsByParent(Long idParent); 
	 List<Notification> retrieveAllNotifications(); 
	public boolean verifyTwoDateWithYear(Date startDate, Date endDate);
	
}
