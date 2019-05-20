package com.iankoulski.problems.ccibook.arrays;


// One Away

/*
There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
Example:
pale, ple -> true
ple, pale -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
*/

/*
Algo
Iterate over first string, index of second string matches first string while chars are the same. 
if chars are not the same, check next char in each string (insert or delete case), or advance both pointers and if they match then it is a case of replace char, continue checking until end of both strings or until more than one difference is discovered. Return true if end of string reached with 0 or 1 differences, return false if more than 1 difference is found.
*/

public class DiffChecker {
    
    public static void main( String[] args ){
		System.out.println("\n\nvvvvvvvvvvvvvvvvvv One Away Diff Checker vvvvvvvvvvvvvvvvvvvvv\n");    
        if ( args!=null && args.length >= 2){
            DiffChecker dc = new DiffChecker();
            System.out.println("String one: " + args[0]);
            System.out.println("String two: " + args[1]);
            System.out.println("One edit away? " + dc.isOneEditAway(args[0],args[1]));
        }else{
            System.out.println("\nInsufficient number of arguments\nUsage: DiffChecker <string1> <string2>");
        }
		System.out.println("\n^^^^^^^^^^^^^^^^^^ End One Away Diff Checker ^^^^^^^^^^^^^^^^^^^^^\n\n");        
    }

    boolean isOneEditAway(String str1, String str2){
        int len1=str1.length(), len2=str2.length(); 
        if (Math.abs(len2-len1) >1) return false; // two inserts/deletes away in best case scenario
        int cntInsert = 0, cntDelete = 0, cntReplace = 0;
        char c1,c2;
        int index1=0, index2=0;
        while(index1<len1 && index2<len2){
            c1 = str1.charAt(index1);
            c2 = str2.charAt(index2);
            if (c1==c2){
                // Match
                index1++;
                index2++;
            }else{
                // Difference
                if ((index1+1<len1) && str1.charAt(index1+1)==c2){
                    // Delete
                    cntDelete++;
                    index1++;
                } else if ((index2+1<len2) && c1==str2.charAt(index2+1)) {
                    // Insert
                    cntInsert++;
                    index2++;
                } else if ((index1+1<len1) && (index2+1<len2) && str1.charAt(index1+1)==str2.charAt(index2+1)) {
                    // Replace
                    cntReplace++;
                    index1++;
                    index2++;
                }
                if (cntDelete+cntInsert+cntReplace>1) return false;
            }
        }
        return true;
    }
    
}



