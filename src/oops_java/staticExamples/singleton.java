package oops_java.staticExamples;

public class singleton {
    private singleton(){

    }
    private static singleton instance;
    public static singleton getInstance(){
        //check wheather 1 obj only is created or not
        if(instance==null){
            instance=new singleton();

        }
        return instance;
        //al three ref variables are pointing tojust one object

    }
}
