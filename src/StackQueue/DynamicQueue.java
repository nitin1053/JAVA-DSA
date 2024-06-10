package StackQueue;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super();
//        it will call super

    }
    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item) {

        if (isFull()){
//            double the array size
            int[] temp=new int[data.length*2];
//            copy all prev items in new data
            for (int i=0;i<data.length;i++){
                temp[i]=data[(front+i)%data.length];

            }
            front=0;
            end=data.length;
            data=temp;
        }
//        at this point we know array is not full
//        insert item
        return super.insert(item);
    }
}
