package com.neelav.OmnicurisAssignment.service;

import com.neelav.OmnicurisAssignment.exceptions.OrderQuantityExceedingStocks;
import com.neelav.OmnicurisAssignment.exceptions.OutOfStockException;
import com.neelav.OmnicurisAssignment.exceptions.ProductNotFoundException;
import com.neelav.OmnicurisAssignment.exceptions.ZeroQuantityOrderException;
import com.neelav.OmnicurisAssignment.models.Orders;
import com.neelav.OmnicurisAssignment.models.Product;
import com.neelav.OmnicurisAssignment.repository.OrderRepository;
import com.neelav.OmnicurisAssignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders createOrder(Orders order, int productId) {
        Optional<Product> product = productRepository.findById(productId);

        if(product.isPresent())
        {
            Product theProduct = product.get();

            if(order.getOrderQuantity()==0)
                throw new ZeroQuantityOrderException("Order Quantity is 0");
            else if (theProduct.getQuantityAvailable()==0)
                throw new OutOfStockException("Product is currently Out of Stock");
            else if (theProduct.getQuantityAvailable()<order.getOrderQuantity())
                throw new OrderQuantityExceedingStocks("Order Quantity exceeds our Stocks");
            else
            {
                int orignalQuantity = theProduct.getQuantityAvailable();
                theProduct.setQuantityAvailable(orignalQuantity-order.getOrderQuantity());
                theProduct=productRepository.save(theProduct);
                order.setProduct(theProduct);
                return orderRepository.save(order);
            }
        }
        else
        {
            throw new ProductNotFoundException("Product Does not Exist for Placing Order");
        }
    }
}
