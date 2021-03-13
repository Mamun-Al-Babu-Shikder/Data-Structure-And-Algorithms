package com.mcubes.linkedlist.doubly;

import java.util.StringJoiner;

public class DoublyLinkedList<T> {

    private static class Node<T> {

        Node<T> prev;
        T data;
        Node<T> next;

        Node(T data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    private DoublyLinkedList.Node<T> head;
    private DoublyLinkedList.Node<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void insert(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            Node node2 = new Node(data);
            node.next = node2;
            node2.prev = node;
            tail = node2;
        }
        length++;
    }

    public void insertAtFirst(T data) {
        Node node = new Node(data);
        node.next = head;
        if (head != null)
           head.prev = node;
        head = node;
        this.length++;
    }

    public boolean insertAt(int index, T data) {
        if (index < 0 || index > length)
            return false;

        if (index ==  0)
            insertAtFirst(data);
        else if (index == length)
            insert(data);
        else {
            Node node1;
            Node node2 = new Node(data);
            Node node3 = head;
            for (int i=1 ;i<=index; i++) {
                node3 = node3.next;
            }
            node1 = node3.prev;
            node1.next = node2;
            node2.prev = node1;
            node2.next = node3;
            node3.prev = node2;
            length++;
        }
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node<T> node = head;
        for (int i=1; i<=index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public int size() {
        return this.length;
    }

    public void deleteFromFirst() {
        if (head != null) {
            head = head.next;
            head.prev = null;
            this.length--;
        }
    }

    public void deleteFromLast() {
        if (tail != null) {
            tail = tail.prev;
            tail.next = null;
            this.length--;
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= length)
            return;
        if (index == 0)
            deleteFromFirst();
        else if (index == length-1)
            deleteFromLast();
        else {
            Node node1;
            Node node = head;
            for (int i = 1; i <= index; i++) {
                node = node.next;
            }
            node1 = node.prev;
            Node node2 = node.next;
            node1.next = node2;
            node2.prev = node1;
        }
    }

    public TraverseFirstToLast<T> traverseFromHead() {
        return new DoublyLinkedList.TraverseFirstToLastImpl<T>(this.head);
    }

    private static class TraverseFirstToLastImpl<T> implements TraverseFirstToLast<T> {

        private Node<T> first;

        public TraverseFirstToLastImpl(Node<T> node) {
            this.first = node;
        }

        @Override
        public boolean hasNext() {
            return this.first != null;
        }

        @Override
        public T next() {
            T data = first.data;
            first = first.next;
            return data;
        }
    }

    public TraverseLastToFirstImpl<T> traverseFromTail() {
        return new DoublyLinkedList.TraverseLastToFirstImpl<T>(this.tail);
    }

    private static class TraverseLastToFirstImpl<T> implements TraverseLastToFirst<T> {

        private Node<T> last;

        public TraverseLastToFirstImpl(Node<T> node) {
            this.last = node;
        }

        @Override
        public boolean hasPrevious() {
            return this.last != null;
        }

        @Override
        public T previous() {
            T data = last.data;
            last = last.prev;
            return data;
        }
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        Node node = head;
        while (node != null) {
            joiner.add(String.valueOf(node.data));
            node = node.next;
        }
        return "[" + joiner.toString() +"]";
    }
}