package com.tzq.leetcode.sulution.num167;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 public static int[] twoSum(int[] numbers, int target) {
		 int[] res = new int[2];
	     Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	     for (int i = 0; i < numbers.length; i++) {
			int k = target - numbers[i];
			if (map.containsKey(k)) {
				int j = map.get(k);
				res[0] = j;
				res[1] = i+1;
				return res;
			}else {
				map.put(numbers[i], i+1);
			}
		}
	     return res;
	 }
	 public static void main(String[] args) {
		int[] nums = {2,3,4};
		int tar = 6;
		System.err.println(twoSum(nums, tar)[0]);
	}
}
