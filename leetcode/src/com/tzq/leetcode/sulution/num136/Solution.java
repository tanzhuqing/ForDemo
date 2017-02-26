package com.tzq.leetcode.sulution.num136;

public class Solution {
	public int singleNumber(int[] nums) {
		if (nums.length ==0) {
			return 0;
		}
		int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
		  tmp = tmp^nums[i];	
		}
        return tmp;
	}
}
