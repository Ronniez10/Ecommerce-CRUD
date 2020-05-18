package com.neelav.EcommerceCRUD.exceptions;

public class ZeroQuantityOrderException extends RuntimeException {

    public ZeroQuantityOrderException()
    {
        super();
    }

    public  ZeroQuantityOrderException(String message)
    {
        super(message);
    }
}
