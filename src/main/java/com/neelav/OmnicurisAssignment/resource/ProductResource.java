package com.neelav.OmnicurisAssignment.resource;


import com.neelav.OmnicurisAssignment.exceptions.ProductNotFoundException;
import com.neelav.OmnicurisAssignment.models.Product;
import com.neelav.OmnicurisAssignment.repository.ProductRepository;
import com.neelav.OmnicurisAssignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductResource {

    /*@Autowired
    private ProductRepository productRepository;*/

    @Autowired
    private ProductService productService;


    @GetMapping("/hello")
    public String getHello()
    {
        return "Hello World";
    }

    @GetMapping("/all")
    public List<Product> getAllItems()
    {
        return productService.getAllItems();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id)
    {
        return productService.getProduct(id);
    }

    @PostMapping("/products/")
    public Product createProduct(@RequestBody Product product)
    {

        return productService.createProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return productService.deleteProduct(id);

    }


    @PutMapping("/products/")
    public Product updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }
}
