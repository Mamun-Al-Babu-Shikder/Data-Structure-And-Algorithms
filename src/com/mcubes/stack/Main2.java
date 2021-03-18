package com.mcubes.stack;

public class Main2 {

    public static void main(String[] args) {

        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        System.out.println("Stack is empty: " + stack.isEmpty());
        for (int i=1; i<=10; i++) {
            stack.push(i);
        }
        System.out.print("Display: ");
        stack.display();
        try {
            stack.push(11);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Stack is full: " + stack.isFull());
        System.out.println("Peek value: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Count: " + stack.count());
        System.out.print("Display: ");
        stack.display();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Count: " + stack.count());
        System.out.println(stack.pop());
    }
}
