package com.hackerrank.github.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Repo {

    @Id
    private Long id;
    private String name;
    private String url;
}
