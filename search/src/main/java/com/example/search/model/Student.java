package com.example.search.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

import java.util.Date;

@Data
@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @JsonIgnore
    private Date lastActiveDate;
    @Column
    @JsonIgnore
    private boolean isActive;

    public Student() {
    }

    public Student(Long id, String name, Date lastActiveDate, boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastActiveDate = lastActiveDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}