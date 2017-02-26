package com.tzq.leetcode.sulution.num154;




public class Solution {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
			if (nums[i]<nums[i-1]) {
				return nums[i];
			}
		}
        return nums[0];
    }
    //¶þ·Ö·¨
    public int findMin2(int[] nums) {
		return find(nums, 0, nums.length-1);
	}
    
    private int find(int[] nums,int from,int to){
    	if (from == to) {
			return nums[from];
		}
    	int m = (from+to)/2;
    	if (nums[from] == nums[to]) {
			return Math.min(find(nums, from, m), find(nums, m+1, to));
		}
    	if (nums[from] < nums[to]) {
			return nums[from];
		}
    	if (nums[m]>nums[to]) {
			return find(nums, m+1, to);
		}else {
			return find(nums, from, m);
		}
    	
    }
}
