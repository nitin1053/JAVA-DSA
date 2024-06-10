package nitin.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class rep{
    public static void main(String[] args){
        skip("","baabdfefaajjn");
    }
    static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if (ch=='a'){
            skip(p,up.substring(1));
        }
        else{
            skip(p+ch,up.substring(1));

        }
    }

}
class rep1{
    public static void main(String[] args){
        System.out.println(skip("baabdfefaajjn"));
    }
    static String skip(String up){
        if(up.isEmpty()){
            // System.out.println(p);
            return "";
        }
        char ch=up.charAt(0);
        if (ch=='a'){
            return skip(up.substring(1));
        }
        else{
            return ch + skip(up.substring(1));

        }
    }

}


public class recursion1 {
    public static void main(String[] args){
        message();
    }
    static void message(){
        System.out.println("hello");
        message1();
    }
    static void message1(){
        System.out.println("hello");
        message2();
    }
    static void message2(){
        System.out.println("hello");
    }

}
class numberexp{
    public static void main(String[] args){
        //write a function that takes in anumber and print it
        // print first 5 numbers that is 12 345
        print1(1);

    }
    static void print1(int n){
        System.out.println(n);
        print2(2);

    }
    static void print2(int n){
        System.out.println(n);
        print3(3);

    }
    static void print3(int n){
        System.out.println(n);
        print4(4);

    }
    static void print4(int n){
        System.out.println(n);
        print5(5);

    }
    static void print5(int n){
        System.out.println(n);

    }
}


class numberdis{
    public static void main(String[] args){
        print(1);
    }
    static void print(int n){
        if(n==5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        print(n+1);
    }
//no base conditon -->function call will keep happening, at every call function will occupy some amount of space in it
}

//why recursion function calling itself, it help us sollving big que in simple way

//you can convert recur into iteration
//recursion space comp is not constant bcz of recursion calls

//que
class fibo{
    public static void main(String[] args){
        fiboo(7);
        System.out.println(fiboo(10));
    }
    static int fiboo(int n){
        if(n<2){
            return n;
        }
        return fiboo(n-1)+fiboo(n-2);
    }
}

/// working of variables
//
///
class BS1{
    public static void main(String[] args){
        int[] arr={1,56,789,7888,99888};
        System.out.println(bs(arr,789,0,arr.length-1));
    }
    static int bs(int[] arr,int target,int s,int e ){
        if(s>e){
            return -1;
        }
        int m=s + (e-s) / 2;
        if(arr[m]==target){
            return m;
        }
        if(arr[m]>target){
            return bs(arr,target,s,m-1);

        }
        return bs(arr, target, m+1, e);

    }

}


//recursion class 2

class n21{
    public static void main(String[] args){
        funBoth(5);
    }
    static void fun(int n){
        if(n==0){
            return;

        }
        System.out.println(n);
        fun(n-1);
    }
    static void funRev(int n){
        if(n==0){
            return;

        }

        funRev(n-1);
        System.out.println(n);
    }
    static void funBoth(int n){
        if(n==0){
            return;

        }


        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}

class fact{
    public static void main(String[] args){
        System.out.println(fact(5));
    }
    static int fact(int n){
        if(n<2){
            return 1;
        }
        return n*fact(n-1);
    }

}
class didgitsum{
    public static void main(String[] args){
        System.out.println(sum(1456));
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }
        return (n%10) +sum(n/10);
    }
}
class revnum{
    public static void main(String[] args){
        rev1(1367);
        System.out.println(sum);

    }
    static int sum=0;
    static void rev1(int n){
        if(n==0){
            return ;
        }
        int rem=n%10;
        sum=sum*10 + rem;
        rev1(n/10);
    }
    static int rev2(int n){
        int digits=(int)(Math.log10(n))+1;
        return helper(n,digits);
    }
    private static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return rem* (int)(Math.pow(10,digits-1)) +helper(n/10,digits);
    }
}

