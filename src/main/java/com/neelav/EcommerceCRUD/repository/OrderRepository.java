package com.neelav.EcommerceCRUD.repository;

import com.neelav.EcommerceCRUD.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
