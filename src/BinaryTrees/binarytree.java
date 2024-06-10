package BinaryTrees;

import javax.swing.text.html.parser.Entity;
import java.util.Scanner;

public class binarytree {
    public binarytree(){

    }
    private static class Node{
        private int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node root;
    public void populate(Scanner scanner){
        System.out.println("Enter the root node value:-");
        int value=scanner.nextInt();
        root=new Node(value);
        populate(scanner,root);

    }
    private void populate(Scanner scanner,Node node){
        System.out.println("Do yo want toenter left of "+ node.val);
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value for left node for "+node.val);
            int value=scanner.nextInt();
            node.left=new Node(value);
            populate(scanner,node.left);
        }
        System.out.println("Do your want to insert in right side of "+ node.val);
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value for right side of "+node.val);
            int value=scanner.nextInt();
            node.right=new Node(value);
            populate(scanner,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    public void display(Node node,String indent){
        if (node==null){
            return;
        }

        System.out.println(indent + node.val);
        display(node.left,indent + "\t");
        display(node.right,  indent + "\t");

    }
    public void preetyDisplay(){
        preetyDisplay(root,0);
    }
    public static void preetyDisplay(Node node,int level){
        if(node==null){
            return;
        }
        preetyDisplay(node.right,level+1);
        if (level!=0){
            for (int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("------>"+ node.val);
        }else{
            System.out.println(node.val);
        }
        preetyDisplay(node.left,level+1);
    }

}
