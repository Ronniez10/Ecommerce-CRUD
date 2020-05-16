package com.neelav.OmnicurisAssignment.service;

import com.neelav.OmnicurisAssignment.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    List<Product> getAllItems();

    Product getProduct(int id);

    Product createProduct( Product product);

    String deleteProduct( int id);

    Product updateProduct( Product product);
}
