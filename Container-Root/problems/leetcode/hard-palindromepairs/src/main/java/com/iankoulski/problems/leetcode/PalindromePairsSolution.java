package com.iankoulski.problems.leetcode;

import java.util.*;

/*
 Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
  so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]

Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

public class PalindromePairsSolution {
    
    // Return true if string is the same when read forward and backward
    private boolean isPalindrome(String w){
        return w.equals(reverse(w));
    }
    
    // Return reverse of a string
    private String reverse(String w){
        return new StringBuilder(w).reverse().toString();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        
        // Result will be accumulated here
        List<List<Integer>> pairs = new ArrayList<>();
        
        // Put words and indexes in a map for easy searching
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++ ){
            map.put(words[i],i);
        }
        
        // Remember position of blank word if it exists
        boolean hasBlankWord = map.containsKey("");
        int blankWordIndex = -1;
        if (hasBlankWord){
            blankWordIndex = map.get("");
        }
        
        // Loop through words list once
        for (int i=0; i<words.length; i++){
            
            // Handle edge case when "" is a word
            if (hasBlankWord){
                if (i!=blankWordIndex && isPalindrome(words[i])){
                    pairs.add(Arrays.asList(i,blankWordIndex));
                    pairs.add(Arrays.asList(blankWordIndex,i));
                }
            }
            
            // Handle case when the word is not a palindrome but the whole reverse word exists
            if (!isPalindrome(words[i])){
                String rw = reverse(words[i]);
                if (map.containsKey(rw)){
                    int ri = map.get(rw);
                    pairs.add(Arrays.asList(i,ri));
                }
            }            
            
            // Handle case when part of the word is a palindrome and the reverse of the rest of the word exists
            for (int m=1; m<words[i].length(); m++){
                String left = words[i].substring(0,m);
                String right = words[i].substring(m);
                if (isPalindrome(left)){
                    String rr = reverse(right);
                    if (map.containsKey(rr)){
                        int ir = map.get(rr);
                        pairs.add(Arrays.asList(ir,i));
                    }
                }
                if (isPalindrome(right)){
                    String rl = reverse(left);
                    if (map.containsKey(rl)){
                        int ir = map.get(rl);
                        pairs.add(Arrays.asList(i,ir));
                    }
                }
            }
        }
        
        return pairs;
    }
}