package com.hackerrank.github.controller;

import com.hackerrank.github.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
    @Autowired
    EventsService eventsService;


    @DeleteMapping
    public void deleteAll(){
        eventsService.deleteAll();
    }



}
