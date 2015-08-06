package com.kamyshovcorp.app;

import com.kamyshovcorp.Stack;

/**
 * Created by kamyshov.sergey on 05.08.15.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Expected 0, 'cause Stack is initialized by zero size
        System.out.println("Size after creation: " + stack.getSize());

        String one = stack.push("One");
        System.out.println(String.format("Size after adding element '%s': %d", one, stack.getSize()));
        String two = stack.push("Two");
        System.out.println(String.format("Size after adding element '%s': %d", two, stack.getSize()));
        String three = stack.push("Three");
        System.out.println(String.format("Size after adding element '%s': %d", three, stack.getSize()));

        String expectedThree = stack.pop();
        System.out.println(String.format("Size after returning element '%s': %d", expectedThree, stack.getSize()));
        String expectedTwo = stack.pop();
        System.out.println(String.format("Size after returning element '%s': %d", expectedTwo, stack.getSize()));
        String expectedOne = stack.pop();
        System.out.println(String.format("Size after returning element '%s': %d", expectedOne, stack.getSize()));

        // Expected exceptions, 'cause Stack is empty
//        String expectedZero = stack.pop();
    }
}
