package Dynamic_Programming;

//Statement: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...], determine if a person could attend all meetings.
//
//Example:
//Input: [[0,30],[5,10],[15,20]]
//Output: false


import java.util.ArrayList;

public class meeting {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> Interval=new ArrayList<>();
        ArrayList<Integer> interval1=new ArrayList<>();

        interval1.add(0,0);
        interval1.add(1,30);
        Interval.add(interval1);
        ArrayList<Integer> interval2=new ArrayList<>();
        interval2.add(0,5);
        interval2.add(1,10);
        Interval.add(interval2);
        ArrayList<Integer> interval3=new ArrayList<>();
        interval3.add(0,15);
        interval3.add(1,20);
        Interval.add(interval3);
        canAttendMeetings(Interval);



    }
    public static boolean canAttendMeetings(ArrayList<ArrayList<Integer>> Interval) {
        boolean result=false;
        if (Interval==null || Interval.size()==0) return false;

        for (int i = 0; i < Interval.size(); i++) {
            for (int j = 0; j < Interval.get(i).size(); j++) {
                if(Interval.get(i).get(j)<=Interval.get(i+1).get(j)){
                    result= true;
                }
                else {
                    result= false;
                }
            }
        }
        return result;
    }
}
