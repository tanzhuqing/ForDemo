package com.tzq.leetcode.sulution.num41;

public class Solution {
	public int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int num = nums[i];
			if (num > 0 && num <= nums.length && nums[num - 1] != num) {
				nums[i] = nums[num - 1];
				nums[num - 1] = num;

			} else {
				++i;
			}
		}
		i = 0;
		while (i < nums.length && nums[i] == i + 1) {
			++i;
		}
		return i + 1;

	}

}
