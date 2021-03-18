package com.mcubes.stack;

import java.util.StringJoiner;

public class StackUsingLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int capacity;
    private int top;

    public StackUsingLinkedList() {
        this(10);
    }

    public StackUsingLinkedList(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.head = null;
    }

    public void push(T value) {
        if (top < capacity - 1) {
            top = top + 1;
            if (this.head == null) {
                this.head = new Node<>(value);
            } else {
                Node node = new Node(value);
                node.next = this.head;
                this.head = node;
            }
        } else {
            throw new StackOverflowError();
        }
    }

    public T pop() {
        if (top == -1) {
            throw new StackUnderflowError();
        }
        T value =  this.head.data;
        this.head = this.head.next;
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
        return (T) this.head.data;
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
        Node node = this.head;
        while (node != null) {
            joiner.add(String.valueOf(node.data));
            node = node.next;
        }
        return joiner.toString();
    }
}
