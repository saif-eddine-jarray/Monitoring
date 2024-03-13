package com.Guidewire.Monitoring.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity

public class Document {
    @Id
    String PublicID;
    String DocUID;
    String CabinetID;
    String Author;
    String CreateTime;
    Boolean Inbound;
    String Name;
    String DeliveryMode;
    String DocumentTemplate;
    String ProductionSystem;
    String GwLinkedObject;
    String RejectionReason;
    String SecurityType;
    String Status;
    String SignatureMethod;
    Boolean Signed;

    Progress progress;

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Document() {
    }

    public String getPublicID() {
        return PublicID;
    }

    public void setPublicID(String publicID) {
        PublicID = publicID;
    }

    public String getDocUID() {
        return DocUID;
    }

    public void setDocUID(String docUID) {
        DocUID = docUID;
    }

    public String getCabinetID() {
        return CabinetID;
    }

    public void setCabinetID(String cabinetID) {
        CabinetID = cabinetID;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public Boolean getInbound() {
        return Inbound;
    }

    public void setInbound(Boolean inbound) {
        Inbound = inbound;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDeliveryMode() {
        return DeliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        DeliveryMode = deliveryMode;
    }

    public String getDocumentTemplate() {
        return DocumentTemplate;
    }

    public void setDocumentTemplate(String documentTemplate) {
        DocumentTemplate = documentTemplate;
    }

    public String getProductionSystem() {
        return ProductionSystem;
    }

    public void setProductionSystem(String productionSystem) {
        ProductionSystem = productionSystem;
    }

    public String getGwLinkedObject() {
        return GwLinkedObject;
    }

    public void setGwLinkedObject(String gwLinkedObject) {
        GwLinkedObject = gwLinkedObject;
    }

    public String getRejectionReason() {
        return RejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        RejectionReason = rejectionReason;
    }

    public String getSecurityType() {
        return SecurityType;
    }

    public void setSecurityType(String securityType) {
        SecurityType = securityType;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSignatureMethod() {
        return SignatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        SignatureMethod = signatureMethod;
    }

    public Boolean getSigned() {
        return Signed;
    }

    public void setSigned(Boolean signed) {
        Signed = signed;
    }
}
