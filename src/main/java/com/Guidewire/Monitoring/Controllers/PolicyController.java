package com.Guidewire.Monitoring.Controllers;


import com.Guidewire.Monitoring.Entities.Account;
import com.Guidewire.Monitoring.Entities.Policy;
import com.Guidewire.Monitoring.Services.Implementations.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;



    @GetMapping("/getAll")
    public ResponseEntity<Page<Policy>> getAllPolicies(@RequestParam(defaultValue = "0") int pageNumber,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Policy> policies = policyService.getAllPolicies(pageable);
        return ResponseEntity.ok(policies);
    }


    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable String id) {
        return policyService.getPolicyById(id);
    }

}
