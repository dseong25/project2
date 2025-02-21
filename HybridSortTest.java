/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class tests the HybridSort algorithm using different test cases.
 */

package Project2;

import java.util.Random;

public class HybridSortTest {
    public static void main(String[] args) {
        // Test cases with different array sizes and sorting conditions

        // Very Small (<50): nearly sorted and unsorted
        testCase("Very Small - Nearly Sorted", 20, true);
        testCase("Very Small - Not Nearly Sorted", 20, false);

        // Small (50-500): nearly sorted and unsorted
        testCase("Small - Nearly Sorted", 200, true);
        testCase("Small - Not Nearly Sorted", 200, false);

        // Medium (500-5000): nearly sorted and unsorted
        testCase("Medium - Nearly Sorted", 1000, true);
        testCase("Medium - Not Nearly Sorted", 1000, false);

        // Large (5000+): nearly sorted and unsorted
        testCase("Large - Nearly Sorted", 6000, true);
        testCase("Large - Not Nearly Sorted", 6000, false);
    }

    // Generates a test case with the specified size and sorting condition.
    private static void testCase(String testName, int size, boolean nearlySorted) {
        int[] data = new int[size];
        Random rand = new Random();

        if (nearlySorted) {
            // Create a sorted array
            for (int i = 0; i < size; i++) {
                data[i] = i;
            }
            // Introduce a small number of adjacent swaps to simulate "nearly sorted" data.
            int swaps = Math.max(1, size / 20); 
            for (int i = 0; i < swaps; i++) {
                int index = rand.nextInt(size - 1);
                int temp = data[index];
                data[index] = data[index + 1];
                data[index + 1] = temp;
            }
        } else {
            // Create a random (unsorted) array
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size);
            }
        }
        
        System.out.println("============================================");
        System.out.println("Test Case: " + testName + " (size = " + size + ")");
        
        // Call the hybrid sort (this will print which algorithm is chosen)
        HybridSort.sort(data, size);
        
        // Verify if the array is sorted
        if (isSorted(data)) {
            System.out.println("Result: Array sorted successfully.\n");
        } else {
            System.out.println("Result: Sorting failed.\n");
        }
    }
    
    // Checks if an array is sorted in ascending order.
    private static boolean isSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
