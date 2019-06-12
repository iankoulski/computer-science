package com.iankoulski.problems.leetcode;

import java.util.List;
import java.util.Arrays;

/* Problem:
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y". 
*/
public class ReverseVowels 
{
	private Solution s = null;
	
	public Solution getSolution(){
		if (s==null)
			s = new Solution();
		return s;
	}
	
    public static void main( String[] args )
    {
		System.out.println("\n\nvvvvvvvvvvvvvvvvvv Reverse Vowels in a String vvvvvvvvvvvvvvvvvvvvv\n");
		String str = args[0];
		if (str==null || str.length()==0){
			str = "string";
		}
		System.out.println("The string ");
		System.out.println(str);
		System.out.println("with reversed vowels is ");
		ReverseVowels rv = new ReverseVowels();
		System.out.println(rv.getSolution().reverseVowels(str));
		System.out.println("\n^^^^^^^^^^^^^^^^^^ End Reverse Vowels in a String ^^^^^^^^^^^^^^^^^^^^^\n\n");
	}

	public class Solution {
	   
		private List<String> vowels = Arrays.asList("a","A","e","E","i","I","o","O","u","U");
	   
		public StringBuilder swap(StringBuilder sb, int li, int hi ) {
			char hc = sb.charAt(hi);
			sb.setCharAt(hi,sb.charAt(li));
			sb.setCharAt(li,hc);
			return sb;
		}
	   
		private boolean isVowel(char c){
			String ch = Character.toString(c);
			return vowels.contains(ch);
		}
	   
		private int findVowelInd(StringBuilder sb, int start, int increment){
			int ind = start;
			int vind = -1;
			while (0<=start && start<sb.length()){
				if (isVowel(sb.charAt(ind))) {
					vind=ind;
					break;
				}
				ind+=increment;
			}
			return vind;
		}
	   
		public String reverseVowels(String s) {
			StringBuilder sb = new StringBuilder(s);
			int hi=sb.length()-1;
			for (int li = 0; li<hi; li++){
				if (isVowel(sb.charAt(li))){
					int hvi = findVowelInd(sb,hi,-1);
					sb=swap(sb,li,hvi);
					hi=hvi-1;
				}
			}
			return sb.toString();
		}
	}
	
}

