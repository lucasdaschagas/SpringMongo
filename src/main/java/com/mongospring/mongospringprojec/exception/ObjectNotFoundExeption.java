package com.mongospring.mongospringprojec.exception;

public class ObjectNotFoundExeption extends RuntimeException{
    public ObjectNotFoundExeption (String msg){
        super(msg);
    }
}
