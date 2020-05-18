package com.neelav.EcommerceCRUD.exceptions;



public class OrderQuantityExceedingStocks extends  RuntimeException {

   public OrderQuantityExceedingStocks()
   {
       super();
   }

   public OrderQuantityExceedingStocks(String message)
   {
       super(message);
   }
}
