package com.lte.woods_resort.services;

import java.util.List;

import com.lte.woods_resort.models.Events;

public interface IEventsService {
    public List<Events> listEvents();
    public Events searchEvents(Long id_event);
    public Events saveEvents(Events events);
    public void removeEvents(Events events);
}
