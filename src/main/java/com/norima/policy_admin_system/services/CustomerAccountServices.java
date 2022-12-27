package com.norima.policy_admin_system.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.norima.policy_admin_system.model.CustomerAccount;
import com.norima.policy_admin_system.repository.CustomerAccountRepository;

public class CustomerAccountServices {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    public CustomerAccount createAccount(CustomerAccount customerAccount) {
        return customerAccountRepository.save(customerAccount);
    }

}
