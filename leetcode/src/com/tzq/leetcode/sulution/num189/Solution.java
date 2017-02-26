package com.tzq.leetcode.sulution.num189;

public class Solution {
	public static void rotate(int[] nums, int k) {
		if (k == 0) {
			return;
		}
		int len = nums.length;
		if (k>len) {
			k = k%len;
		}
		nums = reverse(nums, 0, len - 1);
		nums = reverse(nums, 0, k-1);
		nums = reverse(nums, k, len - 1);
		

		System.err.println(nums);
	}

	private static int[] reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2 };
		rotate(nums, 0);
	}
}
