package StackQueue;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    public CustomStack(){

        this(DEFAULT_SIZE);
    }
    int ptr=-1;

    public CustomStack(int size) {
        this.data = new int[size];
    }
    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;

    }
    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot pop");
        }
//        int removed=data[ptr];
//        ptr--;
        return data[ptr--];

    }
    public int peek() throws StackException{
        if (isEmpty()){
            throw new StackException("Empty stack");
        }

        return data[ptr];
    }
    public boolean isFull(){
        return ptr==data.length-1;
    }
    public boolean isEmpty(){
        return ptr==-1;
    }

}



