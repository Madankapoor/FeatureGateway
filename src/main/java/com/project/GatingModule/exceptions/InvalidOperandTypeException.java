package com.project.GatingModule.exceptions;

public class InvalidOperandTypeException extends Exception {
    public InvalidOperandTypeException(String expected, String got){
        super("Expected type:"+expected + " but got: " + got);
    }
}
