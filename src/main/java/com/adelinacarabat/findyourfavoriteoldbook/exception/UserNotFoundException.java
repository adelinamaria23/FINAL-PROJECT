package com.adelinacarabat.findyourfavoriteoldbook.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}