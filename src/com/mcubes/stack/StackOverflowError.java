package com.mcubes.stack;

public class StackOverflowError extends RuntimeException {

    public StackOverflowError() {
        this("Stack overflow");
    }

    public StackOverflowError(String message) {
        System.err.println(message);
    }
}
