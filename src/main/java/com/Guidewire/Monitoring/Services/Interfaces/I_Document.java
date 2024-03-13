package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Log.Document;
import com.Guidewire.Monitoring.Entities.Log.TransportPlugin;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface I_Document {
    void createDocument(TransportPlugin transportPlugin) throws JsonProcessingException;
}
