package com.iankoulski.problems.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Traversal of binary tree in a zigzag pattern
 *
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
