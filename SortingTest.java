package Project2;

import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        // Various test arrays for sorting
        int[] testArray = {3, 2, 5, 1, 4};
        int[] anotherTestArray = {10, 7, 8, 9, 1};
        int[] preSortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] reverseSortedArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] randomArray = {42, 17, 93, 8, 56, 21, 77, 30};
        int[] duplicateArray = {5, 1, 3, 3, 2, 1, 5, 4, 2, 4};
        int[] singleElementArray = {42};
        int[] evenSizeArray = {8, 3, 7, 1, 6, 5};
        int[] oddSizeArray = {7, 3, 1, 9, 5};
        int[] powerOfTwoArray2 = new int[2];
        int[] powerOfTwoArray4 = new int[4];
        int[] powerOfTwoArray8 = new int[8];
        
        for (int i = 0; i < 2; i++) powerOfTwoArray2[i] = (int) (Math.random() * 100);
        for (int i = 0; i < 4; i++) powerOfTwoArray4[i] = (int) (Math.random() * 100);
        for (int i = 0; i < 8; i++) powerOfTwoArray8[i] = (int) (Math.random() * 100);
        
        // List of sorting algorithms to be tested
        String[] sortingAlgorithms = {
            "BogoSort", "SelectionSort", "InsertionSort", "BubbleSort",
            "MergeSort", "QuickSort", "SleepSort", "GnomeSort"
        };

        // Array of test cases
        int[][] testCases = {
            testArray, anotherTestArray, preSortedArray, reverseSortedArray,
            randomArray, duplicateArray, singleElementArray, evenSizeArray, 
            oddSizeArray, powerOfTwoArray2, powerOfTwoArray4, 
            powerOfTwoArray8
        };

        // Loop through each sorting algorithm and test it
        for (String algorithm : sortingAlgorithms) {
            System.out.println("Testing " + algorithm + ":");
            
            for (int[] testCase : testCases) {
                int[] arrayCopy = Arrays.copyOf(testCase, testCase.length);
                System.out.println("Original Array: " + Arrays.toString(arrayCopy));
                sortArray(algorithm, arrayCopy, arrayCopy.length);
                System.out.println("Sorted Array: " + Arrays.toString(arrayCopy));
                System.out.println();
            }
        }
    }

    // Calls the appropriate sorting algorithm based on the given name.
    private static void sortArray(String algorithm, int[] array, int size) {
        switch (algorithm) {
            case "BogoSort":
                BogoSort.sort(array, size);
                break;
            case "SelectionSort":
                SelectionSort.sort(array, size);
                break;
            case "InsertionSort":
                InsertionSort.sort(array, size);
                break;
            case "BubbleSort":
                BubbleSort.sort(array, size);
                break;
            case "MergeSort":
                MergeSort.sort(array, size);
                break;
            case "QuickSort":
                QuickSort.sort(array, size);
                break;
            case "SleepSort":
                SleepSort.sort(array, size);
                break;
            case "GnomeSort":
                GnomeSort.sort(array, size);
                break;
        }
    }
}