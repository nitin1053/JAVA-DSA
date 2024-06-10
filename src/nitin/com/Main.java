package nitin.com;

public class Main {
    public static void main(String[] args){
        LL list =new LL();
        list.insertfirst(4);
        list.insertfirst(3);
        list.insertfirst(48);
        list.insertfirst(29);
        list.lastinsert(99);
        list.insert(10,3);
        list.display();
        System.out.println(list.deletefirst());
        list.display();
        System.out.println(list.deletlast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
    }
}///o(n) time complexity
