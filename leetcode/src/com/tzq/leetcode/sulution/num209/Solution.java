package com.tzq.leetcode.sulution.num209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum =0;
        int minLen = Integer.MAX_VALUE;
        int end,start=0;
        for (end = 0;  end< nums.length; end++) {
			sum += nums[end];
			while (sum>=s) {
				minLen = Math.min(minLen, end-start+1);
				sum -=nums[start++];
			}
		}
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
