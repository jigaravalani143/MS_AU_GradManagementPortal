package com.accolite.msproject.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Institute implements Serializable {
    //Institute class generates a table named institute in DB with fields id and name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    public Institute(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Institute() {
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
