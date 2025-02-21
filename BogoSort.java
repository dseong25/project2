/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the BogoSort algorithm in Java.
 */

package Project2;

public class BogoSort {
    // The sorting method
    public static void sort(int[] data, int n) {
        // Continue shuffling the array until it becomes sorted
        while (!SortingUtility.isSorted(data, n)) {
            // Randomly shuffle the array
            SortingUtility.shuffle(data, n);
        }
    }
}
