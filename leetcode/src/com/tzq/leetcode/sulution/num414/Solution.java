package com.tzq.leetcode.sulution.num414;


public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		System.err.println(thirdMax(nums));
	}
    public static int thirdMax(int[] nums) {
         int one,two,three;
         one = two = three = Integer.MIN_VALUE;
         int count = 0;
         for(int x : nums){
             if(count >= 1 && x == one || count >= 2 && x == two)
                 continue;
             if(x > one){
                 three = two;
                 two = one;
                 one = x;
                 count++;
             }
             else if( x > two){
                 three = two;
                 two = x;
                 count++;

             }
             else if(x >= three){
                 three = x;
                 count++;
             }

         }
         if(count >= 3)
             return three;
         else
             return one;
    }
    
 
}
