package com.Guidewire.Monitoring.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Submission {
    @Id
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
