package com.hackerrank.github.service.impl;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.service.EventsService;
import com.hackerrank.github.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsResourcesServiceImpl implements EventsService, ResourceService {

    @Autowired
    EventRepository eventRepository;

    public boolean createEvent(Event event){
        Event oldEntity = eventRepository.findById(event.getId()).orElse(null);

        if(oldEntity != null)
            return false;
        eventRepository.save(event);
        return true;
    }

    public Event findEventById(long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> findEventByRepoIdActorId(long repoId, long actorId) {
        return eventRepository.findByRepoIdAndActorId(repoId, actorId);
    }

    public List<Event> findEventByActorId(long actorId) {
        return eventRepository.findByActorId(actorId);
    }

    public List<Event> findEventByRepoId(long repoId) {
        return eventRepository.findByRepoId(repoId);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteAll() {
        eventRepository.deleteAll();
    }
}
