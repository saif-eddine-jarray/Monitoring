package com.Guidewire.Monitoring.Services.Implementations;

import com.Guidewire.Monitoring.Entities.Policy;
import com.Guidewire.Monitoring.Repositories.PolicyRepo;
import com.Guidewire.Monitoring.Services.Interfaces.I_Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyService implements I_Policy {
    @Autowired
    PolicyRepo policyRepo;


    @Override
    public Policy createPolicy(String id){
        Policy policy=new Policy();
        policy.setId(id);
        return policyRepo.save(policy);
    }

    @Override
    public Page<Policy> getAllPolicies(Pageable pageable) {
        return policyRepo.findAll(pageable);
    }

    @Override
    public Policy getPolicyById(String id) {
        Optional<Policy> optionalPolicy = policyRepo.findById(id);
        return optionalPolicy.orElse(null);
    }







}
