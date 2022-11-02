package com.norima.policy_admin_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.norima.policy_admin_system.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByPolicyNumber(String policy);
}
