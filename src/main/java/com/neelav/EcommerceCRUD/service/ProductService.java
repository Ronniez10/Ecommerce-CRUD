package com.neelav.EcommerceCRUD.service;

import com.neelav.EcommerceCRUD.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllItems();

    Product getProduct(int id);

    Product createProduct( Product product);

    String deleteProduct( int id);

    Product updateProduct( Product product);
}
