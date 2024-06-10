package oops_java.acces;

import java.util.Scanner;

public class star1{
    public static void main(String[] args){
        Scanner c= new Scanner(System.in);
        int n=c.nextInt(1);
        for (int i=1;i<=n;i++ ){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();

        }

    }
}