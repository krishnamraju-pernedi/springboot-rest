package com.hackerrank.github.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Event {

    @Id
    private Long id;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    private Actor actor;

    @OneToOne(cascade = CascadeType.ALL)
    private Repo repo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private Timestamp createdAt;

}
