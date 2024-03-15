package com.Guidewire.Monitoring.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity

public class Document {
    @Id
    String publicID;
    String docUID;
    String cabinetID;
    String  author;
    String createTime;
    Boolean inbound;
    String name;
    String deliveryMode;
    String documentTemplate;
    String productionSystem;
    String gwLinkedObject;
    String rejectionReason;
    String securityType;
    String status;
    String signatureMethod;
    Boolean signed;
    String service;
    String updatetime;

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    Progress progress;
    Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Document() {
    }

    public String getPublicID() {
        return publicID;
    }

    public void setPublicID(String publicID) {
        this.publicID = publicID;
    }

    public String getDocUID() {
        return docUID;
    }

    public void setDocUID(String docUID) {
        this.docUID = docUID;
    }

    public String getCabinetID() {
        return cabinetID;
    }

    public void setCabinetID(String cabinetID) {
        this.cabinetID = cabinetID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Boolean getInbound() {
        return inbound;
    }

    public void setInbound(Boolean inbound) {
        this.inbound = inbound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getDocumentTemplate() {
        return documentTemplate;
    }

    public void setDocumentTemplate(String documentTemplate) {
        this.documentTemplate = documentTemplate;
    }

    public String getProductionSystem() {
        return productionSystem;
    }

    public void setProductionSystem(String productionSystem) {
        this.productionSystem = productionSystem;
    }

    public String getGwLinkedObject() {
        return gwLinkedObject;
    }

    public void setGwLinkedObject(String gwLinkedObject) {
        this.gwLinkedObject = gwLinkedObject;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSignatureMethod() {
        return signatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }
}
