package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Log;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.Guidewire.Monitoring.Repositories.TransportPluginRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_TransportPlugin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransportPluginService implements I_TransportPlugin {
    @Autowired
    TransportPluginRepo transportPluginRepo;
    @Autowired
    LogService logService;
    public Map<Integer,String> getDocumentName(TransportPlugin transportPlugin) throws JsonProcessingException {
        String attributes=logService.getAttributes(transportPlugin.getContent());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode attributesJson = objectMapper.readTree(attributes);
        JsonNode documentName=attributesJson.get("contextMap").get("documentName: ");
        Map<Integer, String> map = new HashMap<>();
        documentName.fields().forEachRemaining(entry -> {
            map.put(Integer.parseInt(entry.getKey()), entry.getValue().asText());
        });
        return map;
    }
    public Map<Integer,String> getGwLinkedObject(TransportPlugin transportPlugin) throws JsonProcessingException {
        String attributes=logService.getAttributes(transportPlugin.getContent());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode attributesJson = objectMapper.readTree(attributes);
        JsonNode documentName=attributesJson.get("contextMap").get("gwLinkedObject: ");
        Map<Integer, String> map = new HashMap<>();
        documentName.fields().forEachRemaining(entry -> {
            map.put(Integer.parseInt(entry.getKey()), entry.getValue().asText());
        });
        return map;
    }
    public Map<Integer,String> getDocumentTemplate(TransportPlugin transportPlugin) throws JsonProcessingException {
        String attributes=logService.getAttributes(transportPlugin.getContent());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode attributesJson = objectMapper.readTree(attributes);
        JsonNode documentName=attributesJson.get("contextMap").get("documentTemplate: ");
        Map<Integer, String> map = new HashMap<>();
        documentName.fields().forEachRemaining(entry -> {
            map.put(Integer.parseInt(entry.getKey()), entry.getValue().asText());
        });
        return map;
    }
    public Map<Integer,String> getPublicID(TransportPlugin transportPlugin) throws JsonProcessingException {
        String attributes=logService.getAttributes(transportPlugin.getContent());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode attributesJson = objectMapper.readTree(attributes);
        JsonNode documentId=attributesJson.get("contextMap").get("documentId: ");
        Map<Integer, String> map = new HashMap<>();
        documentId.fields().forEachRemaining(entry -> {
            map.put(Integer.parseInt(entry.getKey()), entry.getValue().asText());
        });
        if (map.get(1)==null){
            map.put(1,documentId.asText());
        }
        return map;
    }
    public String getDeliveryMode(TransportPlugin transportPlugin) throws JsonProcessingException{
        String attributes=logService.getAttributes(transportPlugin.getContent());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode attributesJson = objectMapper.readTree(attributes);
        return attributesJson.get("contextMap").get("deliveryMode: ").toString();
    }
    public TransportPlugin createLog(Log log) throws JsonProcessingException {
        TransportPlugin TLog= new TransportPlugin();
        TLog.setId(log.getId());
        TLog.setContent(log.getContent());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonContent = objectMapper.readTree(log.getContent());
        TLog.setStatus(logService.isRequest(jsonContent));
        return transportPluginRepo.save(TLog);
    }
    
}
