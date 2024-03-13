package com.Guidewire.Monitoring.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    String id;

    String content;

    public Log(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public Log() {

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}


