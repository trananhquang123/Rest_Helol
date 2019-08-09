package com.example.entites;

import javax.persistence.*;


@Entity
@Table(name = "hello_world")
public class HelloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usersgenerator")
    private Long id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