class palin{
    public static void main(String[] args){
        System.out.println(check(34566));
    }
    static int sum=0;
    static int rev2(int n){
        int digits=(int)(Math.log10(n))+1;
        return helper(n,digits);
    }
    private static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return rem* (int)(Math.pow(10,digits-1)) +helper(n/10,digits);
    }
    static boolean check(int n){
        return n == rev2(n);
    }
}
class countzero{
    public static void main(String[] args){
        System.out.println(count(606707070));
    }
    static int count(int n){
        return helper(n,0);
    }
    private static int helper(int n,int c){
        if(n==0){
            return c;
        }
        int rem=n%10;
        if(rem==0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);
    }
}

//class 3 recursion

class sorted_array{
    public static void main(String[] args){
        int[] arr={1,4,55,78,89,678,789};
        System.out.println(checks(arr,0));
    }
    static boolean checks(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && checks(arr,index+1);

    }

}

class linear_search{
    public static void main(String[] args){
        int[] arr={34,67,7776,776,653};
        System.out.println(check(arr,67,0));
        System.out.println(check1(arr,67,0));
    }
    static boolean check(int[] arr,int target,int index){
        if(index==arr.length){
            return false;
        }
        return arr[index]==target || check(arr,target,index+1);
    }
    static int check1(int[] arr,int target,int index){
        if(index==arr.length){
            return -1;
        }
        if (arr[index]==target){
            return index;
        }else{
            return check1(arr,target,index+1);
        }
    }
}
class arraylist {
    public static void main(String[] args){
        int[] arr={1,56,9,10,6,8,89,6,6};
        //findallIndex(arr,10,0);
        //System.out.println(list);
        //System.out.println(check2(arr,6,0,new ArrayList<>()));
        System.out.println(check3(arr,6,0));

    }
    static ArrayList<Integer> list=new ArrayList<>();
    static void findallIndex(int[] arr,int target,int index){
        if(index==arr.length){
            return;
        }
        if(arr[index]== target){
            list.add(index);
        }
        findallIndex(arr,target,index+1);

    }
    static ArrayList<Integer> check2(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return check2(arr,target,index+1,list);
    }
    static ArrayList<Integer> check3(int[] arr,int target,int index){
        ArrayList<Integer> l1=new ArrayList<>();
        if(index==arr.length){
            return l1;
        }
        if(arr[index]==target){
            l1.add(index);
        }
        ArrayList<Integer> ansfrombelow=check3(arr,target,index+1);
        l1.addAll(ansfrombelow);
        return l1;
    }




}
class RBS{
    public static void main(String[] args){
        int[] arr={4,6,8,9,10,88,67};
        System.out.println(search(arr,10,0,arr.length-1));
    }
    static int search(int[] arr,int target,int s,int e ){
        if(s>e){
            return -1;
        }
        int m=s+ (e-s) /2;
        if(arr[m]==target){
            return m;
        }
        if(arr[m]>arr[s]){
            if(target>=arr[s] && target<=arr[m]){
                search(arr,target,s,m-1);
            }else{
                return search(arr,target,m+1,e);
            }
        }
        if(target>=arr[m] && target<=arr[e]){
            return search(arr,target,m+1,e);
        }
        return search(arr,target,s,m-1);

    }
}


//
//Pattern based questions

/* * * * *
 * * *
 * *
 *


/*

 */
class p1{
    public static void main(String[] args){
        star(4,0);
        
    }
    static void star(int r ,int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print("*");
            star(r, c + 1);
        }
        else{
            System.out.println();
            star(r-1,0);
        }
    }
    static void bubble(int[] arr,int r ,int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if(arr[c]<arr[c+1])
            bubble(arr,r, c + 1);
        }
        else{
            System.out.println();
            bubble(arr,r-1,0);
        }
    }

}


///String, subsets question
//que 1 count a
class s1{
    public static void main(String[] args){
        skip("","avcxada");
        skipapple("aasddcdfsc");
        String n=skipApple("kapplelink");
        System.out.println(n);
        String a=skipnotapple("neappon");
        System.out.println(a);

    }
    static void skip(String p,String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            skip(p,up.substring(1));

        }
        else{
            skip(p+ch,up.substring(1));
        }
    }
    static String skipapple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch= up.charAt(0);
        if(ch=='a'){
            return skipapple(up.substring(1));

        }
        else{
            return ch + skipapple(up.substring(1));
        }
    }
    static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
    static String skipnotapple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipnotapple(up.substring(3));
        }else{
            return up.charAt(0)+skipnotapple(up.substring(1));
        }
    }
}

