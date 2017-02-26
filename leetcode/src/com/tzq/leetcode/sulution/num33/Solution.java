package com.tzq.leetcode.sulution.num33;


public class Solution {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0) {
			return -1;
		}
        int start = 0,end = nums.length-1;
        while (start<=end) {
        	int mid = (start+end)/2;
        	if (target == nums[mid]) {
				return mid;
			}
        	if (nums[start] <=nums[mid]) {
            	if (nums[start] <=target && target<nums[mid]) {
    				end = mid-1;
    			}else {
    				start = mid+1;
    			}
			}else {
				if (nums[mid] < target && target<=nums[end]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}
        return -1;
        
    }

}
