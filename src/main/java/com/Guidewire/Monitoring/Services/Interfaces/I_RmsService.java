package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Document;
import com.Guidewire.Monitoring.Entities.Log;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface I_RmsService {
    Document updateDocumentData(Log log) throws JsonProcessingException;
}
