package com.neelav.EcommerceCRUD.repository;

import com.neelav.EcommerceCRUD.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
