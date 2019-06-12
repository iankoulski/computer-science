package com.iankoulski.problems.leetcode;

import java.util.List;
import java.util.Arrays;

/**
 * Palindrome Pairs
 *
 */
public class PalindromePairs 
{
    public static void main( String[] args )
    {
        System.out.println("\n\nvvvvvvvvvvvvvvvvvvvvvvvvvvv Palindrome Pairs vvvvvvvvvvvvvvvvvvvvvvvvvvvv\n");
		if (args.length<=1){
			System.out.println("Please specify at least two words as arguments");
		}
		PalindromePairsSolution pss = new PalindromePairsSolution();
		List<List<Integer>> pp = pss.palindromePairs(args);
		System.out.println("Word list:");
		System.out.println(Arrays.asList(args));
		System.out.println("\nPalindrome pair indices: ");
		System.out.println(pp);
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^ End Palindrome Pairs ^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
    }
}
