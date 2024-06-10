package oops_java.polymorphism;

public class numbers {
    int sum(int a,int b){
        return a + b;
    }
    int sum(int b,int a,int c){
        return a + b + c;

    }
    public static void main(String[] args){
        numbers num=new numbers();
        num.sum(5,8);
        num.sum(4,7,5);
//        num.sum(9,5,3,1)
    }
}
