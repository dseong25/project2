/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements Sleep Sort, a unique sorting algorithm that utilizes threading.
 */

package Project2;

import java.util.Arrays;

public class SleepSort {
    private static int[] sortedNumbers; // Stores sorted output
    private static int index; // Tracks insertion position in sortedNumbers

    // Sorts an array using Sleep Sort.
    public static void sort(int[] data, int n) {
        index = 0;
        sortedNumbers = new int[n];

        // Loop through each number in the array
        for (int num : data) {
            new Thread(() -> {
                try {
                    // Sleep for a duration proportional to the number's value.
                    Thread.sleep(num * 10);  

                    // Synchronize access to sortedNumbers, avoids race conditions
                    synchronized (sortedNumbers) {
                        sortedNumbers[index++] = num;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage()); // Print any exceptions
                }
            }).start();
        }

        // Determine the maximum value in the dataset to set an appropriate wait time
        int max = Arrays.stream(data).max().getAsInt(); 
        try {
            // Ensure all sorting threads have finished before copying sorted values
            Thread.sleep(max * 11); // 11 since we have to overadjust
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Copy the sorted values back into the original array
        System.arraycopy(sortedNumbers, 0, data, 0, n);
    }
}