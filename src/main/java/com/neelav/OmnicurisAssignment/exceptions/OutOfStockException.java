package com.neelav.OmnicurisAssignment.exceptions;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException()
    {
        super();
    }

    public OutOfStockException(String message)
    {
        super(message);
    }
}
