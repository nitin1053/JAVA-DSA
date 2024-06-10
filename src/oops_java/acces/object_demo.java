package oops_java.acces;

public class object_demo {
    int num;
    float name;

    public object_demo(int num,float name) {
        this.num = num;
        this.name=name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.num==((object_demo)obj).num;
//        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }//gives the string representation

//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();use in garbage collection in java
    public static void main(String[] args){
        object_demo obj=new object_demo(67,8.9f);
        System.out.println(obj.hashCode());
        object_demo onj2=new object_demo(67,98.6f);
//        System.out.println(onj2.hashCode());
        if(onj2 == obj){
            System.out.println("heyy dude");
        }
        if (onj2.equals(obj)){
            System.out.println("hello");

        }
        System.out.println(obj.getClass());

    }
}


