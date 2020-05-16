package com.neelav.OmnicurisAssignment.exceptions;

public class ProductNotFoundException extends  RuntimeException {

    public ProductNotFoundException()
    {
        super();
    }

    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
