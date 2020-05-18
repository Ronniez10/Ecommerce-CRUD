package com.neelav.EcommerceCRUD.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserNotFoundException> handleUserNotFoundException(UserNotFoundException exc)
    {
        CustomErrorResponse error =new CustomErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }



    // Exception Handler for ProductNotFound Exception
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleProductNotFoundException(ProductNotFoundException exc)
    {
        CustomErrorResponse error =new CustomErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    // Exception Handler for OrderQuantityExceedingStocks Exception
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleOrderQuantityExceedingStocksException(OrderQuantityExceedingStocks exc)
    {
        CustomErrorResponse error =new CustomErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    // Exception Handler for OutOfStock Exception
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleOutOfStockException(OutOfStockException exc)
    {
        CustomErrorResponse error =new CustomErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    // Exception Handler for ZeroQuantityOrder Exception
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleZeroQuantityOrderException(ZeroQuantityOrderException exc)
    {
        CustomErrorResponse error =new CustomErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }


}
