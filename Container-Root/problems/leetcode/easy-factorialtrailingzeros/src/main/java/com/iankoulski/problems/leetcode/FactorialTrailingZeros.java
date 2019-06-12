package com.iankoulski.problems.leetcode;

/**
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
*/
public class FactorialTrailingZeros 
{

    public static void main( String[] args )
    {
    	System.out.println("\n\nvvvvvvvvvvvvvvvvvvvvvvvvv Traling Zeros of Factorial vvvvvvvvvvvvvvvvvvvvvvvvvv \n");
    	int n = 5;
    	if ( args!= null && args.length > 0){
		try{
			n=Integer.parseInt(args[0]);
		}catch (NumberFormatException nfe) {			
			nfe.printStackTrace();
			System.out.println ("WARNING: using default vale of argument: 5");
			n=5;
		}
	}

	int count = Solution.trailingZeroes(n);

        System.out.println( "\nThe number of trailing zero's for number " + n + " is " + count );
	System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^ End Trailing Zeros of Factorial ^^^^^^^^^^^^^^^^^^^^^^ \n");
    }

    public static class Solution {
	public static int trailingZeroes(int n) {
		int count=0;
		long k=5;
		while (n>=k) {
			count += n/k;
			k*=5;
		}
		return count;
	}
    }
}
