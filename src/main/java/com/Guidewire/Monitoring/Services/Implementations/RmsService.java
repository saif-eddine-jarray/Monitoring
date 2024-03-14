package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Document;
import com.Guidewire.Monitoring.Entities.Log;
import com.Guidewire.Monitoring.Entities.Progress;
import com.Guidewire.Monitoring.Repositories.DocumentRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_RmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RmsService implements I_RmsService {
    @Autowired
    DocumentRepo documentRepo;
    @Override
    public Document updateDocumentData(Log log) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode contentJson = objectMapper.readTree(log.getContent());
        String message= contentJson.get("message").toString();
        String messageStructured=message.substring(36,message.length()-85);
        String message1=messageStructured.replaceAll("=", "\":\"")
                .replaceAll(", ", "\", \"")
                .replaceAll("\\{", "{\"")
                .replaceAll("\\}", "\"}");
        JsonNode messageJson=objectMapper.readTree(message1);
        String publicID= messageJson.get("PublicID").toString();
        Document document=documentRepo.findById(publicID.substring(1,publicID.length()-1)).get();
        document.setAuthor(messageJson.get("Author").toString());
        document.setCabinetID(messageJson.get("CabinetID_Ext").toString());
        document.setDocUID(messageJson.get("DocUID").toString());
        document.setProductionSystem(messageJson.get("ProductionSystem_Ext").toString());
        document.setStatus(messageJson.get("Status").toString());
        document.setSecurityType(messageJson.get("SecurityType").toString());
        document.setSignatureMethod(messageJson.get("SignatureMethod_Ext").toString());
        document.setCreateTime(messageJson.get("CreateTime").toString());
        document.setUpdatetime(messageJson.get("UpdateTime").toString());
        document.setSigned(Boolean.parseBoolean(messageJson.get("Signed_Ext").toString()));
        document.setRejectionReason(messageJson.get("RejectionReason_Ext").toString());
        document.setInbound(Boolean.parseBoolean(messageJson.get("Inbound").toString()));
        document.setProgress(Progress.Archived);
        return documentRepo.save(document);
    }
}
