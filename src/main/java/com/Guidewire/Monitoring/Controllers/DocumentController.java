package com.Guidewire.Monitoring.Controllers;

import com.Guidewire.Monitoring.Entities.Progress;
import com.Guidewire.Monitoring.Services.Implementations.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
@CrossOrigin
@Controller
@RequestMapping("document")
public class DocumentController {
    @Autowired
    DocumentService documentService;
    @GetMapping("/getAll/pageNumber={pageNumber}&pageSize={pageSize}")
    public ResponseEntity<?> getlogs(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(documentService.getDocuments(pageNumber,pageSize));
    }
    @GetMapping("/get/id={id}")
    public  ResponseEntity<?> getLog(@PathVariable String id){
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }
    @GetMapping("get/Numbers/start={start}&end={end}")
    public  ResponseEntity<?> getNumbers(@PathVariable String start,@PathVariable String end) throws ParseException {
        return ResponseEntity.ok(documentService.getNumbersByCenter(start,end));
    }
    @GetMapping("get/GW_ID={id}")
    public  ResponseEntity<?> getDocumentsByGWLinkedObject(@PathVariable String id){
        return ResponseEntity.ok(documentService.getDocumentsByGWLinkedObject(id));
    }
    @GetMapping("get/service={service}")
    public  ResponseEntity<?> getDocumentsByService(@PathVariable String service){
        return ResponseEntity.ok(documentService.getDocumentsByService(service));
    }
    @GetMapping("get/status={status}")
    public  ResponseEntity<?> getDocumentsByStatus(@PathVariable Progress status){
        return ResponseEntity.ok(documentService.getDocumentsByStatus(status));
    }
    @GetMapping("get/all/pageNumber={pageNumber}&pageSize={pageSize}")
    public ResponseEntity<?> getDocuments(@PathVariable int pageNumber,@PathVariable int pageSize){
        return ResponseEntity.ok(documentService.getDocuments(pageNumber,pageSize));
    }


    @GetMapping("/documents/count-by-date")
    public Map<String, Map<String, Integer>> getDocumentCountsByDate(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) throws ParseException {
        return documentService.getNumbersByCenter(startDate, endDate);
    }

}

