package com.tzq.leetcode.sulution.num283;

public class Solution {
	public static void moveZeroes(int[] nums) {
         int len = nums.length;
         for (int i = 0; i < len; i++) {
        	 if (nums[i]==0) {
        		 for (int j = i+1; j < nums.length; j++) {
     				if (nums[j]!=0) {
     					nums[i]=nums[j];
     					nums[j]=0;
     					break;
     				}
     			}
			}	
		}
    
         System.err.println(nums);
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,1};
		moveZeroes(nums);
	}
}
