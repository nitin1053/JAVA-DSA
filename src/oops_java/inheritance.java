package oops_java;

public class inheritance {

}
class box{
    double l;
    double h;
    double w;
//    double weight;

    static void greeting(){
        System.out.println("hey I am in box");
    }
    box(){
        this.h=-1;
        this.w=-1;
        this.l=-1;
    }

    public box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    // cube
    box(double side){
        //super();object class
        this.h=side;
        this.l=side;
        this.w=side;
    }
    box(box old){
        this.h=old.h;
        this.l=old.l;
        this.w=old.w;
    }
    public void information(){
        System.out.println("running the box");
    }

}
class M1 {
    public static void main(String[] args){
////        box box=new box(4,8,9);
////        box box2=new box(box);
////        System.out.println(box.l+" "+box.w+" "+ box.h);
//        boxweight box3=new boxweight();
//        box3.weight=-1;
//        System.out.println(box3.h+" "+box3.weight);
//        System.out.println();
//        boxweight  box4=new boxweight(8,7,4,2);
//        System.out.println(box4);
//        System.out.println(box3.h+" "+box3.w+" "+box3.l+" "+box3.weight);
//    box box5=new boxweight(9,8,5,3);
//    System.out.println(box5.);

        //there are amny variables in both parent and child classes
        //you are given acces to variables  that are in the ref type i.e
        //hence you should have acces to weight variables
        //this also means that the ones you are trying to acces should be initializzed
        //but here when the obj itself is of type parent class how will youy call the constructor
        //this is an error
//        boxweight box6=new box(4,6,8);
//        System.out.println(box6)

//     ;
//        boxprice box=new boxprice(4,6,4);
//        System.out.println(box.cost);
        //box.greeting();
        boxweight box=new boxweight();
        boxweight.greeting();


    }
}

class boxweight extends box{
    double weight;
    public boxweight(){

        this.weight=-1;
    }

    public boxweight(double l, double h, double w, double weight) {
        super(l, h, w);//what is this ? call the parent class constructor
        //used to intialise the value present inparent class

        this.weight = weight;

    }
    boxweight(boxweight other){
        super(other);
        weight=other.weight;
    }

    //object of the parent class cannot acces the property of the child class

    boxweight(double side,double weight){
        super(side);
        this.weight=weight;
    }
}

