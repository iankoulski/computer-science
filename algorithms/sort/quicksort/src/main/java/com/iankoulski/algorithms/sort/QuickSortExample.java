package com.iankoulski.algorithms.sort;

/**
 * QuickSort Example
 *
 */
public class QuickSortExample
{
    public static void main( String[] args )
    {
        System.out.println( "Example: QuickSort" );
	int [] unsortedArray = new int[] {5,3,6,4,0,8,7,2,1,10,15,13,12,56,11,34,52,123,51};
	QuickSort qs = new QuickSort(unsortedArray);
	qs.displayArray();
	qs.sort(1);
	qs.displayArray();
    }
}
