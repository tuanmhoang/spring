package com.tuanmhoang.springmvc.simplebooking.exceptions;

public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException(String message){
        super(message);
    }
}
