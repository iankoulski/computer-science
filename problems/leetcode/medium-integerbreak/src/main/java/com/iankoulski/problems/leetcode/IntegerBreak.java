package com.iankoulski.problems.leetcode;

/**
 * Integer Break
 *
 */
public class IntegerBreak 
{
    public static void main( String[] args )
    {
        System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvv Integer Break vvvvvvvvvvvvvvvvvvvvvvvvvv\n");
		if (args.length == 0){
			System.out.println("Please specify argument - an integer");
			return;
		}
		int n = -1;
		try{
			n = Integer.parseInt(args[0]);
		}catch (NumberFormatException nfe){
			System.out.println("Please specify a numeric argument");
		}
		System.out.println(String.format("Integer to break into parts with maximum product: %d\n",n));
		IntegerBreakSolution ibs = new IntegerBreakSolution();
		int v = ibs.integerBreak(n);
		System.out.println("Maximum product of parts:");
		System.out.println(v);
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^ End Integer Break ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
    }
}
