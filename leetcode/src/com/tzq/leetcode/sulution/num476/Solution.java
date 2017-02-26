package com.tzq.leetcode.sulution.num476;

public class Solution {
	 public int findComplement(int num) {
		// 制作一个mask，在mask的范围内按位取反
	
	        int mask = (Integer.highestOneBit(num) << 1) -1;
	    
	        num = ~num;
	        return num & mask;
	    }
	 

}
