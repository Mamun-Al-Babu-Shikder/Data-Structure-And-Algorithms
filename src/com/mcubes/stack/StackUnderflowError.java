package com.mcubes.stack;

public class StackUnderflowError extends RuntimeException {

    public StackUnderflowError() {
        this("Stack underflow");
    }

    public StackUnderflowError(String message) {
        System.err.println(message);
    }
}
