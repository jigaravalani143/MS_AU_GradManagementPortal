package com.accolite.msproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    public Skill(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Skill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}