package com.hung.testspring.error;

public class StaffNotFoundException extends Exception{
    public StaffNotFoundException(String message) {
        super(message);
    }
}
