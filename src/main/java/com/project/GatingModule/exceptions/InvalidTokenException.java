package com.project.GatingModule.exceptions;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(String token) {
        super("The token '" + token + "' is invalid");
    }
}
