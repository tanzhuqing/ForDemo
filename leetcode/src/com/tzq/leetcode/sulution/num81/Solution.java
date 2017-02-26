package com.tzq.leetcode.sulution.num81;

public class Solution {
    public boolean search(int[] nums, int target) {
        int h = nums.length-1,l=0;
        while (l<=h) {
			int mid = (l+h)/2;
			if (nums[mid] == target) {
				return true;
			}
			
			if (nums[mid] > nums[l]) {
				if (target >=nums[l] && target<= nums[mid]) {
					h = mid-1;
				}else {
					l = mid+1;
				}
			}else if (nums[mid] < nums[l]) {
				if (target>=nums[mid] && target<=nums[h]) {
					l = mid+1;
				}else {
					h = mid-1;
				}
			}else if (nums[mid] == nums[l]) {
				l++;
			}
		}
        return false;
    }
}
