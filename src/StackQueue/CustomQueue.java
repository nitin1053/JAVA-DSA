package StackQueue;

public class CustomQueue {
    private int[] data;
    private static int DEFAULT_SIZE=10;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }
    public int end=0;



    public CustomQueue(int size){
        this.data=new int[size];
    }

    public boolean isFull(){
        return end==data.length;
    }
    public boolean isEmpty(){
        return end==0;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]=item;
//        it means it will first assigin then increment the value

        return true;

    }
    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        int remove=data[0];
//        shift the elements to the left
        for (int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return remove;
    }
    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("It is empty");
        }
        int returned=data[0];
        return returned;

    }
    public void display(){
        for (int i=0;i<end;i++){
            System.out.print(data[i]+"-->");
        }
        System.out.println("END");
    }


}
