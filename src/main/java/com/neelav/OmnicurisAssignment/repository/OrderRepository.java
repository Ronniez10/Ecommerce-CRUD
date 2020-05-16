package com.neelav.OmnicurisAssignment.repository;

import com.neelav.OmnicurisAssignment.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
