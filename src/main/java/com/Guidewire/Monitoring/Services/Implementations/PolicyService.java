package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Policy;
import com.Guidewire.Monitoring.Repositories.PolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
    @Autowired
    PolicyRepo policyRepo;
    public Policy createPolicy(String id){
        Policy policy=new Policy();
        policy.setId(id);
        return policyRepo.save(policy);
    }
}
