package com.mcubes.stack;

import java.util.StringJoiner;

public class StackUsingArray<T> {

    private int capacity;
    private int top;
    private Object[] data;

    public StackUsingArray() {
        this(10);
    }

    public StackUsingArray(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.data = new Object[this.capacity];
    }

    public void push(T value) {
        if (top < capacity - 1) {
            top = top + 1;
            data[top] = value;
        } else {
            throw new StackOverflowError();
        }
    }

    public T pop() {
        if (top == -1) {
            throw new StackUnderflowError();
        }
        T value = (T) data[top];
        top = top - 1;
        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top + 1 == capacity;
    }

    public T peek() {
        if (top == -1)
            throw new StackUnderflowError();
        return (T) data[top];
    }

    public int count() {
        return top + 1;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int index = 0; index <= top; index++) {
            joiner.add(String.valueOf(data[index]));
        }
        return joiner.toString();
    }
}
