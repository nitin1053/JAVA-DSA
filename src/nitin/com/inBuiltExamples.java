package nitin.com;

import java.util.*;

public class inBuiltExamples {
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        stack.push(54);
        stack.push(90);
        stack.push(59);
        stack.push(37);
        stack.push(29);
        stack.push(39);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class queue{
    public static void main(String[] args){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(45);
        queue.add(69);
        queue.add(49);
        queue.add(68);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(45);
        deque.add(79);
        // element can be remove from both the sides
    }

}


