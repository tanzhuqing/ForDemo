package com.tzq.leetcode.sulution.num26;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len<=1) {
			return len;
		}
        int i=1;
        int j=1;
        while (i<len) {
        	  if(nums[i]!=nums[i-1]){  
                  nums[j++]=nums[i++];  
                  continue;  
              } 
			i++;	
		}
        return j;
    }
    
    
    public static void main(String[] args) {
		int[] nums = {1,1};
		System.err.println(removeDuplicates(nums));
	}
}
