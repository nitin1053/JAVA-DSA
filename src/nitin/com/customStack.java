package nitin.com;

public class customStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    public customStack() {
        this(DEFAULT_SIZE);
    }

    public customStack(int size) {
        this.data = new int[size];

    }

    int ptr = -1;

    public boolean push(int item) {
        if (isfull()) {
            System.out.println("array is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean isfull() {
        return ptr == data.length - 1;


    }
    public boolean isempty(){
        return ptr==-1;
    }
    public int pop() throws stackException{
        if(isempty()){
            throw new stackException("can not be poped");

        }
 //       int removed=data[ptr];
        //     ptr--;
        //return removed;
        return data[ptr--];

    }
    public int peek() throws stackException{
        if (isempty()){
            throw new stackException("cant be seen in a empty");

        }
        return data[ptr];
    }
}
