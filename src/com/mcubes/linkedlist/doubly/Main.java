package com.mcubes.linkedlist.doubly;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(5);
        list.insert(3);
        list.insert(8);
        list.insert(2);

        System.out.println(list);

        list.insertAtFirst(1);
        System.out.println(list);

        list.insertAt(3, 7);
        System.out.println(list);

        System.out.println("Travers First to Last:");
        TraverseFirstToLast<Integer> firstToLast = list.traverseFromHead();
        while (firstToLast.hasNext()) {
            System.out.println(firstToLast.next());
        }

        System.out.println("Travers Last to First:");
        TraverseLastToFirst<Integer> lastToFirst = list.traverseFromTail();
        while (lastToFirst.hasPrevious()) {
            System.out.println(lastToFirst.previous());
        }

        System.out.println("Value: " + list.get(3));
        System.out.println("Size: " + list.size());

        list.deleteFromFirst();
        System.out.println(list);

        list.deleteFromLast();
        System.out.println(list);

        list.delete(1);
        System.out.println(list);
    }
}
