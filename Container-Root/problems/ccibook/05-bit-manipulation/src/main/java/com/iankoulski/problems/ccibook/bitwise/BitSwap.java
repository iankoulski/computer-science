package com.iankoulski.problems.ccibook.bitwise;

/*
Problem:
Given an integer, swap the places of all odd and even bits in it (e.g. swap bit 0 and 1, 2 and 3, etc.)
*/

/*
Example:
Input: N = 10010100
Output:    01101000
*/

/*
Algo:
1) Use mask 10101010 to extract even values then shift them right using >>> (logical right shift, so 0's come in from left instead of sign) 
2) Use mask 01010101 to extract odd values then shift them left using >> 
3) Merge shifted even and odd values using OR
*/

public class BitSwap
{

    public static void main( String[] args ){
        System.out.println("\n\nvvvvvvvvvvvvvvvvvv Bit Swap vvvvvvvvvvvvvvvvvvvvv\n");
        BitSwap bitSwap = new BitSwap();
        String strN = "10010100";
        int N = Integer.parseInt(strN,2);
        String strM = "01101000";
        int M = Integer.parseInt(strM,2);
        System.out.println("Input: \nN="+Integer.toString(N,2));
        int result = bitSwap.swapBits(N);
        System.out.println("Output:          " + String.format("%1$" + strM.length() + "s",Integer.toString(result,2)).replace(' ','0'));
        System.out.println("Expected output: " + strM);
		System.out.println("\n^^^^^^^^^^^^^^^^^^ Bit Swap ^^^^^^^^^^^^^^^^^^^^^\n\n");
    }

    int swapBits(int N) {
        //int evenMask = Integer.parseInt("10101010101010101010101010101010",2); //0xAAAAAAAA
        //int oddMask =  Integer.parseInt("01010101010101010101010101010101",2); //0x55555555
        int evenMask = 0xAAAAAAAA;
        int oddMask = 0x55555555;
        int evenBits = N & evenMask;
        int oddBits = N & oddMask;
        evenBits = evenBits >>> 1;
        oddBits = oddBits << 1;
        int swappedBits = evenBits | oddBits;
        return swappedBits;
    } 
    
}