package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Document;
import com.Guidewire.Monitoring.Entities.Progress;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.Guidewire.Monitoring.Repositories.AccountRepo;
import com.Guidewire.Monitoring.Repositories.DocumentRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        transportPluginService.getPublicID(transportPlugin).forEach((key, value) -> {
            Document document=new Document();
            document.setPublicID(value);
            try {
                document.setName(transportPluginService.getDocumentName(transportPlugin).get(key));
                document.setDocumentTemplate(transportPluginService.getDocumentTemplate(transportPlugin).get(key));
                String linkedObjectID=transportPluginService.getGwLinkedObject(transportPlugin).get(key);
                document.setGwLinkedObject(linkedObjectID);
                if(linkedObjectID.startsWith("BE")){
                    policyService.createPolicy(linkedObjectID);
                } else if (linkedObjectID.startsWith("000")) {
                    submissionService.createSubmission(linkedObjectID);
                }else{
                    accountService.createAccount(linkedObjectID);
                }
                document.setDeliveryMode(transportPluginService.getDeliveryMode(transportPlugin));
                document.setService(transportPluginService.getService(transportPlugin.getContent()));
                LocalDateTime localDateTime = LocalDateTime.parse(transportPluginService.getTimeStamp(transportPlugin.getContent()), DateTimeFormatter.ISO_DATE_TIME);
                Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                document.setTimestamp(date);
            } catch (JsonProcessingException | ParseException e) {
                throw new RuntimeException(e);
            }
            document.setProgress(Progress.Generated);
            documentRepo.save(document);
        });
    }

    @Override
    public List<Document> getDocuments(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return documentRepo.findAll(pageable).getContent();
    }

    @Override
    public Map<String, int[]> getNumbersByCenter(String start, String end) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
         Date s=dateFormat.parse(start);
         Date e=dateFormat.parse(end);
        List<Document> documents=documentRepo.findByTimestampBetween(s,e);
        Map<String,int[]> map= new HashMap<>();
        int[] lp = {0,0,0};
        int[] lb = {0,0,0};
        int[] lc = {0,0,0};
        for(Document doc : documents){
            switch (doc.getService()) {
                case "PolicyCenter":
                    numbersGenerator(lp, doc);
                    break;
                case "BillingCenter":
                    numbersGenerator(lb, doc);
                    break;
                case "ClaimCenter":
                    numbersGenerator(lc, doc);
                    break;
            }
        }
        map.put("policy",lp);
        map.put("claim",lc);
        map.put("billing",lb);
        return map;
    }
    private void numbersGenerator(int[] lp, Document doc) {
        switch (doc.getProgress()){
            case Generated:
                lp[0]++;
                break;
            case Archived:
                lp[2]++;
                break;
            case Delivired:
                lp[1]++;
                break;
        }
    }
    @Override
    public List<Document> getDocumentsByGWLinkedObject(String id) {
        return documentRepo.findDocumentsByGwLinkedObject(id);
    }
    @Override
    public Document getDocumentById(String id) {
        return documentRepo.findById(id).get();
    }
}
