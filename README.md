# Sorting Algorithms Project

## Overview
This project implements and analyzes various sorting algorithms, including both traditional and unconventional methods. The goal is to evaluate their performance on different types of datasets and optimize sorting efficiency using a **HybridSort** approach. Additionally, modifications were made to **QuickSort** for better performance.

## Implemented Sorting Algorithms
The following sorting algorithms were implemented:

1. **Bogosort** – A highly inefficient sort used for demonstration.
2. **BubbleSort** – A simple but slow comparison-based algorithm.
3. **InsertionSort** – Efficient for small or nearly sorted datasets.
4. **SelectionSort** – A comparison-based sorting method.
5. **MergeSort** – A stable, divide-and-conquer sorting algorithm.
6. **QuickSort** – A fast sorting algorithm optimized with modifications.
7. **GnomeSort** – A variation of insertion sort.
8. **SleepSort** – A unique timing-based sorting technique.

## Sorting Test Framework
A **SortingTest** file was created to test the sorting algorithms against various dataset types:
- **Pre-sorted array**
- **Reverse-sorted array**
- **Random array**
- **Array with duplicates**
- **Single-element array**
- **Odd-sized array**
- **Even-sized array**
- **Power-of-2-sized array**

## Sorting Analysis
A **SortingAnalysis** file was created to measure key performance metrics of each sorting algorithm, including:
- **Number of comparisons** – Measures efficiency of element comparisons.
- **Memory usage** – Evaluates space complexity.
- **Execution time** – Tracks overall speed.

## HybridSort Implementation
A custom **HybridSort** algorithm was developed to optimize sorting efficiency by dynamically switching between sorting algorithms based on dataset size and state. The strategy includes:
- **InsertionSort** for very small datasets (<50 elements) and nearly sorted small datasets (50-500 elements).
- **MergeSort** for non-nearly sorted small datasets and medium-sized datasets (500-5000 elements).
- **QuickSort** for large datasets (>5000 elements).

Note: **BubbleSort** was used for small, nearly sorted datasets, but was removed for revisions as it was found to not be as efficient as the other three sorts in the tested cases.

### QuickSort Modifications
Two key optimizations were applied to **QuickSort**:
1. **Switching to InsertionSort** when subarrays become small, as **InsertionSort** is faster for small datasets.
2. **Choosing the median of the low, mid, and high indexes** as the pivot to enhance partitioning efficiency.

## Utility Functions
Commonly used methods shared across sorting algorithms, such as **swap(int[] data, int i, int j)**, are stored in a separate **SortingUtility.java** file to reduce redundancy and improve maintainability.

## How to Run the Project
1. **Compile the Java files:**
   ```sh
   javac Project2/*.java
   ```
2. **Run the sorting test:**
   ```sh
   java Project2.SortingTest
   ```
3. **Run the sorting analysis:**
   ```sh
   java Project2.SortingAnalysis
   ```
4. **Run the hybrid sorting analysis:**
   ```sh
   java Project2.HybridSortTest
   ```

## Author
**Daniel Seong**

## Course
CSC551 - Data Structures and Algorithms

## Date
February 19, 2025

