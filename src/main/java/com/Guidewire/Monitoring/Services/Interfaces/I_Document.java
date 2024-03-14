package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Document;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface I_Document {
    void createDocument(TransportPlugin transportPlugin) throws JsonProcessingException;
    List<Document> getDocuments(int pageNumber, int pageSize);
    Map<String,int[]> getNumbersByCenter(String start, String end) throws ParseException;
    List<Document> getDocumentsByGWLinkedObject(String id);
    Document getDocumentById(String id);
}
