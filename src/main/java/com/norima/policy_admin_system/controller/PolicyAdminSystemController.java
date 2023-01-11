package com.norima.policy_admin_system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.norima.policy_admin_system.model.Claim;
import com.norima.policy_admin_system.model.CustomerAccount;
import com.norima.policy_admin_system.model.Policy;
import com.norima.policy_admin_system.model.PolicyHolder;
import com.norima.policy_admin_system.model.Vehicle;
import com.norima.policy_admin_system.repository.ClaimRepository;
import com.norima.policy_admin_system.repository.CustomerAccountRepository;
import com.norima.policy_admin_system.repository.PolicyHolderRepository;
import com.norima.policy_admin_system.repository.PolicyRepository;
import com.norima.policy_admin_system.repository.VehicleRepository;
import com.norima.policy_admin_system.services.CustomerAccountServices;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PolicyAdminSystemController {
   @Autowired
   private CustomerAccountServices customerAccountService;

   @Autowired
   private PolicyRepository policyRepository;

   @Autowired
   private PolicyHolderRepository policyHolderRepository;

   @Autowired
   private VehicleRepository vehicleRepository;

   @Autowired
   private ClaimRepository claimRepository;

   // create customer account
   @PostMapping("/customer_account")
   public CustomerAccount createCustomerAccount(@RequestBody CustomerAccount customerAccount) {
      return customerAccountService.createAccount(customerAccount);
   }

   // search customer account
   @PostMapping("/customer_account/search")
   public ResponseEntity<List<CustomerAccount>> getCustomerAccountByFirstNameAndLastName(
         @RequestBody CustomerAccount customerAccount) {

      try {
         List<CustomerAccount> result = customerAccountService
               .getCustomerAccountByFirstNameAndLastName(customerAccount);
         if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
         }
      } catch (Exception e) {
         return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
      }
   }

   // search account number
   @PostMapping("/customer_account/searchID")
   public ResponseEntity<List<CustomerAccount>> getCustomerAccountByAccountNumber(
         @RequestBody CustomerAccount customerAccount) {
      try {
         List<CustomerAccount> result = customerAccountService
                 .getCustomerAccountByAccountNumber(customerAccount);
         
         if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
         }
      } catch (Exception e) {
         return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
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
      try {
         if (vehicle.get(0).getPolicyNumber() == "") {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         } else {
            // for each vehicle
            for (Vehicle e : vehicle) {
               vehicleRepository.save(e);
            }
            return new ResponseEntity<>(null, HttpStatus.OK);
         }
      } catch (Exception e) {
         return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
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
    * vehicles: {
    * .....
    * }
    */
   @PostMapping("/policy/search")
   public ResponseEntity<?> getPolicyFromPolicyNumber(@RequestBody Policy policy) {
      try {
         List<Policy> pInfo = policyRepository.findByPolicyNumber(policy.getPolicyNumber());
         List<PolicyHolder> holder = policyHolderRepository.findByPolicyNumber(policy.getPolicyNumber());
         List<Vehicle> vList = vehicleRepository.findByPolicyNumber(policy.getPolicyNumber());

         Map<String, Object> result = new HashMap<String, Object>();
         result.put("policy", pInfo.get(0));
         result.put("holder", holder.get(0));
         result.put("vehicle", vList);
         if (pInfo.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
         }
      } catch (Exception e) {
         System.out.println(e);
         return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
      }
   }

   // cancel policy
   @PostMapping("/policy/cancel")
   public ResponseEntity<?> cancelPolicy(@RequestBody Policy policy) {
      try {
         List<Policy> updatePolicy = policyRepository.findByPolicyNumber(policy.getPolicyNumber());

         if (updatePolicy.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
         } else {
            updatePolicy.get(0).setStatus(0);
            Policy updatedPolicy = policyRepository.save(updatePolicy.get(0));
            return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
         }

      } catch (Exception e) {
         System.out.println(e);
         return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
      }
   }

   // file claim

   @PostMapping("/claim")
   public Claim fileClaim(@RequestBody Claim claim) {
      return claimRepository.save(claim);
   }
}
