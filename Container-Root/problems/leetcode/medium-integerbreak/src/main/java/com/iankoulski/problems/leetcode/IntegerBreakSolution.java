package com.iankoulski.problems.leetcode;

/*
 Given a positive integer n, break it into the sum of at least two positive integers
  and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58. 
*/

public class IntegerBreakSolution {
    
    /*
    0=0+0, 0
    1=1+0, 0
    2=1+1, 1
    3=2+1, 2
    4=2+2, 4
    5=3+2, 6
    6=3+3, 9
    7=3+4, 12
    8=3+3+2, 18
    9=3+3+3, 27
    10=3+3+4, 36
    11=3+3+3+2, 54
    12=3+3+3+3, 81
    13=3+3+3+4, 108
    14=3+3+3+3+2, 162
    15=3+3+3+3+3, 243
    
    f[n]=f[n-3]*3
    */

    int[] f = {0,0,1,2,4,6,9,12,18,27,36,54,81,108,162,243}; 
    
    public int integerBreak(int n) {
        int v;
        if (n<=15){
            v = f[n];
        }else{
            v = integerBreak(n-3)*3;
        }
        return v;
    }
}