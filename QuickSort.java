/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the Quick Sort algorithm with optimizations.
 */

package Project2;

public class QuickSort {
    // Threshold for switching to insertion sort on small subarrays.
    private static final int INSERTION_SORT_THRESHOLD = 20;
    
    
    // Method to initiate the QuickSort process.
    public static void sort(int[] data, int n) {
        quickSort(data, n, 0, n - 1);
    }
    
    // Recursively sorts the array using QuickSort.
    static void quickSort(int[] arr, int n, int low, int high) {
        // If the subarray is small, use insertion sort.
        if (high - low + 1 <= INSERTION_SORT_THRESHOLD) {
            int len = high - low + 1;
            int[] temp = new int[len];
            System.arraycopy(arr, low, temp, 0, len); // Copy subarray into temp
            InsertionSort.sort(temp, len); // Sort using Insertion Sort
            System.arraycopy(temp, 0, arr, low, len); // Copy sorted subarray back
            return;
        }
        
        if (low < high) {
            // Adaptive pivot selection using median-of-three.
            int mid = low + (high - low) / 2;
            int pivotIndex = medianOfThree(arr, low, mid, high);
            // Partition the array around the pivot.
            int p = partition(arr, high - low + 1, low, pivotIndex);
            // Recursively sort both partitions.
            quickSort(arr, n, low, p - 1);
            quickSort(arr, n, p + 1, high);
        }
    }
    
    // Partitions the array around a pivot, placing smaller elements on the left and larger elements on the right.
    public static int partition(int[] arr, int n, int k, int p) {
        int idxL = k; // Left index
        int idxR = k + n - 1;  // Right index (last element in the subarray)
        SortingUtility.swap(arr, idxL, p); // Move pivot to the start
        p = idxL; // Update pivot position
        
        while (idxL < idxR) {
            // Move idxR left until an element less than the pivot is found.
            while (idxL < idxR && arr[p] <= arr[idxR]) {
                idxR--;
            }
            SortingUtility.swap(arr, idxL, idxR);
            p = idxR;
            
            // Move idxL right until an element greater than pivot is found.
            while (idxL < idxR && arr[idxL] <= arr[p]) {
                idxL++;
            }
            SortingUtility.swap(arr, idxL, idxR);
            p = idxL;
        }
        return p;
    }
    
    // Uses the median-of-three method to select a pivot.
    private static int medianOfThree(int[] arr, int low, int mid, int high) {
        int a = arr[low];
        int b = arr[mid];
        int c = arr[high];
        
        // Compare a, b, and c to find the median value.
        if (a > b) {
            if (b > c) {
                return mid;    // a > b > c
            } else if (a > c) {
                return high;   // a > c >= b
            } else {
                return low;    // c >= a > b
            }
        } else { // a <= b
            if (a > c) {
                return low;    // b >= a > c
            } else if (b > c) {
                return high;   // b > c >= a
            } else {
                return mid;    // c >= b >= a
            }
        }
    }
}
