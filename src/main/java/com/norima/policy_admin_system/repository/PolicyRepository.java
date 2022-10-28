package com.norima.policy_admin_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.norima.policy_admin_system.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByPolicyNumber(String policy);
}
