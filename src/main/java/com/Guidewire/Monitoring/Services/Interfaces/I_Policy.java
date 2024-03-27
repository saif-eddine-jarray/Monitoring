package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Policy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface I_Policy {


    Policy createPolicy(String id);


    Page<Policy> getAllPolicies(Pageable pageable);

    Policy getPolicyById(String id);
}
