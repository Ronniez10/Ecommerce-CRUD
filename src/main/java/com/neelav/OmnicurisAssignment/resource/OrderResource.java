package com.neelav.OmnicurisAssignment.resource;

import com.neelav.OmnicurisAssignment.exceptions.OrderQuantityExceedingStocks;
import com.neelav.OmnicurisAssignment.exceptions.OutOfStockException;
import com.neelav.OmnicurisAssignment.exceptions.ProductNotFoundException;
import com.neelav.OmnicurisAssignment.exceptions.ZeroQuantityOrderException;
import com.neelav.OmnicurisAssignment.models.Orders;
import com.neelav.OmnicurisAssignment.models.Product;
import com.neelav.OmnicurisAssignment.repository.OrderRepository;
import com.neelav.OmnicurisAssignment.repository.ProductRepository;
import com.neelav.OmnicurisAssignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderResource {

   /* @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;*/

    @Autowired
    private OrderService orderService;


    @GetMapping("/all")
    public List<Orders> getAllOrders()
    {
        return orderService.getAllOrders();
    }

    @PostMapping("/{productId}")
    public  Orders createOrder(@RequestBody Orders order,@PathVariable int productId)
    {
        return orderService.createOrder(order,productId);
    }
}
