package BinaryTrees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        Scanner scanner=new Scanner(System.in);
//        binarytree tree=new binarytree();
//        tree.populate(scanner);
////        tree.display();
//        tree.preetyDisplay();
//        BST tree=new BST();
//        int[] nums={2,5,6,7,4,43,78,38,54};
//        tree.populate(nums);
//        tree.display()
        AVL tree=new AVL();
        for (int i=0;i<1000;i++){
            tree.insert(i);
        }
        System.out.println(tree.height());
    }
}
