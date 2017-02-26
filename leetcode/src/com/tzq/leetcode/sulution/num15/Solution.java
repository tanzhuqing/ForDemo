package com.tzq.leetcode.sulution.num15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	 public List<List<Integer>> threeSum(int[] nums) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        List<List<Integer>> lists = new ArrayList<List<Integer>>();
	        for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					
				}else {
					map.put(nums[i], 1-nums[i]);
					
					for (Integer k : map.keySet()) {
						int j = 1-k-nums[i];
						
					}
				}
			}
	   }

}
