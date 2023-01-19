package com.norima.policy_admin_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.norima.policy_admin_system.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByClaimNumber(Claim claim);
}
