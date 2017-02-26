package com.tzq.leetcode.sulution.num287;

import java.util.Arrays;

public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
			if (nums[i-1]==nums[i]) {
				return nums[i];
			}
		}
        return res;
    }
    //二分查找法
    public int Findduplicate(int[] nums) {
		int low=1,high = nums.length-1;
		while (low<=high) {
			int mid = low + (high-low)/2;
			int count = 0;
			for (int num:nums) {
				if (num <= mid) {
					count++;
				}
			}
			
			if (count > mid) {
				high = mid;
			}else {
				low = mid+1;
			}
		
		}
		return low;
	}
    
    //循环链条检测法
    public static int findduplicate(int[] nums)  {
		int slow = 0,fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (nums[slow]!=nums[fast]);
		int restart = 0;
		while (nums[restart]!= nums[slow]) {
			restart = nums[restart];
			slow = nums[slow];
		}
		
		return nums[restart];
	}
    
    public static void main(String[] args) {
		int[] nums = {4,7,2,9,5,1,6,5};
		System.err.println(findduplicate(nums));
	}
    
}
