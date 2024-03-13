package com.Guidewire.Monitoring.Entities.Log;

import jakarta.persistence.Entity;

@Entity
public class TransportPlugin extends Log{
    Boolean status=false;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TransportPlugin(String id, String content, Boolean status) {
        super(id, content);
        this.status = status;
    }

    public TransportPlugin() {

    }
}
