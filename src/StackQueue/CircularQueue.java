package StackQueue;

public class CircularQueue {
    protected int[] data;
    private static int DEFAULT_SIZE=10;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    protected int end=0;
    protected int front=0;
    private int size=0;



    public CircularQueue(int size){
        this.data=new int[size];
    }

    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]=item;
//        it means it will first assigin then increment the value
        end=end%data.length;
        size++;

        return true;

    }
    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        int remove=data[front++];
//        shift the elements to the left
        front=front%data.length;
        size--;

        return remove;
    }
    public int Front() throws Exception{
        if (isEmpty()){
            throw new Exception("It is empty");
        }
        return data[front];
    }
    public void diplay(){
        if (isEmpty()){
            System.out.println("Empty");
        }
        int i=front;
        do {
            System.out.print(data[i]+"-->");
            i++;
            i%=data.length;
        }while (i!=end);
            System.out.println("End");

    }

}
