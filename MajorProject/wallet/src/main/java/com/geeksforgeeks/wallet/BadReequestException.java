package com.geeksforgeeks.wallet;

public class BadReequestException extends Exception {
    public BadReequestException() {
    }

    public BadReequestException(String message) {
        super(message);
    }

    public BadReequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadReequestException(Throwable cause) {
        super(cause);
    }

    public BadReequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
