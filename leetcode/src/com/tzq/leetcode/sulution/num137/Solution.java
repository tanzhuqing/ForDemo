package com.tzq.leetcode.sulution.num137;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 public int singleNumber(int[] nums) {
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {	
					map.put(nums[i], map.get(nums[i])+1);
				}else {
					map.put(nums[i], 1);
				}
			}
	        int num = 0;
	       for (Integer key:map.keySet()) {
			  int count = map.get(key);
			  if (count == 1) {
				num = key;
			}
		}
	       return num;
	        
	 }

}
