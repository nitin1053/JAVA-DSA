package oops_java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //store 5 roll n0
        int[] numbers = new int[5];

        //store 5 names
        String[] names = new String[5];
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];
        //class group of function

        Student[] student = new Student[5];
        Student kunal = new Student(13,"kunal",56);
//        kunal.marks = 15F;
//        kunal.rno = 323;
//        kunal.name = "kunal";
//        System.out.println(kunal.name);
//        System.out.println(kunal.rno);
//        System.out.println(kunal.marks);

        //System.out.println(Arrays.toString(student));
//        kunal.changename("nash");
//        kunal.greeting();
//        Student random=new Student(kunal);
//        System.out.println(random.name);
        Student one=new Student();
        Student two=one;
        one.name="Some";
        System.out.println(two.name);



    }
}
    //create a class
    //for evevy stud
class Student{
    int rno;
    String name;
    Float marks;
    void greeting(){
        System.out.println("Hello! My name is"+ name);
    }
    Student (Student other){
        this.name=other.name;
        this.rno=other.rno;
        this.marks=other.marks;
    }
    void changename(String newName){
        name=newName;
    }

    Student (){
        this.rno=14;
        this.name="nit";
        this.marks=54.8f;
    }
    Student(int rol, String name, float marks){
        this.rno=rol;
        this.name=name;
        this.marks=marks;
    }//eg=Student arpit=new Student(45,"fe',53)
//these things will get replaced
}

