package nitin.com;

public class stackMain {
    public static void main(String[] args) throws stackException {
        customStack stack=new customStack(5);
        stack.push(5);
        stack.push(7);
        stack.push(8);
        stack.push(84);
        stack.push(82);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
