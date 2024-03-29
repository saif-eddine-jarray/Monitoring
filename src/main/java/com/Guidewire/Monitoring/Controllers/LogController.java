package com.Guidewire.Monitoring.Controllers;

import com.Guidewire.Monitoring.Entities.Log;
import com.Guidewire.Monitoring.Entities.TransportPlugin;
import com.Guidewire.Monitoring.Services.Implementations.DocumentService;
import com.Guidewire.Monitoring.Services.Implementations.LogCreationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin
@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    LogCreationService logCreationService;

    @PostMapping("/add")
    public ResponseEntity<?> addLog(@RequestBody Object log) throws JsonProcessingException, ParseException {
        return ResponseEntity.ok(logCreationService.createLog(log));
    }
    @GetMapping("/get/id={id}")
    public  ResponseEntity<?> getLog(@PathVariable String id){
        return ResponseEntity.ok(logCreationService.getLog(id));
    }

}


