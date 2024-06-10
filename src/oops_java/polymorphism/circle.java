package oops_java.polymorphism;

public class circle extends shapes{
    //this will run when obj of circle is created
    // hence it is overriddingg the parent method
    @Override//this is known as annotation
    void area(){
        System.out.println("the area of the circle is pi r 2");

    }
}
