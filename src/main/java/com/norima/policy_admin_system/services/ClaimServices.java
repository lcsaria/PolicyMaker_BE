package com.norima.policy_admin_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norima.policy_admin_system.model.Claim;
import com.norima.policy_admin_system.repository.ClaimRepository;

@Service
public class ClaimServices {
    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> findClaim(Claim claim) {
        return claimRepository.findByClaimNumber(claim);
    }
}
