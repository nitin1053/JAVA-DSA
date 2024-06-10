package StackQueue;

import java.util.*;

public class InBuiltExamples {
    public static void main(String[] args){
        Stack<Integer> stack=new Stack<>();
        stack.push(34);
        stack.push(67);
        stack.push(36);
        stack.push(58);
        stack.push(28);
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
//implementation of queue using stack

class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while (!first.isEmpty()) {
            int popped = first.pop();
            second.push(popped);
        }
        int removed = second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() {
        while (!first.isEmpty()) {
            int popped = first.pop();
            second.push(popped);
        }
        int peeked = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyQueueRemovalEffi {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public MyQueueRemovalEffi() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        while (!first.isEmpty()){
            second.push(first.pop());

        }
        first.push(x);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int pop() {
        while (!first.isEmpty()) {
            return first.pop();
        }
        return -1;

    }

    public int peek() {
        while (!first.isEmpty()) {
            int popped = first.pop();
            second.push(popped);
        }
        int peeked = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

//game of two stack

class twostacks{
    static int game(int x,int[] a,int[] b){
        return TwoStack(x,a,b,0,0)-1;
    }

    public static int TwoStack(int x,int[] a,int[] b,int sum,int count){
        if (a.length==0 || b.length==0){
            return count;
        }
        if (sum>x){
            return count;
        }
        int ans1=TwoStack(x,Arrays.copyOfRange(a,1,a.length),b,sum+a[0],count+1);
        int ans2=TwoStack(x,a,Arrays.copyOfRange(b,1,b.length),sum+b[0],count+1);
        int main_ans=Math.max(ans1,ans2);
        return main_ans;

    }
    public static void main(String[] args){




    }

}

//HArd
//largest histogram in java

class histo{
    public static void main(String[] args){

    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        stack.push(0);
        for (int i=1;i<heights.length;i++){
            while (!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                 max=getmax(heights,stack,max,i);
            }
            stack.push(i);
        }
        int i=heights.length;
        while (!stack.isEmpty()){
            max=getmax(heights,stack,max,i);
        }

        return max;


    }
    private static int getmax(int[] arr,Stack<Integer> stack,int max,int i){
        int area;
        int popped=stack.pop();
        if (stack.isEmpty()){
            area=arr[popped]*i;
        }else{
            area=arr[popped]*(i-1-stack.peek());
        }


        return Math.max(max,area);
    }


}