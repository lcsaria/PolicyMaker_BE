package com.example.policy_admin_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.policy_admin_system.model.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Long> {

    List<CustomerAccount> findByFirstNameAndLastName(String firstName, String lastName);
    List<CustomerAccount> findByAccountNumber(String customerAccount);
}
