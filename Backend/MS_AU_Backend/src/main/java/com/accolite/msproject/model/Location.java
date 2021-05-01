package com.accolite.msproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Location implements Serializable {
    //Location class generated a table named location with fields id and name in DB

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    public Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location() {
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
