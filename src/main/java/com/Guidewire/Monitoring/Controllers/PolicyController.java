package com.Guidewire.Monitoring.Controllers;


import com.Guidewire.Monitoring.Entities.Policy;
import com.Guidewire.Monitoring.Services.Implementations.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable String id) {
        return policyService.getPolicyById(id);
    }

}
