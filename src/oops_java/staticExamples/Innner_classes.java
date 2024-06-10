package oops_java.staticExamples;
import java.util.Arrays;

///outside class cannot be static
public class Innner_classes {
    public static void main(String[] args) {
        test a = new test("kunal");
        test b = new test("rahu");


    }
}
class test {
    String name;

    public test(String name) {
        this.name = name;
    }
}


//static class A{
//        outside clases cannot be static
//}
//
class inner{
    static class test{
        String name;
        public test(String name){
            this.name=name;
        }
    }
    public static void main(String[] args){
        test a=new test("kunal");
        test b=new test(("rahul"));
        System.out.println(a.name);
        System.out.println(b.name);
    }
}


//class inner{
//    class test{
//        String name;
//        public test(String name){
//            this.name=name;
//        }
//    }
//    public static void main(String[] args){
//        test a=new test("kunal");
//        test b=new test(("rahul"));
//        System.out.println(a.name);
//        System.out.println(b.name);
//    }
//}error bcz static no


class inner3{
    static class test{
        static String name;
        public test(String name){

            this.name=name;
        }
        @Override
        public String toString(){
            return name;
        }

    }

    public static void main(String[] args){
        test a=new test("kunal");
        test b=new test(("rahul"));
        System.out.println(a);

    }
}
