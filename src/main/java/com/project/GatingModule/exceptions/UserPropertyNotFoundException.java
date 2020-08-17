package com.project.GatingModule.exceptions;

public class UserPropertyNotFoundException extends Exception {
    public UserPropertyNotFoundException(String property){
        super("The property '"+property+"' is not found.");
    }
}
