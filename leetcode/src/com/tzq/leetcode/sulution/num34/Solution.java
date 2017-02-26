package com.tzq.leetcode.sulution.num34;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        int i=0,j=nums.length-1;
        while (i<=j) {
			int m = i + (j-i)/2;
			if (target == nums[m]) {
				range[0] = m;
				j = m-1;
			}else if(target < nums[m]){
				j = m-1;
			}else {
				i = m+1;
			}
		}
        i = 0;
        j = nums.length-1;
        while (i<=j) {
			int m = i + (j-i)/2;
			if (target == nums[m]) {
				range[1] = m;
				i = m+1;
			}else if(target < nums[m]){
				j = m-1;
			}else {
				i = m+1;
			}
		}
        return range;
    }
    
    public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.err.println(searchRange(nums, 8));
	}
}
