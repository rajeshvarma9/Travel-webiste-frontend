package com.traveleasy.fullstackbackend.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message, Long id, String attribute){
//        super("Could not find the "+attribute+" with " +id);
        super(message);
    }


}
