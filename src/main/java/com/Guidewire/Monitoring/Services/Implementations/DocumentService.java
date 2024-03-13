package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Document;
import com.Guidewire.Monitoring.Entities.Progress;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.Guidewire.Monitoring.Repositories.AccountRepo;
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
    @Autowired
    PolicyService policyService;
    @Autowired
    SubmissionService submissionService;
    @Autowired
    AccountService accountService;
    public void createDocument(TransportPlugin transportPlugin) throws JsonProcessingException {
        transportPluginService.getDocumentName(transportPlugin).forEach((key, value) -> {
            Document document=new Document();
            document.setName(value);
            try {
                System.out.println(key+" : "+value);
                System.out.println(transportPluginService.getPublicID(transportPlugin).get(key));
                document.setPublicID(transportPluginService.getPublicID(transportPlugin).get(key));
                document.setDocumentTemplate(transportPluginService.getDocumentTemplate(transportPlugin).get(key));
                String linkedObjectID=transportPluginService.getGwLinkedObject(transportPlugin).get(key);
                document.setGwLinkedObject(transportPluginService.getGwLinkedObject(transportPlugin).get(key));
                if(linkedObjectID.startsWith("BE")){
                    policyService.createPolicy(linkedObjectID);
                } else if (linkedObjectID.startsWith("000")) {
                    submissionService.createSubmission(linkedObjectID);
                }else{
                    accountService.createAccount(linkedObjectID);
                }
                document.setDeliveryMode(transportPluginService.getDeliveryMode(transportPlugin));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            document.setProgress(Progress.Generated);
            documentRepo.save(document);
        });
    }
}
