package com.epam.tat.jdbc.exceptions;

public class DatabaseReadException extends RuntimeException {

    public DatabaseReadException(String message) {
        super(message);
    }

    public DatabaseReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