class s11{
    public static void main(String[] args){
        skip("","agbjcyinzkn");

    }
    public static void skip(String x, String y){
        if(y.isEmpty()){
            System.out.println(x);
            return;
        }
        char ch=y.charAt(0);
        if(ch=='a' || ch=='j'){
            skip(x+ch,y.substring(1));
            return;
        }
        else{
            skip(x,y.substring(1));
        }
    }

}



//subsets questions with permutation and combination or subsets
class s2{
    public static void main(String[] args){
        subseq(" ","abc");
//        System.out.println(subseq2(" ","abcn"));
//        subseqASCII(" ","abf");
//        System.out.println(subsseqASc(" ","abc"));

    }
    static void subseq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }
    static ArrayList<String> subseq2(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;


        }
        char ch=up.charAt(0);
        ArrayList<String> left=subseq2(p+ch,up.substring(1));
        ArrayList<String> right=subseq2(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    //ASCII val of the character ch+0
    static void subseqASCII(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subseqASCII(p+ch,up.substring(1));
        subseqASCII(p,up.substring(1));
        subseqASCII(p + (ch+0),up.substring(1));
    }
    static ArrayList<String> subsseqASc(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;


        }
        char ch=up.charAt(0);
        ArrayList<String> left=subsseqASc(p+ch,up.substring(1));
        ArrayList<String> right=subsseqASc(p,up.substring(1));
        ArrayList<String> third=subsseqASc(p+(ch+0),up.substring(1));
        left.addAll(right);
        left.addAll(third);
        return left;
    }
}
class subset1{
    public static void main(String[] args){
        int[] arr={1,2,2};
        /*List<List<Integer>> ans=subsetduplicate(arr);
        for(List<Integer> list:ans){
            System.out.print(list);
        }*/
        System.out.println();
    }
    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int size=outer.size();
            for(int i=0;i<size;i++){
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;


    }
    static List<List<Integer>> subsetduplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int start =0;
        int end =0;
        for(int i=0;i<arr.length;i++){
            start=0;
                //if current and previous element is same,s=e+1
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for (int j=start;j<n;j++){
                List<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }

        }
    

        return outer;


    }
}
//premutation calls
// at every process calls are getting been made
// like for 'abc' as we go down no call p(size)+1 p=process
class permu{
    public static void main(String[] args){
        //permt("","abc");
        ArrayList<String> ans=perm2("","abc");
        //for(String g:ans){
          //  System.out.println(g);
        //}
        System.out.println(ans);
        System.out.println(permt3("","abc"));
    }
    static void permt(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String l=p.substring(i,p.length());
            permt(f + ch +l,up.substring(1));
        }
    }
   static ArrayList<String> perm2(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> x=new ArrayList<>();
            x.add(p);
            return x;

        }
        char ch=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
           String f=p.substring(0,i);
           String l=p.substring(i,p.length());
           ans.addAll(perm2(f + ch +l,up.substring(1)));
       }
       return ans;
   }
    static int permt3(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String l=p.substring(i,p.length());
            count=count+permt3(f + ch +l,up.substring(1));
        }
        return count;
    }

}

class sol{
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1, 2}};
        int result = findJudge(n, trust);
        System.out.println("The town judge is: " + result);
    }


    public static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1]; // We use n + 1 to make indexing easier

        for (int[] relation : trust) {
            System.out.println(relation);
            int a = relation[0];
            int b = relation[1];
            trustCount[a]--; // Decrease trust count for person a
            trustCount[b]++; // Increase trust count for person b
            System.out.println(relation);
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i; // The person with trust count of n - 1 is the town judge
            }
        }


        return -1; // No town judge found
    }
    public int findjudge(int n, int[][] trust) {
        int[] trustcount=new int[n+1];
        for(int[] relation:trust){
            int a=relation[0];
            int b=relation[1];
            trustcount[a]--;
            trustcount[b]++;
        }
        for(int i=1;i<n;i++){
            if(trustcount[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
