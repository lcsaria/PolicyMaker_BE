package com.norima.policy_admin_system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.norima.policy_admin_system.model.PolicyHolder;

@Repository
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Long> {

}
