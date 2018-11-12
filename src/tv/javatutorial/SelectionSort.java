package tv.javatutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        System.out.println("Selection Sort");
        try (Scanner in = new Scanner(new File(".//src//sort.txt"))) {
            int testCaseCount = in.nextInt();
            System.out.println("Test Case Count: " + testCaseCount);
            for (int i = 0; i < testCaseCount; i++) {
                int length = in.nextInt();
                int input[] = readArray(in, length);
                sort(input);
                if (!isArraySorted(input)) { // test it
                    System.out.println("Array is not sorted for Test No: " + testCaseCount);
                }
            }
        }
        System.out.println("Complete");

    }

    private static boolean isArraySorted(int[] input) {
        if (input.length <= 1)
            return true;

        for (int i = 1; i < input.length; i++) {
            if(input[i-1] > input[i])
                return false;
        }
        return true;
    }

    private static int[] readArray(Scanner in, int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    private static void sort(int a[])
    {
        int min, minIndex;

        for (int i = 0; i < a.length; i++) {
            min = a[i]; minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
