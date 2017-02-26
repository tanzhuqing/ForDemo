package com.tzq.leetcode.sulution.num55;


public class Solution {
    public boolean canJump(int[] nums) {
           int i=0,len = nums.length;
           for (int j = 0; i<len&i<=j; ++i) {
			j = Math.max(nums[i]+i, j);
		}
           return i==len;
           
    }
 
    
}
