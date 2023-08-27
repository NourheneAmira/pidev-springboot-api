package com.esprit.tn.restcontroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Event;
import com.esprit.tn.entities.Notification;
import com.esprit.tn.services.NotificationService;


@RestController
public class Notificationcontroller {

@Autowired
NotificationService CNotification;

//afficher l notification par parent 
//http://localhost:8550/SpringMVC/servlet/retrieve-Notification/{idParent}
@GetMapping("/retrieve-Notification/{idParent}")
@ResponseBody
public List<Notification> retrieveNotification(@PathVariable("idParent") Long idParent) {
return CNotification.retrieveNotificationsByParent(idParent);
}
@PostMapping("/add-Notification/{idKinder}") 
@ResponseBody
public String Notification(@PathVariable Long idKinder) {
return CNotification.addNotificationByDate(idKinder);
} 




}
