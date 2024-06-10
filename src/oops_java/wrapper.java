package oops_java;

public class wrapper {
    public static void main(String[] args)  {
//        int a=10;
//        int b=20;
        Integer a=10;
        Integer b=12;
        Integer num=45;
        swap(a,b);
        System.out.println(a+ " " +b);
        final int boous=10;
//        boous=8;
        final A nitin=new A("nitin");
        nitin.name="other name";
//        nitin=new A("obj")
//not possible in final above step
        A obj=new A("yes,yaaa");
        System.out.println(obj);
    //    for(int i=0;i<10000;i++){
    //        obj=new A("random name");
    //        obj.finalize();
    //    }
    }
    static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }


}
class A{
    final int num=10;
    String name;

    public A(String name) {
        System.out.println("obj created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("obj is destroyed");
    }

}