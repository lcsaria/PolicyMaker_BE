package com.norima.policy_admin_system.services;

import com.norima.policy_admin_system.model.Policy;
import com.norima.policy_admin_system.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyServices {

    @Autowired
    private PolicyRepository policyRepository;

    public Policy create(Policy policy){
        return policyRepository.save(policy);
    }
}
