package com.neelav.OmnicurisAssignment.service;

import com.neelav.OmnicurisAssignment.exceptions.ProductNotFoundException;
import com.neelav.OmnicurisAssignment.models.Product;
import com.neelav.OmnicurisAssignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllItems() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        Optional<Product> product=productRepository.findById(id);

        if(product.isPresent())
            return product.get();

        else
            throw new ProductNotFoundException("Product Does not Exist !");
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(int id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent())
        {
            productRepository.delete(product.get());
            return "Product Successfully Deleted";
        }
        else
            throw new ProductNotFoundException("Product Does not Exist to be Deleted !");

    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> updateProduct = productRepository.findById(product.getId());

        if(updateProduct.isPresent()) {
            return productRepository.save(product);
        }
        else
            throw new ProductNotFoundException("The Product you are Trying to Update does not Exist !");
    }
}
