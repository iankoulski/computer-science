package com.iankoulski.problems.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
Problem:
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

*/
public class WordBreak1 
{
    public static void main( String[] args )
    {
		System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvvvvvv Word Break 1 vvvvvvvvvvvvvvvvvvvvvvvv\n" );
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		WordBreak1 wb1 = new WordBreak1();
		System.out.println("Input: \n   string: " + s + "\n   dictionary: " + wordDict);
		boolean b = wb1.isWordBreak(s,wordDict);
		System.out.println("Output: " + b);
		System.out.println( "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^ Word Break 1 ^^^^^^^^^^^^^^^^^^^^^^^\n");
    }
	
	// Less than O(n^2) where n is the lenght of the string. Maybe O(n log n)
	public boolean isWordBreak(String s, List<String> wordDict){

		int[] ind = new int[s.length()+1];
		Arrays.fill(ind,-1);
		ind[0]=0;
		
		for (int i = 0; i<s.length(); i++){
			if (ind[i]!=-1){
				for (int j=i+1; j<=s.length(); j++){
					String word = s.substring(i,j);
					if (wordDict.contains(word)){
						ind[j]=i;
					}
				}
			}
		}
		
		if (ind[s.length()] == -1) return false;
		
		return true;

	
	}
}
