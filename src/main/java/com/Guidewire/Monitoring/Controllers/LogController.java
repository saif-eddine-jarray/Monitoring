package com.Guidewire.Monitoring.Controllers;

import com.Guidewire.Monitoring.Services.Implementations.LogCreationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;


@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    LogCreationService logCreationService;

    @PostMapping("/add")
    public ResponseEntity<?> addLog(@RequestBody Object log) throws JsonProcessingException, ParseException {
        return ResponseEntity.ok(logCreationService.createLog(log));
    }


}


