package com.tzq.leetcode.sulution.num53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int t = nums[0];
        int sum = t;
        for (int i = 1; i < nums.length; i++) {
			if (t<0) {
				t=0;
			}
			t +=nums[i];
			if (sum<t) {
				sum = t;
			}
		}
        return sum;
    }
}
