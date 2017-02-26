package com.tzq.leetcode.sulution.num448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> res = new ArrayList<>();
       
       for (int i = 0; i < nums.length; i++) {
		if (nums[i] > 0 && nums[nums[i]-1] > 0) {
			nums[nums[i]-1] = - nums[nums[i]-1];
		}
		if (nums[i] < 0 && nums[-nums[i]-1] > 0) {
			nums[-nums[i]-1] = -nums[-nums[i]-1];
		}
	}
       for (int i = 0; i < nums.length; i++) {
		if (nums[i]>0) {
			res.add(i+1);
		}
	}
       return res;
       
	}
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.err.println(findDisappearedNumbers(nums));
	}
}
