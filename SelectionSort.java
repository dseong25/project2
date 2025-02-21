/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the Selection Sort algorithm.
 */

package Project2;

public class SelectionSort {
    // Sorts an array using Selection Sort.
    public static void sort(int[] data, int n) {
        // Iterate from the end of the array towards the beginning
        for (int lue = n - 1; lue > 0; --lue) {
            // Find the index of the maximum element in the unsorted portion of the array
            int idx = findMax(data, lue);
            // Swap the maximum element with the last element of the unsorted portion
            SortingUtility.swap(data, idx, lue);
        }
    }

    // Finds the index of the maximum element in the array up to a given index.
    public static int findMax(int[] data, int idx) {
        int tmp = 0; // Assume the first element is the maximum initially
        // Iterate through the array to find the maximum value
        for (int i = 0; i <= idx; ++i) {
            if (data[i] > data[tmp]) {
                tmp = i; // Update the index of the maximum element
            }
        }
        return tmp; // Return the index of the maximum element found
    }
}
