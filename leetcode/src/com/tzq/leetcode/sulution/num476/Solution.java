package com.tzq.leetcode.sulution.num476;

public class Solution {
	 public int findComplement(int num) {
		// ����һ��mask����mask�ķ�Χ�ڰ�λȡ��
	
	        int mask = (Integer.highestOneBit(num) << 1) -1;
	    
	        num = ~num;
	        return num & mask;
	    }
	 

}
