package com.iankoulski.problems.ccibook.bitwise;

// Bit Insertion
/*
Problem:
You have two 32-bit numbers, N and M, and two bit positions, i and j. Insert M into N such that 
M starts at bit j and ends at bit i. You can assume there is enough space between j an i.
*/

/*
Example:
Input: N = 10000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100
*/

/*
Algo:
1) Create mask that will clear bits i through j
(-1 >> N.len << j+j-1) = 11110000000
+ ~(1 << i)            =         011
                       ---------------
                         11110000011
2) Clear bits i through j in N by AND with mask
           10000000000
        &  11110000011
           ------------
           10000000000 
3) Shift M left by i
    10011 << 2 = 1001100
4) Set bits by OR with N
           10000000000
         |     1001100
         -------------
           10001001100
*/

public class Insertion
{

    public static void main( String[] args ){
        System.out.println("\n\nvvvvvvvvvvvvvvvvvv Bit Insertion vvvvvvvvvvvvvvvvvvvvv\n");
        Insertion ins = new Insertion();
        int N = Integer.parseInt("10000000000",2);
        int M = Integer.parseInt("10011",2);
        int i=2,j=6;
        System.out.println("Input: \nN="+Integer.toString(N,2)+"\nM="+Integer.toString(M,2)+
                                   "\ni="+i+", j="+j);
        int result = ins.insertBits(N,M,i,j);
        int result2 = ins.insertIntBits(N, M, i, j);
        System.out.println("Output (impl1): \n" + Integer.toString(result,2));
        System.out.println("Output (impl2): \n" + Integer.toString(result2,2));
		System.out.println("\n^^^^^^^^^^^^^^^^^^ Bit Insertion ^^^^^^^^^^^^^^^^^^^^^\n\n");
    }


    int insertBits(int N, int M, int i, int j) {
        int nLen=Integer.toString(N,2).length();
        String strMask = new String(new char[nLen]).replace("\0", "1");
        int mask = Integer.parseInt(strMask,2); 
        mask = mask << (i+j-1);
        if (i>0) {
            String strNegMask = new String(new char[i]).replace("\0","1");
            int negMask = Integer.parseInt(strNegMask,2);
            mask |= negMask;
        }
        int newInt = N & mask;
        newInt = newInt | (M << i);
        return newInt;
    } 

    int insertIntBits(int N, int M, int i, int j) {
        // 1) create mask
        int ones = ~0;
        int left = ones << (j+1);
        int right = (1 << i) -1;
        int mask = left | right;
        int nClean = N & mask;
        int mShift = M << i;
        int inserted = nClean | mShift;
        return inserted;
    }
    
}