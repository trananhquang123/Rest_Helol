package com.example.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "hello_world")
public class HelloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usersgenerator")
    private Long id;


    @Column(name = "locale")
    private String locale;

    @Column(name = "message")
    private String message;


    @Column(name = "updated")
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    protected Date updated;

    public Date getupdated() {
        return updated;
    }

    public void setupdated(Date updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
