package com.tzq.leetcode.sulution.num162;

public class Solution {
	
	//¶þ·Ö·¨
    public int findPeakElement(int[] nums) {
        int  i=0,j=nums.length-1;
        while (i<j) {
			int m = (i+j)/2;
			if (nums[m] > nums[m+1]) {
				j=m;
			}else {
				i=m+1;
			}
		}
        return i;
    }
}
