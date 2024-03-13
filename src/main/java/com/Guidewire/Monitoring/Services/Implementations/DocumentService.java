package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Log.Document;
import com.Guidewire.Monitoring.Entities.Log.Progress;
import com.Guidewire.Monitoring.Entities.Log.TransportPlugin;
import com.Guidewire.Monitoring.Repositories.DocumentRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService implements I_Document {
    @Autowired
    DocumentRepo documentRepo;
    @Autowired
    TransportPluginService transportPluginService;
    public void createDocument(TransportPlugin transportPlugin) throws JsonProcessingException {
        transportPluginService.getDocumentName(transportPlugin).forEach((key, value) -> {
            Document document=new Document();
            document.setName(value);
            try {
                document.setPublicID(transportPluginService.getPublicID(transportPlugin).get(key));
                document.setDocumentTemplate(transportPluginService.getDocumentTemplate(transportPlugin).get(key));
                document.setGwLinkedObject(transportPluginService.getGwLinkedObject(transportPlugin).get(key));
                document.setDeliveryMode(transportPluginService.getDeliveryMode(transportPlugin));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            document.setProgress(Progress.Generated);
            documentRepo.save(document);
        });
    }
}
