package oops_java.staticExamples;

import oops_java.acces.A;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args){
        Human nitin=new Human(19,"Nitin",30000000,false);
        Human rahul=new Human(49,"Rahul",0000000,true);
        Human arpit=new Human(32,"arp",43,true);
//        System.out.println(nitin.population);
//        System.out.println(rahul.population);
        //always acces the element by the name of the class
        //when we add keyword static it meants that we can acces the particular thing without the making the obj of it.
        System.out.println(Human.population);
       // greeting();
        singleton obj=singleton.getInstance();
        singleton obj2=singleton.getInstance();
        singleton obj3=singleton.getInstance();

        A a=new A(10,"nitin");
        a.getNum();

    }
    static void fun(){

        //greeting();// you can''t use this bcz it requires an instance but the function you are using it in does not depend on instances
        Main obj =new Main();
        obj.greeting();
        //you can not accesssnon static stuff without referncing their instances in a static context
        // hence above I  referncing  it
    }
    void greeting(){
        //fun(); but it can
        // we know that something which is not static belongs to an object
        System.out.println("hello world");
    }
    static void message(){
        System.out.println("Hello world");
        //System.out.println(this.age); cant use this over here
    }


}
//class main1{
//    public static void main(String[] args){
//        singleton
//    }
//}
