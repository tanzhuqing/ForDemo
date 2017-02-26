package com.tzq.leetcode.sulution.num1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 public static int[] twoSum(int[] nums, int target) {
	  int[] res = new int[2];
	  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	  for (int i = 0; i < nums.length; i++) {
		if (map.containsKey(nums[i])) {
			res[0] = map.get(nums[i]);
			res[1] = i;
			return  res;
		}else {
			map.put(target-nums[i], i);
		}
	  }
	  return res;
	 }

	 public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		System.err.println(twoSum(nums, target).toString());
	}
}
