package com.hackerrank.github.service.impl;

import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.entity.EventEntity;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventsService;
import com.hackerrank.github.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventsResourcesServiceImpl implements EventsService, ResourceService {

    @Autowired
    EventRepository eventRepository;

    public boolean createEvent(Event event){
        EventEntity eventEntity = new EventEntity(event);
        EventEntity eventEntity1 = eventRepository.findById(eventEntity.getId()).orElse(null);

        if(eventEntity1 != null)
            return false;
        eventRepository.save(eventEntity);
        return true;
    }

    public Event findEventById(long id) {
        EventEntity eventEntity = eventRepository.findById(id).orElse(null);
        if(eventEntity == null)
            return null;
       return new Event(eventEntity);
    }

    public List<Event> findEventByRepoIdActorId(long repoId, long actorId) {
        List<EventEntity> list = eventRepository.findByRepoIdAndActorId(repoId, actorId);
        List<Event> events = new ArrayList<>();
        list.forEach(l-> events.add(new Event(l)));
        return events;
    }

    public List<Event> findEventByActorId(long actorId) {
        List<EventEntity> list = eventRepository.findByActorId(actorId);
        List<Event> events = new ArrayList<>();
        list.forEach(l-> events.add(new Event(l)));
        return events;
    }

    public List<Event> findEventByRepoId(long repoId) {
        List<EventEntity> list = eventRepository.findByRepoId(repoId);
        List<Event> events = new ArrayList<>();
        list.forEach(l-> events.add(new Event(l)));
        return events;
    }

    public List<Event> findAllEvents() {
        List<EventEntity> list = eventRepository.findAll();
        List<Event> events = new ArrayList<>();
        list.forEach(l-> events.add(new Event(l)));
        return events;
    }

    public void deleteAll() {
        eventRepository.deleteAll();
    }
}
