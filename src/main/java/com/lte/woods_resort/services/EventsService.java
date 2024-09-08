package com.lte.woods_resort.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lte.woods_resort.models.Events;
import com.lte.woods_resort.repository.EventsRepository;

@Service
public class EventsService implements IEventsService {

    private Events events;

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<Events> listEvents() {
        return eventsRepository.findAll();
    }

    @Override
    public Events searchEvents(Long id_event) {
        this.events = eventsRepository.findById(id_event).orElse(null);
        return this.events;
    }

    @Override
    public Events saveEvents(Events events) {
        return eventsRepository.save(events);
    }

    @Override
    public void removeEvents(Events events) {
        eventsRepository.delete(events);
    }
}
