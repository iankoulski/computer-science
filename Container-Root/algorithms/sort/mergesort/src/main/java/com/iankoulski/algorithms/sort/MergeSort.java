package com.iankoulski.algorithms.sort;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Alex on 9/8/2016.
 */
public class MergeSort {

    int[] dataArray;
    int dataSize;
    int direction;

    public MergeSort(int maxSize){
        System.out.println(String.format("\nMergeSort array of size %d",maxSize));
        this.dataArray = new int[maxSize];
        this.dataSize = 0;
    }

    public void insert(int num){
        dataArray[dataSize]=num;
        dataSize++;
    }

    public void insert(int[] nums){
        for (int i = 0; i<nums.length; i++){
            dataArray[i]=nums[i];
            dataSize++;
        }
    }

    // merges subarrays a and b into sorted array
    private void merge(int[] workArray, int al, int ah, int bl, int bh ){

        // initialize
        int ai=al,bi=bl,wi=0; //? wi initial value
        int mergedSize = bh - al;

        // merge arrays
        while (ai<=ah && bi<=bh){
            if (direction>=0) { // ascending
                if (dataArray[ai] < dataArray[bi]) {
                    workArray[wi] = dataArray[ai];
                    ai++;
                } else {
                    workArray[wi] = dataArray[bi];
                    bi++;
                }
            }else{ // descending
                if (dataArray[ai] > dataArray[bi]) {
                    workArray[wi] = dataArray[ai];
                    ai++;
                }else{
                    workArray[wi] = dataArray[bi];
                    bi++;
                }
            }
            wi++;
        }

        // append remaining elements from a
        while (ai<=ah){
            workArray[wi]=dataArray[ai];
            wi++;
            ai++;
        }

        // append remaining elements from b
        while (bi<=bh){
            workArray[wi] = dataArray[bi];
            wi++;
            bi++;
        }

        // put the merged array into the data array
        for (int j=0; j<=mergedSize; j++){
            dataArray[al+j]=workArray[j];
        }
    }

    // sorts the workArray recursively
    private void recursiveMergeSort(int[] workArray, int lowIndex, int highIndex ){

        // recursively split workArray into halves until the halves contain only 1 element
        if (lowIndex>=highIndex) {
            return;
        }else {
            int mid = (lowIndex + highIndex) / 2;
            // split left half
            recursiveMergeSort(workArray,lowIndex,mid);
            // split right half
            recursiveMergeSort(workArray, mid+1,highIndex);
            // merge the halves
            merge(workArray,lowIndex,mid,mid+1,highIndex);
        }

    }

    // starts the sort
    public void mergeSort(int direction){
        Long ts = Calendar.getInstance().getTimeInMillis();
        this.direction = direction;
        int[] workArray = new int[dataArray.length];
        recursiveMergeSort(workArray,0, dataArray.length-1);
        Long te = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format("MergeSort took %d milliseconds",te-ts));
    }

    public void displayArray() {
        System.out.println(Arrays.toString(dataArray));
    }
}
