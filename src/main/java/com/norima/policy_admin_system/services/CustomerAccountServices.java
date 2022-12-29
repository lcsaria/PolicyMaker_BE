package com.norima.policy_admin_system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.norima.policy_admin_system.model.CustomerAccount;
import com.norima.policy_admin_system.repository.CustomerAccountRepository;

@Service
public class CustomerAccountServices {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    public CustomerAccount createAccount(CustomerAccount customerAccount) {
        return customerAccountRepository.save(customerAccount);
    }

    public List<CustomerAccount> getCustomerAccountByFirstNameAndLastName(CustomerAccount customerAccount) {
        return customerAccountRepository
                .findByFirstNameAndLastName(customerAccount.getFirstName(), customerAccount.getLastName());
    }
    
    public List<CustomerAccount> getCustomerAccountByAccountNumber(CustomerAccount customerAccount){
        return customerAccountRepository
                .findByAccountNumber(customerAccount.getAccountNumber());
    }

}
