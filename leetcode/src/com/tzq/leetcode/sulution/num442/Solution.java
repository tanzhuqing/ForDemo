package com.tzq.leetcode.sulution.num442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     List<Integer> list = new ArrayList<>();
     Set<Integer> set = new HashSet<Integer>();
     for (Integer i : nums) {
		if (set.contains(i)) {
			list.add(i);
		}else {
			set.add(i);
		}
	}
     return list;
    }
    public List<Integer> findDuplicates2(int[] nums) {
    	List<Integer> list = new ArrayList<>();
    	if (nums==null||nums.length==0||nums.length==1) {
			return list;
		}
    	for (int i = 0; i < nums.length; i++) {
			int loc = Math.abs(nums[i])-1;
			if (nums[loc] < 0) {
				list.add(Math.abs(nums[i]));
			}else {
				nums[loc] = -nums[loc];
			}
		}
    	return list;
    }
    
}
