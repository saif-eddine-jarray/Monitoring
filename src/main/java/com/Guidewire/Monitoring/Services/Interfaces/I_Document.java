package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Document;
import com.Guidewire.Monitoring.Entities.Progress;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface I_Document {
    void createOutboundDocument(TransportPlugin transportPlugin) throws JsonProcessingException;
    List<Document> getDocuments(int pageNumber, int pageSize);
    List<Document> getDocumentsByGWLinkedObject(String id);
    List<Document> getDocumentsByService(String Service);
    List<Document> getDocumentsByStatus(Progress status);
    Document getDocumentById(String id);
    void setDeliver(TransportPlugin transportPlugin) throws JsonProcessingException;
}
