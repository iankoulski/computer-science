package com.iankoulski.problems.ccibook.bitwise;

/*
Problem:
Given two integers M and N, write a function that returns the number of bits you would need to flip to convert M into N.
*/

/*
Example:
Input: N = 11101, M = 01111
Output: 2
*/

/*
Algo:
1) N XOR M - produces 1 bits where the two numbers are different
2) Count number of 1s 
*/

public class Conversion
{

    public static void main( String[] args ){
        System.out.println("\n\nvvvvvvvvvvvvvvvvvv Bit Conversion vvvvvvvvvvvvvvvvvvvvv\n");
        Conversion conv = new Conversion();
        String strN = "11101";
        int N = Integer.parseInt(strN,2);
        String strM = "01111";
        int M = Integer.parseInt(strM,2);
        System.out.println("Input: \nN="+Integer.toString(N,2)+"\nM="+String.format("%1$" + strM.length() + "s",
                                                                                    Integer.toString(M,2)).replace(' ','0'));
        int result = conv.countBitFlips(N,M);
        System.out.println("Output: " + result);
		System.out.println("\n^^^^^^^^^^^^^^^^^^ Bit Conversion ^^^^^^^^^^^^^^^^^^^^^\n\n");
    }

    int countBitFlips(int N, int M) {
        int count = 0;
        int differentBits = N ^ M;
        // c & (c-1) clears the last non-zero bit in c,
        // count how many clears it takes to get to 0
        for (int c = differentBits; c!=0; c = c & (c-1)){
            count++;
        }
        return count;
    } 
    
}