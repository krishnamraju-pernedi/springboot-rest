package com.hackerrank.github.service;

import com.hackerrank.github.model.Event;

import java.util.List;

public interface EventsService {

    boolean createEvent(Event event);

    Event findEventById(long id);

    List<Event> findEventByRepoIdActorId(long repoId, long actorId);

    List<Event> findEventByActorId(long actorId);

    List<Event> findEventByRepoId(long repoId);

    List<Event> findAllEvents();

}
