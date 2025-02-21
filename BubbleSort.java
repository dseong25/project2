/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the Bubble Sort algorithm.
 */

package Project2;

public class BubbleSort {
    // Sorts an array using Bubble Sort.
    public static void sort(int[] data, int n) {
        int swaps = 1; // Tracks whether any swaps were made in the last pass
        
        // Continue looping until no swaps are made (indicating the array is sorted)
        while (swaps != 0) {
            swaps = 0; // Reset swap count for this pass
            
            // Iterate through the array and swap adjacent elements if needed
            for (int i = 0; i < n - 1; ++i) {
                SortingUtility.comparisons++; // Count comparisons
                
                if (data[i] > data[i + 1]) { // If elements are out of order, swap them
                    SortingUtility.swap(data, i, i + 1);
                    swaps++; // Increment swap count
                }
            }
        }
    }
}
