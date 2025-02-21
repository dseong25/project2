/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the Insertion Sort algorithm.
 */

package Project2;

public class InsertionSort {

    // Sorts an array using Insertion Sort.
    public static void sort(int[] data, int n) {
        for (int i = 1; i < n; ++i) {
            // Compare and swap backwards to find the correct position
            for (int j = i; j > 0; --j) {
                SortingUtility.comparisons++; // Count each comparison
                
                // If the current element is smaller than the previous, swap them
                if (data[j] < data[j - 1]) {
                    SortingUtility.swap(data, j, j - 1);
                }
            }
        }
    }
}
