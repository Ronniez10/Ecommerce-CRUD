package com.neelav.EcommerceCRUD.service;

import com.neelav.EcommerceCRUD.exceptions.*;
import com.neelav.EcommerceCRUD.models.Orders;
import com.neelav.EcommerceCRUD.models.Product;
import com.neelav.EcommerceCRUD.models.Users;
import com.neelav.EcommerceCRUD.repository.OrderRepository;
import com.neelav.EcommerceCRUD.repository.ProductRepository;
import com.neelav.EcommerceCRUD.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders createOrder(Orders order, int productId,String userId)
    {

        Optional<Product> product = productRepository.findById(productId);
        Optional<Users> user = userRepository.findById(userId);

        if(product.isPresent() && user.isPresent())
        {
            Product theProduct = product.get();

            Users theUser = user.get();

            //Handling all the Quantity related Exceptions Possible
            if(order.getOrderQuantity()==0)
                throw new ZeroQuantityOrderException("Order Quantity is 0");
            else if (theProduct.getQuantityAvailable()==0)
                throw new OutOfStockException("Product is currently Out of Stock");
            else if (theProduct.getQuantityAvailable()<order.getOrderQuantity())
                throw new OrderQuantityExceedingStocks("Order Quantity exceeds our Stocks");

            //If there is no Exception then we go ahead and place the Order with the Appropriate Details
            else
            {
                int orignalQuantity = theProduct.getQuantityAvailable();

                //Updating the Order Quantity
                theProduct.setQuantityAvailable(orignalQuantity-order.getOrderQuantity());

                //Saving the Updated Product
                theProduct=productRepository.save(theProduct);

                //Updating the Product and the User for the Order
                order.setProduct(theProduct);
                order.setUser(theUser);


                return orderRepository.save(order);
            }
        }
        else if(!product.isPresent())
        {
            throw new ProductNotFoundException("Product Does not Exist for Placing Order");
        }
        else
        {
            throw new UserNotFoundException("User Does not Exist");
        }

    }
}
