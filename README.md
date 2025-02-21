Sorting Algorithms Project

Overview

This project implements and analyzes various sorting algorithms, including both traditional and unconventional methods. The goal is to evaluate their performance on different types of datasets and optimize sorting efficiency using a HybridSort approach. Additionally, modifications were made to QuickSort for better performance.

Implemented Sorting Algorithms

The following sorting algorithms were implemented:

Bogosort – A highly inefficient sort used for demonstration.

BubbleSort – A simple but slow comparison-based algorithm.

InsertionSort – Efficient for small or nearly sorted datasets.

SelectionSort – A comparison-based sorting method.

MergeSort – A stable, divide-and-conquer sorting algorithm.

QuickSort – A fast sorting algorithm optimized with modifications.

GnomeSort – A variation of insertion sort.

SleepSort – A unique timing-based sorting technique.

Sorting Test Framework

A SortingTest file was created to test the sorting algorithms against various dataset types:

Pre-sorted array – Measures best-case performance.

Reverse-sorted array – Tests worst-case scenarios.

Random array – Evaluates average-case performance.

Array with duplicates – Assesses stability in sorting.

Single-element array – Tests edge cases.

Odd-sized array – Ensures sorting works with uneven lengths.

Even-sized array – Evaluates sorting on uniform-length datasets.

Power-of-2-sized array – Examines performance in cases often optimized in algorithms.

Sorting Analysis

A SortingAnalysis file was created to measure key performance metrics of each sorting algorithm, including:

Number of comparisons – Measures efficiency of element comparisons.

Memory usage – Evaluates space complexity.

Execution time – Tracks overall speed.

HybridSort Implementation

A custom HybridSort algorithm was developed to optimize sorting efficiency by dynamically switching between sorting algorithms based on dataset size and state. The strategy includes:

InsertionSort for very small datasets (<50 elements) or nearly sorted data.

BubbleSort for small, nearly sorted datasets.

MergeSort for medium-sized datasets (500-5000 elements).

QuickSort for large datasets (>5000 elements).

QuickSort Modifications

Two key optimizations were applied to QuickSort:

Switching to InsertionSort when subarrays become small, as InsertionSort is faster for small datasets.

Choosing the median of the low, mid, and high indexes as the pivot to enhance partitioning efficiency.

Utility Functions

Commonly used methods shared across sorting algorithms, such as swap(int[] data, int i, int j), are stored in a separate SortingUtility.java file to reduce redundancy and improve maintainability.

How to Run the Project

Compile the Java files:

javac Project2/*.java

Run the sorting test:

java Project2.SortingTest

Run the sorting analysis:

java Project2.SortingAnalysis

Future Improvements

Implement additional sorting algorithms for further comparison.

Optimize memory usage in MergeSort.

Add visualization tools to observe sorting behavior.

Enhance HybridSort with further adaptive optimizations.

Author

Daniel Seong

Course

CSC551 - Advanced Algorithms

Date

February 19, 2025

