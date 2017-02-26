package com.tzq.leetcode.sulution.num485;

public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int count = 0;
		int len = nums.length<10000?nums.length:10000;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 1) {
				count++;
			}
			if (nums[i]==0) {
				if (max<count) {
					max = count;	
				}
				count = 0;
			}
		}
		if (max<count) {
			max = count;
		}
	return max;			
	}

	public static void main(String[] args) {
		
	}
}
