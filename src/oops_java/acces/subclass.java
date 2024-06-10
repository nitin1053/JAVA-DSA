package oops_java.acces;

public class subclass extends A{
    public subclass(int num, String name) {
        super(num, name);
    }
    public static void main(String[] args){
//        subclass obj1=new A(345,"nit");
//        int p=obj1.num; cannt does backward
//        System.out.println(p);
        subclass obj=new subclass(21,"Nitin");
        int n=obj.num;
        ///protected can acces with class subclass in its package
        System.out.println(obj instanceof A);
        System.out.println(obj instanceof subclass);
        System.out.println(obj instanceof Object);
    }
}


class subsubclass extends subclass{

    public subsubclass(int num, String name) {
        super(num, name);
    }
    public static void main(String[] args){
        subsubclass obj=new subsubclass(346,"nitin");
        int n=obj.num;
        System.out.println(n);
    }
}


class subclass2 extends A{
    public subclass2(int num, String name) {
        super(num, name);
    }
    public static void main(String[] args){
//        A obj=new A(34,"Nitin");
//        int n=obj.num;
//        System.out.println(n);

    }
}

///a directly would be able to acces the subclass bcz A doesnt have idea that is extending him onlt subclass know about A
 //inbuilt package and in build package

//in built package--->lang(imp java package)
// --->i/o package,-->util,-->applet,--->awt


