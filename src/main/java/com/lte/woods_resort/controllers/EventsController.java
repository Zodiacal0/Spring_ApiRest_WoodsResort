package com.lte.woods_resort.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.exceptions.EventsExceptions;
import com.lte.woods_resort.models.Events;
import com.lte.woods_resort.services.IEventsService;

@RestController
@RequestMapping("wdr/v1/Events")
public class EventsController {
    private Events events;

    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

    @Autowired
    private IEventsService iEventsService;

    @GetMapping("/list-Events")
    public List<Events> listEvents(){
        var events = iEventsService.listEvents();
        events.forEach((event -> logger.info(events.toString())));
        return events;
    }

    @GetMapping("/search-Event/{id}")
    public ResponseEntity<Events> searchEvents(@PathVariable Long id_event){
        this.events = iEventsService.searchEvents(id_event);
        if(this.events == null)
        throw new EventsExceptions("EVENTS WERE NOT FOUND");
        return ResponseEntity.ok(this.events);
    }

    @PostMapping("/save-Events")
    public Events saveEvents(@RequestBody Events events){
        logger.info("NEW EVENT ADDED/NEW EVENTS ADDED");
        return iEventsService.saveEvents(events);
    }

    @PutMapping("/edit-Events/{id}")
    public ResponseEntity<Events> editEvents(@PathVariable Long id_event, @RequestBody Events events){
        this.events = iEventsService.searchEvents(id_event);
        if(this.events == null)
        throw new EventsExceptions("EVENT WAS NOT FOUND/EVENTS WERE NOT FOUND");
        this.events.setName_event(events.getName_event());
        this.events.setEvent_description(events.getEvent_description());
        this.events.setDate(events.getDate());
        iEventsService.saveEvents(this.events);
        return ResponseEntity.ok(this.events);
    }

    @DeleteMapping("/delete-Events/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvents(@PathVariable Long id_event){
        this.events = iEventsService.searchEvents(id_event);
        if(this.events == null)
        throw new EventsExceptions("EVENT WAS NOT FOUND/EVENTS WERE NOT FOUND");
        iEventsService.removeEvents(this.events);

        Map<String, Boolean> confirmatione = new HashMap<>();
        confirmatione.put("EVENT SUCCESSFULLY ELIMINATED/EVENTS SUCCESSFULLY ELIMINATED", true);
        return ResponseEntity.ok(confirmatione);
    }

}
