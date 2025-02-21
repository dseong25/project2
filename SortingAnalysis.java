/*
 * Author: Daniel Seong
 * Course: CSC551
 * Date: February 19, 2025
 * 
 * This class analyzes the performance of different sorting algorithms.
 */

package Project2;

import java.util.Random;

public class SortingAnalysis {
    public static void main(String[] args) {
        // Define dataset sizes to test
        int[] sizes = {100, 1000, 5000};

        // Define different data distributions to evaluate sorting performance
        String[] types = {"Random", "Sorted", "Reverse Sorted", "Nearly Sorted"};
        
        // Iterate through different dataset sizes
        for (int size : sizes) {
            System.out.println("\nDataset size: " + size);

            // Test sorting for each dataset type
            for (String type : types) {
                int[] data = generateData(size, type);
                System.out.println("\nData Type: " + type);
                
                // Evaluate different sorting algorithms
                evaluateSort("BubbleSort", data.clone(), BubbleSort::sort);
                evaluateSort("MergeSort", data.clone(), MergeSort::sort);
                evaluateSort("InsertionSort", data.clone(), InsertionSort::sort);
                evaluateSort("QuickSort", data.clone(), QuickSort::sort);
            }
        }
    }
    
    // Generates an array of integers based on the specified type.
    private static int[] generateData(int size, String type) {
        Random rand = new Random();
        int[] data = new int[size];
        
        switch (type) {
            case "Random":
                // Generate an array of random numbers
                return rand.ints(size, 0, size * 10).toArray();
            case "Sorted":
                // Generate a sorted array from 0 to value size
                return java.util.stream.IntStream.range(0, size).toArray();
            case "Reverse Sorted":
                // Generate a reverse-sorted array from size down to 1
                return java.util.stream.IntStream.iterate(size, i -> i - 1).limit(size).toArray();
            case "Nearly Sorted":
                // Start with a sorted array
                data = java.util.stream.IntStream.range(0, size).toArray();
                // Introduce a small number of swaps to simulate near-sorted data
                for (int i = 0; i < size / 10; i++) {
                    int idx1 = rand.nextInt(size);
                    int idx2 = rand.nextInt(size);
                    SortingUtility.swap(data, idx1, idx2);
                }
                return data;
            default:
                return data;
        }
    }
    
    // Evaluates the performance of a sorting algorithm.
    private static void evaluateSort(String name, int[] data, SortAlgorithm algorithm) {
        // Reset sorting metrics
        SortingUtility.resetCounts();

        // Capture memory usage before sorting
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        // Perform the sorting operation
        algorithm.sort(data, data.length);

        // Capture memory usage and time after sorting
        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // Print sorting performance results
        System.out.println(name + " - Time: " + (endTime - startTime) / 1e6 + " ms, Comparisons: " + SortingUtility.comparisons + ", Memory Used: " + (endMemory - startMemory) + " bytes");
    }
    
    // Functional interface to allow passing different sorting algorithms as parameters.
    @FunctionalInterface
    interface SortAlgorithm {
        void sort(int[] data, int n);
    }
}
