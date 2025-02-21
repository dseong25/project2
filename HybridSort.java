/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements a hybrid sorting algorithm.
 * It selects an appropriate sorting algorithm based on dataset size and whether 
 * the array is nearly sorted.
 */

package Project2;

public class HybridSort {

    // Sorts the given array using a hybrid sorting approach.
    public static void sort(int[] data, int n) {
        boolean nearlySorted = isNearlySorted(data, n);
        
        if (n < 50) {  // Very Small datasets (<50)
            if (nearlySorted) {
                BubbleSort.sort(data, n);
            } else {
                InsertionSort.sort(data, n);
            }
        } else if (n < 500) {  // Small datasets (50-500)
            if (nearlySorted) {
                BubbleSort.sort(data, n);
            } else {
                InsertionSort.sort(data, n);
            }
        } else if (n < 5000) {  // Medium datasets (500-5000)
            MergeSort.sort(data, n);  // MergeSort is used regardless of "nearlySorted" status
        } else {  // Large datasets (5000+)
            QuickSort.sort(data, n);  // QuickSort is used regardless of "nearlySorted" status
        }
    }

    // Determines if an array is nearly sorted.
    private static boolean isNearlySorted(int[] data, int n) {
        int inversionCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (data[i] > data[i + 1]) {
                inversionCount++;
            }
        }
        // Nearly sorted if ≤ 10% adjacent inversions
        return inversionCount <= (n - 1) * 0.1;
    }
}
