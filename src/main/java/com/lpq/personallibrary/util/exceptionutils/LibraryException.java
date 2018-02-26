package com.lpq.personallibrary.util.exceptionutils;

import org.springframework.stereotype.Component;

public class LibraryException extends Exception {
    private String message;

    public LibraryException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
