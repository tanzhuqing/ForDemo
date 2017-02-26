package com.tzq.leetcode.sulution.num268;

import java.util.Arrays;

public class Solution {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int a=nums.length;
        for (int i = 0; i < nums.length; i++) {
			if (i!=nums[i]) {
				a=i;
				break;
			}
		}
        return a;
    }
    
    public static void main(String[] args) {
     int[] nums = {0};
     System.err.println(missingNumber(nums));
	}
}
