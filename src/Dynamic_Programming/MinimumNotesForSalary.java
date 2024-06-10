package Dynamic_Programming;

import java.util.Arrays;

public class MinimumNotesForSalary {

    public static int minNotesForSalary(int N, int[] salaries) {
        // Sort the salaries
        Arrays.sort(salaries);

        // Calculate the total salary
        int totalSalary = 0;
        for (int salary : salaries) {
            totalSalary += salary;
        }

        // Calculate the original number of notes required
        int originalNotes = (totalSalary + N - 1) / N;

        // Calculate the median salary
        int medianSalary = salaries[N / 2];

        // Calculate the number of notes required if we change the salary of one person to the median salary
        int medianNotes = (medianSalary + N - 1) / N;

        // Return the minimum of original and median notes count
        return Math.min(originalNotes, medianNotes);
    }

    public static void main(String[] args) {
        // Example input
        int[] salaries = {2, 4, 6, 3};
        int N = 4;

        // Calculate and print the minimum number of notes required
        System.out.println("Minimum number of notes required: " + minNotesForSalary(N, salaries));
    }
}

