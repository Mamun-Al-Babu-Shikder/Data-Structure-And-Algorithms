package com.mcubes.linkedlist.singly;

public class Main {

    public static void main(String[] args) {

        // create Singly Linked List object
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // insert data to linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(2);
        list.insert(7);
        list.insert(8);
        list.insert(9);

        // print the linked list
        System.out.println(list);

        // insert data specific position to linked list
        list.insertAt(2, 4);
        System.out.println(list);

        // insert data at first position
        list.insertAtFirst(5);
        System.out.println(list);

        // get data from linked list
        Integer value = list.get(3);
        System.out.println("Value : " + value);

        // update linked list
        list.update(1, 2);
        System.out.println(list);

        // update linked list
        list.updateAll(2, 6);
        System.out.println(list);

        // linked list size
        int size = list.size();
        System.out.println("Size : " + size);

        // delete data from first
        list.deleteFromFirst();
        System.out.println(list);

        // delete data from linked list according tpo position
        list.delete(3);
        System.out.println(list);

        System.out.println("Before reverse: " + list);
        // reverse the list
        list.reverse();
        System.out.println("After reverse: " + list);

        System.out.println("Before sorting: " + list);
        // sort the list
        list.sort();
        System.out.println("After sorting: " + list);
    }
}
