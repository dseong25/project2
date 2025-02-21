/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This utility class provides common functions used in the sorting algorithms.
 */

package Project2;
import java.util.Random;

public class SortingUtility {
    static Random random = new Random();
    static int comparisons; // Counter to track the number of comparisons made by sorting algorithms

    // Resets the comparison count to zero.
    public static void resetCounts() {
        comparisons = 0;
    }

    // Swaps two elements in an array.
    public static void swap(int[] data, int i, int j) {
        int temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

    // Checks if an array is sorted in ascending order.
    public static boolean isSorted(int[] data, int n) {
        for (int i = 1; i < n; ++i) {
            if (data[i] < data[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Randomly shuffles the elements of an array.
    public static void shuffle(int[] data, int n) {
        for (int i = 0; i < n; ++i) {
            int rindex = random.nextInt(n); // Generate a random index
            swap(data, i, rindex); // Swap the current element with a random element
        }
    }
}
