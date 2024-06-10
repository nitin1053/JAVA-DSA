package StackQueue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue= new CircularQueue();
//        queue.insert(9);
//        queue.insert(5);
//        queue.insert(7);
//        queue.insert(8);
//        queue.insert(23);
//        queue.display();
//        System.out.println(queue.remove());
//        queue.display();
        queue.insert(56);
        queue.insert(67);
        queue.insert(89);
        queue.insert(4);
        queue.insert(47);
        queue.diplay();
        System.out.println(queue.remove());
        queue.insert(133);
        queue.diplay();

    }


}
