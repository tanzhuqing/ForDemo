package com.tzq.leetcode.sulution.num217;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
			if (map.get(i)==null) {
				map.put(i, 1);
			}else {
				return true;
			}
		}
        
        return false;
    }
	

}
