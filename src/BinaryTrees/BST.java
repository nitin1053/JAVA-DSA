package BinaryTrees;

public class BST {
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
    public BST(){

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
        return node;
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
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    private boolean helper(TreeNode node,Integer low,Integer high){
        if(node==null){
            return true;
        }
        if(low!=null && node.val<=low){
            return false;
        }
        if(high!=null && node.val>=high){
            return false;
        }
        boolean lefttree=helper(node.left,low,node.val);
        boolean righttree=helper(node.right,node.val,high);
        return lefttree && righttree;

    }




}
