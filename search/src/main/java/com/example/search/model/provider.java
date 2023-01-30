package com.example.search.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.websocket.server.ServerEndpoint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class provider{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String first_name;
    @Column
    @JsonIgnore
    private String middle_name;
    @Column
    private String last_name;
    @Column
    private String dob;


    public provider() {
    }

    public provider(String first_name, String middle_name, String last_name, String dob) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.dob = dob;
    }

}

