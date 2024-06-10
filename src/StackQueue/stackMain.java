package StackQueue;

import java.util.Stack;

public class stackMain {
    public static void main(String[] args) throws StackException {
        DynamicStack stack=new DynamicStack(5);
        stack.push(4);
        stack.push(7);
        stack.push(58);

        stack.push(36);
        stack.push(10);
        stack.push(89);
        stack.push(90);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

