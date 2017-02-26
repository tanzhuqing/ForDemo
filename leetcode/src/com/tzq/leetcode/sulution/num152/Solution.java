package com.tzq.leetcode.sulution.num152;

public class Solution {
    public int maxProduct(int[] nums) {
        int maxpre = nums[0];
        int minpre = nums[0];
        int maxSofar = nums[0];
        int maxhere,minhere;
        for (int i = 1; i < nums.length; i++) {
			maxhere = Math.max(Math.max(maxpre*nums[i], minpre*nums[i]), nums[i]);
			minhere = Math.min(Math.min(maxpre*nums[i], minpre*nums[i]), nums[i]);
			maxSofar = Math.max(maxhere, maxSofar);
			maxpre = maxhere;
			minpre = minhere;
		}
        return maxSofar;
    }

}
