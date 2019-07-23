package com.iankoulski.problems.hackerrank;

import java.util.Arrays;

/**
 * Count Swaps
 * You are given an unordered array consisting of consecutive integers  
 * [1, 2, 3, ..., n] without any duplicates. You are allowed to swap 
 * any two elements. You need to find the minimum number of swaps 
 * required to sort the array in ascending order.
 * 
 * Example:
i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took 5 swaps to sort the array.
 */

public class CountSwaps 
{
    public static void main( String[] args )
    {
        System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvv Count Swaps vvvvvvvvvvvvvvvvvvvvvvvvvv\n");
        int[] arr = new int[] {7,1,3,2,4,5,6};
        System.out.println("Input: " + Arrays.toString(arr));
        CountSwaps cs = new CountSwaps();
        int count = cs.minimumSwaps(arr);
        System.out.println("Output: " + count + " swaps");
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^ Count Swaps ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
    }

    /**
     * Algo:
     * Each number in the unordered array is misplaced by taking the position of another number,
     * which in turn takes the position of another number, etc. to form a cycle.
     * If we follow all cycles, the minimum number of required swaps will be cycles-1;
     */


    public int minimumSwaps(int[] arr) {

        int swaps = 0;

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i<arr.length; i++){
            int cycles=0, j=i;
            while (!visited[j]){
                visited[j]=true;
                j=arr[j]-1; // This is how we follow the loop
                cycles++;
            }
            if (cycles>0)
                swaps+=cycles-1;
        }

        return swaps;

    }

}
