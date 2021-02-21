package com.hackerrank.github.entity;

import com.hackerrank.github.model.Event;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name ="events")
public class EventEntity {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "ACTOR_ID")
    private long actorId;

    @Column(name = "ACTOR_LOGIN")
    private String actorLogin;

    @Column(name = "ACTOR_AVATAR_URL")
    private String actorAvatarUrl;

    @Column(name = "REPO_ID")
    private long repoId;

    @Column(name = "REPO_NAME")
    private String repoName;

    @Column(name = "REPO_URL")
    private String repoUrl;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    public EventEntity() {
    }

    public EventEntity(Event event) {
        this.id = event.getId();
        this.type = event.getType();
        this.actorId = event.getActor().getId();
        this.actorLogin = event.getActor().getLogin();
        this.actorAvatarUrl = event.getActor().getAvatar();
        this.repoId = event.getRepo().getId();
        this.repoName = event.getRepo().getName();
        this.repoUrl = event.getRepo().getUrl();
        this.createdAt = event.getCreatedAt();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getActorLogin() {
        return actorLogin;
    }

    public void setActorLogin(String actorLogin) {
        this.actorLogin = actorLogin;
    }

    public String getActorAvatarUrl() {
        return actorAvatarUrl;
    }

    public void setActorAvatarUrl(String actorAvatarUrl) {
        this.actorAvatarUrl = actorAvatarUrl;
    }

    public long getRepoId() {
        return repoId;
    }

    public void setRepoId(long repoId) {
        this.repoId = repoId;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
