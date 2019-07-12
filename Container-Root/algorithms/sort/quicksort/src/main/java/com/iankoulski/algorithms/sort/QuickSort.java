package com.iankoulski.algorithms.sort;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Alex Iankoulski on 9/13/2016.
 */
public class QuickSort {

    private int[] array;
    private int direction;

    public QuickSort(int[] unsortedArray) {
        System.out.println(String.format("\nQuickSort array of size %d",unsortedArray.length));
        this.array = unsortedArray;
    }

    // Time O(n.log n) best and average case, O(n2)-worst if already sorted
    // Space O(1)
    public void sort(int direction) {
        long ts = Calendar.getInstance().getTimeInMillis();
        this.direction = direction;
        recursiveQuickSort(0,array.length-1);
        long te = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format("QuickSort took %d milliseconds",te-ts));
    }

    private void recursiveQuickSort(int low, int high){
        if (array==null || array.length ==0){
            System.out.println("Valid array is required for sorting");
            return;
        }

        if (low >= high){ // exit recursion
            return;
        }

        // pick right-most element as pivot
        int pivot = array[high];

        // partition
        int i=low, j=high;
        while (i<j){
            if (direction>=0){ // find a left value that is greater than pivot and a right value that is lesser than pivot, then swap
                while(array[i]<pivot){
                    i++;
                }
                while(array[j]>pivot){
                    j--;
                }
            }else{ // find a left value that is lesser than pivot and a right value that is greater than pivot, then swap
                while(array[i]>pivot){
                    i++;
                }
                while(array[j]<pivot){
                    j--;
                }
            }
            if (i<=j) {
                if (i<j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }

        }

        // recursively sort each partition
        if (low<j) recursiveQuickSort(low,j);
        if (high>i) recursiveQuickSort(i,high);

    }

    public void displayArray() {
        System.out.println(Arrays.toString(array));
    }
}
