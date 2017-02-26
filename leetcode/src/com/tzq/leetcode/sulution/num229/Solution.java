package com.tzq.leetcode.sulution.num229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] nums = {1};
		majorityElement(nums);
	}
	
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums==null) {
			return res;
		}

        int cad1=0,cad2=1,count1=0,count2=1;
        for (Integer i : nums) {
			if (i==cad1) {
				count1++;
			}else if (i==cad2) {
				count2++;
			}else if (count1==0) {
				cad1 = i;
				count1 = 1;
			}else if (count2==0) {
				cad2 = i;
				count2 = 1;
			}else {
				count1--;
				count2--;
			}
			
		}
        count1=0;
        count2=0;
        for (Integer integer : nums) {
			if (integer==cad1) {
				count1++;
			}else if (integer==cad2) {
				count2++;
			}
			
		}
        
        if (count1> (nums.length/3)) {
			res.add(cad1);
		}
        if (count2> (nums.length/3)) {
			res.add(cad2);
		}
        return res;
        
    }
}
