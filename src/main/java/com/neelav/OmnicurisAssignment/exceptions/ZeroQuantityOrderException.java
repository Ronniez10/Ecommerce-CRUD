package com.neelav.OmnicurisAssignment.exceptions;

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
