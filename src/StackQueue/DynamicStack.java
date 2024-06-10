package StackQueue;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
//        it will call super

    }
    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) {
//        this thing takes care of full
        if (isFull()){
//            double the array size
            int[] temp=new int[data.length*2];
//            copy all prev items in new data
            for (int i=0;i<data.length;i++){
                temp[i]=data[i];

            }
            data=temp;
        }
//        at this point we know array is not full
//        insert item
        return super.push(item);

    }
//    some questions on the stack
}
