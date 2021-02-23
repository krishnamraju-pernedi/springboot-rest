package com.hackerrank.github.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackerrank.github.entity.EventEntity;

import java.sql.Timestamp;

public class Event {
    private Long id;
    private String type;
    private Actor actor;
    private Repo repo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private Timestamp createdAt;

    public Event() {
    }

    public Event(Long id, String type, Actor actor, Repo repo, Timestamp createdAt) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.createdAt = createdAt;
    }

    public Event(EventEntity event) {
        //mapping
        this.id = event.getId();
        this.type = event.getType();
        this.actor = new Actor();
        this.actor.setId(event.getActorId());
        this.actor.setAvatar(event.getActorAvatarUrl());
        this.actor.setLogin(event.getActorLogin());
        this.repo = new Repo();
        this.repo.setId(event.getRepoId());
        this.repo.setName(event.getRepoName());
        this.repo.setUrl(event.getRepoUrl());
        this.createdAt = event.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
