package oops_java.acces;

import java.util.Scanner;

//package oops_java.acces;
import java.util.Scanner;
//import java.util.scanner;
public class st{
    public static void main(String[] args){
        Scanner d=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n=d.nextInt();
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<2*i;j++){
                System.out.print("*");
            }
            System.out.println();

        }

    }
}

class bs1{
    public static void main(String[] args){
        int[] a={5,7,9,23,57};
        System.out.println(search(a,23));
    }
    static int search(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid =start + (end - start)/2;
            if(target< arr[mid]){
                end=mid-1;
            }
            else if(target> arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}

class ceiling{
    public static void main(String[] args){
        int[] a={5,7,9,23,57};
        System.out.println(search(a,22));
    }
    static int search(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid =start + (end - start)/2;
            if(target< arr[mid]){
                end=mid-1;
            }
            else if(target> arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return start;
    }
}
class floor{
    public static void main(String[] args){
        int[] a={5,7,9,23,57};
        System.out.println(search(a,6));
    }
    static int search(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid =start + (end - start)/2;
            if(target< arr[mid]){
                end=mid-1;
            }
            else if(target> arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return end;
    }
}

class leetcode744{
    public static void main(String[] args){
        String[] a={"c","f","j"};
        char ans= nextGreatestLetter("a".toCharArray(), 'f');
        System.out.println(ans);
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid =start + (end - start)/2;
            if(target< letters[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return letters[start % letters.length] ;
    }
}

//nxt leet code que [5,7,7,7,7,8,8,10] target 7 fid last occurance and the first occurance
//use binary search twice first for finding the first occurance and secoond for last occurance

//logn complexity
// first half e=mid-1, start =mid+1
//
//
class leetcode34{
    public static void main(String[] args){
        int[] nums={3,5,5,5,5,5,7,8,99,99,99};

    }
    public int[] searchRange(int[] nums, int target){
        int [] ans = {-1, - 1};
        int start=search(nums,target,true);
        int end =search(nums,target,false);
        ans[0]=start;
        ans[1]=end;
        return ans;
    }
//    this function will return the index value what we want to search
    int search(int[] nums,int target,boolean findstartindex){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
//        int mid=start+(end-start)/2;
        while(end>=start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans=mid;
                if (findstartindex == true){
                    end=mid-1;

                }else{
                    start=mid+1;
                }
            }
        }
        return ans;

    }
}

//infinite array questions
//[2,3,5,6,7,8,10,11,12,15]
//target=15
//we can find whoess things in specificing some chunks so that in each chunkswe will try to verify it with target element
class infinite_array_bs{
    public static void main(String[] args){
        ///start with the box of 2
        int[] arr={2,3,5,6,7,8,10,11,12,15};
        int target=10;
        System.out.println(ans(arr,target));
    }
    static int ans(int[] arr,int target){
//        first startwith a box 2
        int start=0;
        int end=1;
        //condition for target t lie in range
        while (target > arr[end]){
            int newstart=end+1;
            //double the chunks box value
//            end=previous end+size of box*2
            end=end + (end-start+1) * 2 ;
            start=newstart;


        }
        return binarysearch(arr,target,start,end);
    }
    static int binarysearch(int [] arr,int target,int start,int end){

        while(start<=end){
            int mid =start + (end - start)/2;
            if(target< arr[mid]){
                end=mid-1;
            }
            else if(target> arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(ans(arr, target));
    }
    static int ans(int[] arr, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > arr[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);

    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
}

class peak_index {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;

        while (start < end){

            int mid=start+(end-start)/2;
            if(arr[mid] > arr[mid+1]){
                end=mid;
            }
            else
            {
                start=mid+1;
            }
        }

        return start;


    }
}

//class Solution {
//    public int findInMountainArray(int target, MountainArray mountainArr) {
//        int start=0;
//        int end =mountainArr.length()-1;
//        while(start<end){
//            int mid=start+(end-start)/2;
//            if(mountainArr.get(mid) < target){
//                start=mid+1;
//            }
//            else if(mountainArr.get(mid) > target){
//                end=mid-1;
//            }else{
//                return mid;
//            }
//        }
//        return -1;
//
//    }
//}


class Mountain {
    public static void main(String[] args) {

    }
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // https://leetcode.com/problems/find-peak-element/
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }
}

class OrderAgnosticBS {
    public static void main(String[] args) {
//        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int target = 22;
        int ans = orderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}


class SearchInMountain {
    public static void main(String[] args) {

    }
    // https://leetcode.com/problems/find-in-mountain-array/
    int search(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // try to search in second half
        return orderAgnosticBS(arr, target, peak+1, arr.length - 1);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

class rotational_binary_search{
    public static void main(String[] args){
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(findpivoid(arr));
    }
    static int search(int[] nums,int target) {
        int pivot = findpivoid(nums);
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length-1);

        }
        if (nums[pivot]==target){
            return pivot;
        }
        if (target>=nums[0]){
            return binarySearch(nums,target,0,pivot-1);

        }
        return binarySearch(nums,target,pivot+1,nums.length-1);

    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
    static int findpivoid(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;

            if (mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if (mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}


class rotational_binary_search_for_duplicate{
    public static void main(String[] args){
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(findpivoid(arr));
    }
    static int search(int[] nums,int target) {
        int pivot = findpivoid(nums);
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length-1);

        }
        if (nums[pivot]==target){
            return pivot;
        }
        if (target>=nums[0]){
            return binarySearch(nums,target,0,pivot-1);

        }
        return binarySearch(nums,target,pivot+1,nums.length-1);

    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
    //this is upgrade for duplicatess_--->mentioned below
    static int findpivoid(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if (mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if (mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if (nums[mid]==nums[start] && nums[mid]==nums[end]){
                if(nums[start]>nums[start+1]){
                    return start;
                }
                start++;
                if (nums[end]<nums[end-1]){
                    return end-1;
                }
                end--;
//                note:if these element may be pivot then
            }
//            left side is sorted so pivot should be in right
            else if(nums[start]<nums[mid] || (nums[start]==nums[mid] && nums[mid]>nums[end])){
                start=mid+1;

            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}

class rotationalcount{
    public static void main(String[] args){
        int[] arr ={1, 2, 3, 4, 5, 6};
        System.out.println(countrotation(arr));
    }
    private static int countrotation(int[] arr){
        int pivot=findpivoid(arr);
        return pivot+1;
    }
//    for non duplicates
    static int findpivoid(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;

            if (mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if (mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    //use this for duplicates
    static int findpivoid_dupli(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if (mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if (mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if (nums[mid]==nums[start] && nums[mid]==nums[end]){
                if(nums[start]>nums[start+1]){
                    return start;
                }
                start++;
                if (nums[end]<nums[end-1]){
                    return end-1;
                }
                end--;
//                note:if these element may be pivot then
            }
//            left side is sorted so pivot should be in right
            else if(nums[start]<nums[mid] || (nums[start]==nums[mid] && nums[mid]>nums[end])){
                start=mid+1;

            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}


class splitArray{
    public static void main(String[] args){
        int[] arr ={1, 2, 3, 4, 5, 6};
        System.out.println(splitArray(arr,2));
    }
    public static int splitArray(int[] nums, int m){
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            start=Math.max(start,nums[i]);
//            int he end of the loop this will contain max item from array

            end+=nums[i];
        }
//        binary search
        while(start<end){
//            try mid as ans
            int mid=end+(end-start)/2;
            //calculate pieces to divide
            int sum=0;
            int perce=1;
            for(int num:nums){
                if(sum+num>mid){
//                    you cannot add this in this subarray
//                    say you add this num in new subarray
                    sum=num;
                    perce++;
                }else{
                    sum+=num;

                }
            }
            if (perce>m){
                start=mid+1;

            }else{
                end=mid;
            }
        }
        return end;//here start=end
    }
}