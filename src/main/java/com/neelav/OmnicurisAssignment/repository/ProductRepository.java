package com.neelav.OmnicurisAssignment.repository;

import com.neelav.OmnicurisAssignment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
