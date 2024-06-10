package BinaryTrees;

import java.util.*;


public class questions {
}





/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return traverse(root);
    }

    private List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currentLevel.add(curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            result.add(currentLevel);
        }
        return result;
    }
}
class Average_of_Levels_in_BinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double avg = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                avg += curr.val;


                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            avg = avg / levelSize;
            result.add(avg);
        }
        return result;
    }
    public TreeNode findSuccesor(TreeNode root,int key){
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (curr.val==key){
                break;
            }

        }


        return queue.peek();
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean zigzag=false;
        while(!queue.isEmpty()){
            int LevelSize=queue.size();
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<LevelSize;i++){
                TreeNode Node=queue.poll();
                if(zigzag){
                    curr.add(0,Node.val);
                }
                else{
                    curr.add(Node.val);
                }
                if(Node.left!=null){
                    queue.offer(Node.left);
                }
                if(Node.right!=null){
                    queue.offer(Node.right);
                }
            }
            result.add(curr);
            zigzag=!zigzag;
        }
        return result;
    }
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftmost = root;

        while (leftmost.left != null) {
            TreeNode curr = leftmost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftmost = leftmost.left;


        }
        return root;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelsize=queue.size();
            List<Integer> currLevel=new ArrayList<>(levelsize);
            for(int i=0;i<levelsize;i++){
                TreeNode curr=queue.poll();
                if(i==levelsize-1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }

            }


        }
        return result;



    }
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        return (
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode leftNode = findNode(node.left, x);
        if (leftNode != null) {
            return leftNode;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }
        return (
                ((node.left != null && node.left.val == x.val && node.right != null && node.right.val == y.val) ||
                        (node.left != null && node.left.val == y.val && node.right != null && node.right.val == x.val)) ||
                        isSibling(node.left, x, y) ||
                        isSibling(node.right, x, y)
        );
    }

    int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) {
            return 0;
        }
        if (node == x) {
            return lev;
        }
        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return ismirror(root.left,root.right);


    }
    private boolean ismirror(TreeNode leftsub,TreeNode rightsub){
        if(leftsub==null & rightsub==null){
            return true;
        }
        else if(leftsub==null || rightsub==null){
            return false;
        }

        return (leftsub.val==rightsub.val) && ismirror(leftsub.left,rightsub.right) && ismirror(leftsub.right,rightsub.left);

    }
    public BinaryTrees.TreeNode invertTree(BinaryTrees.TreeNode root) {
        if(root==null){
            return null;
        }
        BinaryTrees.TreeNode Temp=root.left;
        root.left=root.right;
        root.right=Temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
    public BinaryTrees.TreeNode invertTree2(BinaryTrees.TreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTrees.TreeNode left=invertTree2(root.left);
        BinaryTrees.TreeNode right=invertTree2(root.right);
        root.left=right;
        root.right=left;
        return  root;
    }
    public void flatten(TreeNode root) {

        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp=curr.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;

        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        return left==null ? right : left;
//        above return line means this way
//        if (left == null) {
//            return right;
//        } else {
//            return left;
//        }
    }
    private int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        int left= kthSmallest(root.left,k);
        if(left!=-1){
            return left;
        }
        count++;
        if(count==k){
            return root.val;
        }
        return kthSmallest(root.right,k);


    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int r=preorder[0];
        int index=0;

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==r){
                index=i;
            }
        }
        TreeNode node=new TreeNode(r);
        node.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;


    }
    public boolean haspathsum(BinaryTrees.TreeNode root,int targetsum){
        if(root==null){
            return false;
        }
        if(root.val==targetsum || root.left.val==targetsum || root.right.val==targetsum){
            return true;
        }
        return haspathsum(root.left,targetsum-root.val)|| haspathsum(root.right,targetsum-root.val);

    }
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    int helper(TreeNode node,int sum){
        if(node==null){
            return 0;
        }
        sum=sum*10+node.val;
        if(node.left==null && node.right==null){
            return sum;
        }
        return helper(node.left,sum)+helper(node.right,sum);
    }
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;

    }
    int helper(TreeNode node){
        if(node==null){
            return 0;
        }

        int left=helper(node.left);
        int right=helper(node.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int pathsum=left+right+node.val;
        ans=Math.max(ans,pathsum);
        return Math.max(left,right)+node.val;
    }
    boolean findpath(TreeNode node,int[] arr){
        if(node==null){
            return arr.length==0;
        }
        return helper(node,arr,0);
    }
    boolean helper(TreeNode node,int[] arr,int index){
        if(node==null){
            return false;
        }
        if(index>=arr.length || node.val!=arr[index]){
            return false;
        }
        if(node.left==null && node.right==null && index==arr.length-1){
            return true;
        }
        return helper(node.right,arr,index+1) || helper(node.right,arr,index+1);

    }
    int countallPaths(TreeNode node,int sum){
        List<Integer> path=new LinkedList<>();
        return helper(node,sum,path);
    }
    int helper(TreeNode node,int sum,List<Integer> path){
        if(node==null){
            return 0;
        }
        path.add(node.val);
        int count=0;
        int s=0;
        ListIterator<Integer> itr=path.listIterator(path.size());
        while (itr.hasPrevious()){
            s+=itr.previous();
            if(s==sum){
                count++;
            }

        }
        count +=helper(node.left,sum,path) +helper(node.right,sum,path);
//            backtracking
        path.remove(path.size()-1 );
        return count;

    }

//    now print all those path and put it into the list
    List<List<Integer>> findpaths(TreeNode node,int sum){
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> paths=new ArrayList<>();
    helper2(node,sum,path,paths);
    return paths;
}
    void helper2(TreeNode node,int sum,List<Integer> path,List<List<Integer>> paths){
        if(node==null){
            return;
        }
        path.add(node.val);
        if (node.val==sum && node.left==null &&node.right==null){
            paths.add(new ArrayList<>(path));
        }
        else{
            helper2(node.left,sum-node.val,path,paths);
            helper2(node.right,sum-node.val,path,paths);
        }

//            backtracking
        path.remove(path.size()-1 );


    }
    void dfsStack(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode removed=stack.pop();
            System.out.println(removed.val+" ");
            if(removed.right!=null){
                stack.push(removed.right);
            }
            if(removed.left!=null){
                stack.push(removed.left);
            }
        }
    }




}


