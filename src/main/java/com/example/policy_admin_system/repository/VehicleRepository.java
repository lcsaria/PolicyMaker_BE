package com.example.policy_admin_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.policy_admin_system.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
