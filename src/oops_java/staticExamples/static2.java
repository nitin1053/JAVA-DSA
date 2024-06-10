package oops_java.staticExamples;
//this is a demo to show initialisation of static variables
public class static2 {

    static int a=3;
    static int b;

    //will only run once,when the first obj is create i.e when the class is loaded for the first time
    static {
        System.out.println("I am a static block");
        b=a*5;
    }
    public static void main(String[] args){
        static2 obj=new static2();
        System.out.println(static2.a +" "+ static2.b);

        static2.b +=3;
        System.out.println(static2.b);

        static2 obj2=new static2();
        System.out.println(static2.a +" "+ static2.b);

    }



}
