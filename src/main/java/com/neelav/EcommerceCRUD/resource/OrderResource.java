package com.neelav.EcommerceCRUD.resource;

import com.neelav.EcommerceCRUD.models.Orders;
import com.neelav.EcommerceCRUD.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/user/{userId}/product/{productId}")
    public  Orders createOrder(@RequestBody Orders order,@PathVariable int productId,@PathVariable String userId)
    {
        return orderService.createOrder(order,productId,userId);
    }

    @GetMapping("/user/{userId}")
    public List<Orders> getOrderByUser(@PathVariable String userId)
    {

        return orderService.getOrdersByUser(userId);
    }

}
