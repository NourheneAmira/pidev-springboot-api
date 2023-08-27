package com.esprit.tn.restcontroller;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.tn.entities.Category_event;
import com.esprit.tn.entities.Event;
import com.esprit.tn.entities.Parent;
import com.esprit.tn.services.EventService;
import com.esprit.tn.services.EventServiceImpl;
import com.esprit.tn.services.UploadImageService;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class Eventcontroller {

@Autowired
EventService CEvent;
@Autowired
UploadImageService uploadImageService;


////http://localhost:8550/SpringMVC/servlet/add-event/{idKinderGarten}
@PostMapping("/add-event/{idKinderGarten}")
@ResponseBody
public Event addEvent(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String event,@PathVariable("idKinderGarten") Long idKinderGarten) throws IOException {

	System.out.println("Original Image Byte Size - " + file.getBytes().length);
	Event e = new ObjectMapper().readValue(event, Event.class);
	e.setPhoto(uploadImageService.compressBytes(file.getBytes()));
	return CEvent.addEvent(e, idKinderGarten);
}
////http://localhost:8550/SpringMVC/servlet/retriveallevent
@GetMapping("/retriveallevent")
@ResponseBody
public List<Event> getEvent() {
	List<Event> list= CEvent.retrieveAllEvents();
	return list;}
//Modifier Event : http://localhost:8550/update-event
@PutMapping("/update-event")
@ResponseBody
public Event ModifierEvent(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String event) throws IOException{
	System.out.println("Original Image Byte Size - " + file.getBytes().length);
	Event e = new ObjectMapper().readValue(event, Event.class);
	e.setPhoto(uploadImageService.compressBytes(file.getBytes()));
	return CEvent.updateEvent(e);
} 

//http://localhost:8550/SpringMVC/servlet/remove-event/{event-id}
@DeleteMapping("/remove-event/{event-id}")
@ResponseBody
public void removeUser(@PathVariable(name="event-id")
String idEvent) {
	CEvent.deleteEvent(idEvent);
}

//http://localhost:8550/SpringMVC/servlet/retrieve-event/{idEvent}
@GetMapping("/retrieve-event/{idEvent}")
@ResponseBody
public Event retrieveEvent(@PathVariable("idEvent") Long idEvent) {
return CEvent.retrieveEvent(idEvent);
} 


////http://localhost:8550/SpringMVC/servlet/add-participant/{idParent}/event/{idEvent}
@PostMapping("/add-participant/{idParent}/event/{idEvent}")
@ResponseBody
public Collection<Parent> addParticipant(@PathVariable Long idParent, @PathVariable Long idEvent) {
return CEvent.addParticipation(idParent, idEvent);
}

//http://localhost:8550/SpringMVC/servlet/retrieve-Price/{idEvent}
@GetMapping("/retrieve-Price/{idEvent}")
@ResponseBody
public Float retrievePrice(@PathVariable("idEvent") Long idEvent) {
return CEvent.getPriceTotale(idEvent);
} 
//http://localhost:8550/SpringMVC/servlet/retrieve-Event-ByCategory/{category}/kinderGarten/{idKinder}
@GetMapping("/retrieve-Event-ByCategory/{category}/kinderGarten/{idKinder}")
@ResponseBody
public List<Event> retrieveEventByCategory(@PathVariable Category_event category,@PathVariable Long idKinder) {
return CEvent.retrieveEventsByCategory(category, idKinder);
} 
//http://localhost:8550/SpringMVC/servlet/retrieve-Event-ByNbrParticipants
@GetMapping("/retrieve-Event-ByNbrParticipants")
@ResponseBody
public List<Event> retrieveEventByParticipant() {
return CEvent.retrieveEventsOrdrybyNbrParticipants();
} 

////http://localhost:8550/SpringMVC/servlet/add-Interested/{idParent}/event/{idEvent}
@PostMapping("/add-Interested/{idParent}/event/{idEvent}")
@ResponseBody
public List<Parent> addInterested(@PathVariable Long idParent, @PathVariable Long idEvent) {
return CEvent.addInterested(idParent, idEvent);
}
@PostMapping("/annuler-Interested/{idParent}/event/{idEvent}")
@ResponseBody
public List<Parent> AnnulerInterested(@PathVariable Long idParent, @PathVariable Long idEvent) {
return CEvent.AnnulerInterested(idParent, idEvent);
}

}
