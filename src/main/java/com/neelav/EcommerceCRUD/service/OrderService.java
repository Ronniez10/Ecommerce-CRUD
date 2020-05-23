package com.neelav.EcommerceCRUD.service;

import com.neelav.EcommerceCRUD.models.Orders;

import java.util.List;

public interface OrderService {

     List<Orders> getAllOrders();

     Orders createOrder(Orders order, int productId,String userId);


    List<Orders> getOrdersByUser(String userId);
}
