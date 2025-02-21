/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class implements the Merge Sort algorithm.
 */

package Project2;

public class MergeSort {

    // Method to run the sort
    public static void sort(int[] arr, int n) {
        sortR(arr, n, 0);
    }

    // Recursive function that sorts the array using Merge Sort.
    public static void sortR(int[] arr, int n, int k) {
        if (n == 2 && arr[k] > arr[k + 1]) {
            // Swap if only two elements exist and are out of order
            SortingUtility.swap(arr, k, k + 1);
        } else if (n <= 2) {
            return; // Base case: Single-element partitions are already sorted
        } else {
            // Split the array into two halves
            int[] na = split(arr, n, k);
            // Recursively sort both halves
            sortR(arr, n / 2 + n % 2, k); // Sort left half
            sortR(na, n / 2, 0);          // Sort right half
            // Merge the sorted halves back together
            merge(arr, na, n, k);
        }
    }

    // Splits the right half of the array into a new array.
    public static int[] split(int[] arr, int n, int k) {
        int[] na = new int[n / 2]; // Allocate space for the right half
        for (int i = 0; i < n / 2; ++i) {
            na[i] = arr[i + k + (n - n / 2)]; // Copy right half into na
        }
        return na;
    }

    // Merges two sorted subarrays back into the main array in sorted order.
    public static void merge(int[] arr, int[] na, int n, int k) {  
        int leftSize = n / 2 + n % 2;  // Determine the size of the left half in arr.
        int idxA = 0;    // Index for the right half stored in na (size n/2)
        int idxB = k;    // Index for the left half stored in arr (size leftSize)
        int idxC = k;    // Index for temporary merged output
        int[] temp = new int[n]; // Temporary array to store merged result

        // Merge elements from both halves into temp array
        while (idxC < k + n) {
            SortingUtility.comparisons++; // Track number of comparisons

            // If both halves have elements remaining, compare and take the smaller one
            if (idxA < n / 2 && idxB < k + leftSize) {
                if (na[idxA] < arr[idxB]) {
                    temp[idxC - k] = na[idxA];
                    idxA++;
                } else {
                    temp[idxC - k] = arr[idxB];
                    idxB++;
                }
            } 
            // If right half still has elements, copy them
            else if (idxA < n / 2) {
                temp[idxC - k] = na[idxA];
                idxA++;
            } 
            // If left half still has elements, copy them
            else {
                temp[idxC - k] = arr[idxB];
                idxB++;
            }
            idxC++;
        }

        // Copy sorted elements back into original array
        for (int i = 0; i < n; i++) {
            arr[k + i] = temp[i];
        }
    }      
}