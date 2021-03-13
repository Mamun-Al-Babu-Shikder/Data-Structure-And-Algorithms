package com.mcubes.linkedlist.singly;

import java.util.Comparator;
import java.util.StringJoiner;

public class SinglyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private SinglyLinkedList.Node<T> head;
    private int length;

    public SinglyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public void insert(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(data);
        }
        this.length++;
    }

    public void insertAtFirst(T data) {
        Node node = new Node(data);
        node.next = head;
        this.head = node;
        this.length++;
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

    public boolean insertAt(int index, T data) {
        Node node= new Node(data);
        if (index == 0) {
            node.next = head;
            this.head = node;
            this.length++;
        } else if (index == length) {
            this.insert(data);
        } else if (index > 0 && index < length) {
            Node temp = head;
            for (int i=1; i<index; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            this.length++;
        } else {
            return false;
        }
        return true;
    }

    public void delete(T data) {
        Node node = head;
        if (node != null && node.data == data) {
            this.head = head.next;
            return;
        }
        Node temp = node;
        while (node != null && node.data != data) {
            temp = node;
            node = node.next;
        }
        if (node != null) {
            temp.next = node.next;
        }
    }

    public void deleteFromFirst() {
        if (this.head != null) {
            this.head = head.next;
            this.length--;
        }
    }

    public void update(T oldData, T newData) {
        Node node = head;
        while (node != null && node.data != oldData) {
            node = node.next;
        }
        if (node != null) {
            node.data = newData;
        }
    }

    public void updateAll(T oldData, T newData) {
        Node node = head;
        while (node != null) {
            if (node.data == oldData) {
                node.data = newData;
            }
            node = node.next;
        }
    }

    public int size() {
        return length;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    public void sort() {
        Comparator<T> comparator = Comparator.comparingInt(Object::hashCode);
        sort(comparator);
    }

    public void sort(Comparator<T> comparator) {
        Node<T> node = head;
        while (node != null) {
            Node<T> min = node;
            Node<T> node2 = node.next;
            while (node2 != null) {
                int val = comparator.compare(node2.data, min.data);
                if (val < 0)
                    min = node2;
                node2 = node2.next;
            }
            T temp = min.data;
            min.data = node.data;
            node.data = temp;
            node = node.next;
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