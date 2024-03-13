package com.Guidewire.Monitoring.Services.Interfaces;

import com.Guidewire.Monitoring.Entities.Policy;

import java.util.List;

public interface I_Policy {


    Policy createPolicy(String id);

    List<Policy> getAllPolicies();

    Policy getPolicyById(String id);
}
