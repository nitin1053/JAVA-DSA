package nitin.com;

public class customqueue {
    private int[] data;
    private static final int DEFAULT_SIZE=10;
    int end = 0;
    public customqueue(){
        this(DEFAULT_SIZE);
    }
    public customqueue(int size){
        this.data=new int[size];

    }
    public boolean isfull() {
        return end == data.length ;


    }


}
