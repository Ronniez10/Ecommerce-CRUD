package com.neelav.EcommerceCRUD.resource;


import com.neelav.EcommerceCRUD.models.Product;
import com.neelav.EcommerceCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
