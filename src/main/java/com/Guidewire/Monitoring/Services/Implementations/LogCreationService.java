package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Log;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.Guidewire.Monitoring.Repositories.LogRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Objects;

@Service
public class LogCreationService {
    @Autowired
    LogRepo logRepo;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    LogService logService;
    @Autowired
    DocumentService documentService;
    @Autowired
    TransportPluginService transportPluginService;
    @Autowired
    RmsService rmsService;
    public Log createLog(Object log) throws JsonProcessingException, ParseException {
        JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(log));
        String id = jsonNode.get("id").asText();
        JsonNode jsonContent=jsonNode.get("content");
        String content = jsonContent.toString();
        Log newLog= new Log();
        newLog.setId(id);
        newLog.setContent(content);
        String loggerFcn=logService.getLoggerFcn(logService.getAttributes(content));
        String name="Messaging.DocProdRequestTransport";
        String logger = loggerFcn.substring(1,loggerFcn.length()-1);
        if(logger.equals(name) || logger.equals("Messaging.st.pc.integration.DocumentProduction.plugin.impl.DocProdRequestTransport")){
            TransportPlugin transportPlugin=transportPluginService.createLog(newLog);
            if(logService.isRequest(jsonContent)){
                documentService.createOutboundDocument(transportPlugin);
            }else if (Objects.equals(logService.getLevel(logService.getAttributes(newLog.getContent())), "INFO")){
                documentService.setDeliver(transportPlugin);
            }else if (Objects.equals(logService.getLevel(logService.getAttributes(newLog.getContent())), "ERROR")){
                documentService.setError(transportPlugin);
            }
            return transportPlugin;
        }else if(logger.equals("Api.st.pc.integration.UpdatemetadataforDocuments.DocumentsAPIHandler")) {
            rmsService.updateDocumentData(newLog);
        }
        return logRepo.save(newLog);
    }
    public Log getLog(String id){
        Log log=logRepo.findById(id).get();
        TransportPlugin transportPlugin= (TransportPlugin) log;
        System.out.println(transportPlugin.getRequestID());
        return logRepo.findById(id).get();
    }
}
