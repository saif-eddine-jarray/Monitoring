package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Repositories.LogRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class LogService implements I_Log {
    @Autowired
    LogRepo logRepo;


    public String getTimestamp(String content) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(content);
        return contentJson.get("timestamp").toString();
    }

    public String getHost(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(content);
        return contentJson.get("host").toString();
    }

    public LocalDateTime getService(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(content);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss.SSSX");
        LocalDateTime timestamp = LocalDateTime.parse(contentJson.get("service").toString(), formatter);
        return timestamp;
    }

    public String getMessage(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(content);
        return contentJson.get("message").toString();
    }

    public String getAttributes(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(content);
        return contentJson.get("attributes").toString();
    }
    public String getLoggerFcn(String attributes) throws  JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(attributes);
        return contentJson.get("loggerName").toString();
    }
    public Boolean isRequest(JsonNode content){
        String status=content.get("message").toString().substring(39,39+7);
        return Objects.equals(status,"Request");
    }
}
