package com.iankoulski.problems.hackerrank;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Count Triplets
 * You are given an array and you need to find number of tripets of indices
 * such that the elements at those indices are in geometric progression
 * for a given common ratio.
 * Example:
 * Input: arr = [1,4,16,64], r=4
 * Output: 2
 * Explanation: We have to triplets: [1,4,16] and [4,16,64]
 */
public class CountTriplets 
{
    public static void main( String[] args )
    {
        System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvv Count Triplets vvvvvvvvvvvvvvvvvvvvvvvvvv\n");
        ArrayList<Long> arr = new ArrayList<Long>(Arrays.asList( new Long[] {new Long(1), new Long(3), new Long(9),
                                 new Long(9), new Long(27), new Long(81)}));
        
        System.out.println("Input: " + arr);
        CountTriplets ct = new CountTriplets();
        long triplets = ct.countTriplets(arr, 3);
        System.out.println("Output: " + triplets);
        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^ Count Triplets ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\n");
    }

    /* Algo
    1) Create Hasthable<Long,Long> right number,count
    2) Create empty Hashtable<Long,Long> left number,count
    3) Iterate through array and for each element decrease the count from right, get counts for num/r from left and num*r from right, then increase count in right,  increase triplets_count by 1*left_count*right_count
    4) return triplets_count
    */

    public void updateCount(Hashtable<Long,Long> ht,Long num,long diff){
        Long count = ht.get(num);
        if (count==null) count = new Long(0);
        long newcount=count.longValue()+diff;
        if (newcount>0) ht.put(num,new Long(newcount));
        else ht.remove(num); 
    }

    public long countTriplets(List<Long> arr, long r) {
        long triplets=0;
        ArrayList<Long> nums = new ArrayList<Long>(arr); 
        Hashtable<Long,Long> right = new Hashtable<Long,Long>(arr.size()); 
        Hashtable<Long,Long> left = new Hashtable<Long,Long>(arr.size());     
        for (int i = 0; i<nums.size(); i++){                
            Long num = nums.get(i);
            updateCount(right,num,1);
        }
        System.out.println("left="+left);
        System.out.println("right="+right);
        for (int i = 0; i<nums.size(); i++){
            Long num = nums.get(i);
            updateCount(right,num,-1);
            if (num.longValue() % r == 0){
                Long leftNum = new Long (num.longValue()/r); 
                Long leftCount = left.get(leftNum);
                if (leftCount!=null){
                    Long rightNum = new Long (num.longValue()*r);
                    Long rightCount = right.get(rightNum);
                    if (rightCount!=null){
                        triplets+=leftCount.longValue()*1*rightCount.longValue();
                    }
                }
            }
            updateCount(left,num,1);
        }
        return triplets;
    }


}
