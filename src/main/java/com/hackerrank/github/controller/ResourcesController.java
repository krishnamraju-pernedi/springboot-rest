package com.hackerrank.github.controller;

import com.hackerrank.github.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

    @Autowired
    ResourceService eventsService;

    @DeleteMapping
    public void deleteAll() {
        eventsService.deleteAll();
    }


}
