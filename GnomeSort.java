/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the Gnome Sort algorithm.
 */

package Project2;

public class GnomeSort {
    // Sorts an array using Gnome Sort.
    public static void sort(int[] data, int n) {
        // Trivial case: If the array has 1 or no elements, it's already sorted.
        if (n <= 1) return;

        int index = 0;

        // Iterate through the array
        while (index < n) {
            if (index == 0 || data[index] >= data[index - 1]) {
                // If at the start or elements are in order, move forward
                index++;
            } else {
                // If elements are out of order, swap and move backward
                SortingUtility.swap(data, index, index - 1);
                index--;
            }
        }
    }
}