package com.tzq.leetcode.sulution.num153;

public class Solution {
    public int findMin(int[] nums) {
        if (nums==null||nums.length==0) {
			return 0;
		}
        return find_min(nums, 0, nums.length-1);
    }
    
    private int find_min(int[] nums, int start,int end){
        int mid = (start+end)/2;
        if (start==end) {
			return nums[start];
		}else if (start+1 == end) {
			if (nums[start] < nums[end]) {
				return nums[start];
			}else {
				return nums[end];
			}
		}else {
			if (nums[mid] < nums[mid-1]) {
				return nums[mid];
			}else if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
				return find_min(nums, mid+1, end);
			}else {
				return find_min(nums, start, mid-1);
			}
		}
    }
}
