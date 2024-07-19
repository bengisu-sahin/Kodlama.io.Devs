package com.kodlamaiodevs.project.business.core.utilities.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message); // super is used to call the constructor of the parent class
    }
    
}