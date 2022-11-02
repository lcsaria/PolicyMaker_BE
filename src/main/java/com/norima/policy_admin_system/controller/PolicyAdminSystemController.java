package com.norima.policy_admin_system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.norima.policy_admin_system.model.CustomerAccount;
import com.norima.policy_admin_system.model.Policy;
import com.norima.policy_admin_system.model.PolicyHolder;
import com.norima.policy_admin_system.model.Vehicle;
import com.norima.policy_admin_system.repository.CustomerAccountRepository;
import com.norima.policy_admin_system.repository.PolicyHolderRepository;
import com.norima.policy_admin_system.repository.PolicyRepository;
import com.norima.policy_admin_system.repository.VehicleRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class PolicyAdminSystemController {

   @Autowired
   private CustomerAccountRepository customerAccountRepository;

   @Autowired
   private PolicyRepository policyRepository;

   @Autowired
   private PolicyHolderRepository policyHolderRepository;

   @Autowired
   private VehicleRepository vehicleRepository;

   // create customer account
   @PostMapping("/customer_account")
   public CustomerAccount createCustomerAccount(@RequestBody CustomerAccount customerAccount) {
      System.out.println(customerAccount);
      return customerAccountRepository.save(customerAccount);
   }

   // search customer account
   @PostMapping("/customer_account/search")
   public ResponseEntity<List<CustomerAccount>> getCustomerAccountByFirstNameAndLastName(
         @RequestBody CustomerAccount customerAccount) {
      List<CustomerAccount> result = customerAccountRepository
            .findByFirstNameAndLastName(customerAccount.getFirstName(), customerAccount.getLastName());
      if (result.isEmpty()) {
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      } else {
         return new ResponseEntity<>(result, HttpStatus.OK);
      }
   }

   // search account number
   @PostMapping("/customer_account/searchID")
   public ResponseEntity<List<CustomerAccount>> getCustomerAccountByAccountNumber(
         @RequestBody CustomerAccount customerAccount) {
      List<CustomerAccount> result = customerAccountRepository.findByAccountNumber(customerAccount.getAccountNumber());
      if (result.isEmpty()) {
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      } else {
         return new ResponseEntity<>(result, HttpStatus.OK);
      }
   }

   // create policy
   @PostMapping("/policy")
   public Policy createPolicy(@RequestBody Policy policy) {
      return policyRepository.save(policy);
   }

   // create policy holder
   @PostMapping("/policyHolder")
   public PolicyHolder createPolicyHolder(@RequestBody PolicyHolder policyHolder) {
      return policyHolderRepository.save(policyHolder);
   }

   // create vehicles
   @PostMapping("/vehicles")
   public ResponseEntity<List<Vehicle>> createVehicle(@RequestBody List<Vehicle> vehicle) {

      if (vehicle.get(0).getPolicyNumber() == "") {
         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      } else {
         // for each vehicle
         for (Vehicle e : vehicle) {
            vehicleRepository.save(e);
         }
         return new ResponseEntity<>(null, HttpStatus.OK);
      }
   }

   /*
    * response:
    * policyNo: ******,
    * policy: {
    * .....
    * },
    * holder: {
    * .....
    * }
    */
   @PostMapping("/policy/search")
   public ResponseEntity<?> getPolicyFromPolicyNumber(@RequestBody Policy policy) {
      List<Policy> pInfo = policyRepository.findByPolicyNumber(policy.getPolicyNumber());
      List<PolicyHolder> holder = policyHolderRepository.findByPolicyNumber(policy.getPolicyNumber());
      List<Vehicle> vList = vehicleRepository.findByPolicyNumber(policy.getPolicyNumber());

      Map<String, Object> result = new HashMap<String, Object>();

      result.put("policy", pInfo);
      result.put("policyHolder", holder);
      result.put("vehicle", vList);

      if (result.isEmpty()) {
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
      } else {
         return new ResponseEntity<>(result, HttpStatus.OK);
      }
   }
}
