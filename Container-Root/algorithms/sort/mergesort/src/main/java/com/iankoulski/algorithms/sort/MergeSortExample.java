package com.iankoulski.algorithms.sort;

/**
 * Merge Sort example
 *
 */
public class MergeSortExample 
{
    public static void main( String[] args )
    {
        System.out.println( "Example: Merge Sort" );
	int[] unsortedArray = new int[] {5,3,6,4,0,8,7,2,1,10,15,13,12,56,11,34,52,123,51};
	MergeSort ms = new MergeSort(unsortedArray.length);
	ms.insert(unsortedArray);
	ms.displayArray();
	ms.mergeSort(-1); // 1 - ascending, -1 - descending
	ms.displayArray();
    }
}
