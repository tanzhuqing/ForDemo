package com.tzq.leetcode.sulution.num228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums==null||nums.length==0) {
			return res;
		}
        int i = 0;
        while (i<nums.length) {
			int begin = nums[i];
			while (i<nums.length-1&&nums[i+1]==nums[i]+1) {
				i++;
			}
			if (nums[i]!=begin) {
				res.add(begin+"->"+nums[i]);
			}else {
				res.add(begin+"");
			}
			i++;
		}
        return res;
    }
}
