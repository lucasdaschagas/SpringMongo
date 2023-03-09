package com.mongospring.mongospringprojec.services.exception;

public class ObjectNotFoundExeption extends RuntimeException{
    public ObjectNotFoundExeption (String msg){
        super(msg);
    }
}
