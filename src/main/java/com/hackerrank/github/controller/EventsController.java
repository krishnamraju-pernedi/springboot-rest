package com.hackerrank.github.controller;

import com.hackerrank.github.EventsService;
import com.hackerrank.github.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @PostMapping
    public ResponseEntity crete(@RequestBody Event event) {

        boolean isSuccess = eventsService.createEvent(event);
        if(isSuccess){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findByEventId(@PathVariable long id) {

        Event event = eventsService.findEventById(id);
        if(event ==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(event);
    }


    @GetMapping("/repos/{repoId}")
    public ResponseEntity<List<Event>> findByRepoId(@PathVariable long repoId) {

        List<Event> events = eventsService.findEventByRepoId(repoId);
        if(CollectionUtils.isEmpty(events))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }


    @GetMapping("/actors/{actorId}")
    public ResponseEntity<List<Event>> findByActorId(@PathVariable long actorId) {

        List<Event> events = eventsService.findEventByActorId(actorId);
        if(CollectionUtils.isEmpty(events))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }

    @GetMapping("/repos/{repoId}/actors/{actorId}")
    public ResponseEntity<List<Event>> findByRepoIdAAndActorId(@PathVariable long repoId, @PathVariable long actorId) {
        List<Event> events = eventsService.findEventByRepoIdActorId(repoId, actorId);
        if(CollectionUtils.isEmpty(events))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(events);

    }


    @GetMapping
    public ResponseEntity<List<Event>> findAllEvents() {
        List<Event> events = eventsService.findAllEvents();
        if(events == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }


}
