package com.tzq.leetcode.sulution.num219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 public boolean containsNearbyDuplicate(int[] nums, int k) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i <nums.length; i++) {
				if (!map.containsKey(nums[i])) {
					map.put(nums[i], i);
				}else {
					if (i-map.get(nums[i]) <=k) {
						return true;
					}
					map.put(nums[i], i);
				}
			}
	        return false;
	 }

}
