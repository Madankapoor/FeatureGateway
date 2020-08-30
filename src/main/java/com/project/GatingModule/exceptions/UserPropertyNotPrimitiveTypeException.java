package com.project.GatingModule.exceptions;

public class UserPropertyNotPrimitiveTypeException extends Exception {
    public UserPropertyNotPrimitiveTypeException(String property){
        super("The property '"+property+"' is not of primitive type.");
    }
}
