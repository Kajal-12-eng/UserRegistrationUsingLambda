package com.bl;

public class UserValidationException extends Throwable {
    public UserValidationException( String message) {
        super(message);
    }
}