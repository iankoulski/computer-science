package com.iankoulski.problems.ccibook.arrays;

// 1.6 String Compression
/*
Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the “compressed” string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).
*/
/*
Hints:
#92: Do the easy thing first, compress the string, then compare the lengths
#115: Concatenating many strings together is inefficient
*/
/*

/*
Algo:
Iterate over string, count the number of repeated chars. Use StringBuilder to create compressed string. Compare length before returning original or compressed string.
*/

public class BasicStringCompression
{

    public static void main( String[] args ){
        System.out.println("\n\nvvvvvvvvvvvvvvvvvv Basic String Compression vvvvvvvvvvvvvvvvvvvvv\n");
        BasicStringCompression bsc = new BasicStringCompression();
        if (args.length > 0){
            System.out.println("Original string: " + args[0]);
            System.out.println("Compressed string: " + bsc.compressRepeatedChars(args[0]));
        }else{
            System.out.println("\nInsufficient number of arguments!\nUsage: BasicStringCompression <string>\n");
        }
		System.out.println("\n^^^^^^^^^^^^^^^^^^ End Basic String Compression ^^^^^^^^^^^^^^^^^^^^^\n\n");
    }


    String compressRepeatedChars(String str) {
        if (str==null || "".equals(str)) return str;
        int charCount=1;
        char c=0;
        int strLen=str.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<strLen; i++){
            c = str.charAt(i);
            if ( (i+1)<strLen && str.charAt(i+1)==c ){
                charCount++;
            }else{
                sb.append(c);
                sb.append(charCount);
                charCount=1;
            }
        }
        if (sb.length() < strLen)
            return sb.toString();
        
        return str;
    }
    
}