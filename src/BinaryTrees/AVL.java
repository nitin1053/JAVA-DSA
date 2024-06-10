package BinaryTrees;

public class AVL {
    public class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
    private Node root;
    public AVL(){

    }
    public int height(){
        return height(root);
    }
    public int height(Node node){
        if (node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty() {
        return root==null;
    }

    public void insert(int value){
        root=insert(value,root);

    }
    private Node insert(int value,Node node){
        if (node==null){
            node=new Node(value);
            return node;
        }
        if (value<node.val){
            node.left=insert(value,node.left);
        }
        if (value>node.val){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }
    private Node rotate(Node node){
        if (height(node.left)-height(node.right)>1){
//            left heavy
            if (height(node.left.left) - height(node.left.right)>0){
//                left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right)<0){
//                left right case
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left)-height(node.right)<-1){
//            left heavy
            if (height(node.right.left) - height(node.right.right)<0){
//                right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right)>0){
//                right left case
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    public Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return c;


    }
    public Node leftRotate(Node c){
        Node p=c.right;
        Node t=p.left;

        p.left=c;
        c.right=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return p;


    }
    public void populate(int[] nums){
        for (int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums,start,mid);
        populateSorted(nums,mid+1,end);

    }
    public void display(){

        display(root, "Root Node: ");
    }
    private void display(Node node,String details){
        if (node==null){
            return;
        }
        System.out.println(details + node.getVal());
        display(node.left,"Left child of "+node.getVal() +" : ");
        display(node.right,"right child of "+node.getVal() +" : ");
    }
    public boolean balanced(){
        return balanced(root);
    }
    private  boolean balanced(Node node){
        if (node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left)&& balanced(node.right);
    }
    //    for balance binary tree the height should be less than for equal to 1
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node==null){
            return;
        }
        System.out.println(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val+" ");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val+" ");
    }


}
