package com.Guidewire.Monitoring.Controllers;

import com.Guidewire.Monitoring.Services.Implementations.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

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
    @GetMapping("get/Numbers")
    public  ResponseEntity<?> getNumbers(@RequestBody Time time) throws ParseException {
        return ResponseEntity.ok(documentService.getNumbersByCenter(time.getStart(),time.getEnd()));
    }
    @GetMapping("get/GW_ID={id}")
    public  ResponseEntity<?> getDocumentsByGWLinkedObject(@PathVariable String id){
        return ResponseEntity.ok(documentService.getDocumentsByGWLinkedObject(id));
    }
    static class Time {
        String start;
        String end;

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }
    }
}

