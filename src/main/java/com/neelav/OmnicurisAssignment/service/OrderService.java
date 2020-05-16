package com.neelav.OmnicurisAssignment.service;

import com.neelav.OmnicurisAssignment.models.Orders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

     List<Orders> getAllOrders();

     Orders createOrder(Orders order, int productId);


}
