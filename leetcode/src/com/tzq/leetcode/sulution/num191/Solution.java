package com.tzq.leetcode.sulution.num191;

public class Solution {
	 // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count = 0,cnt=32;
		while (cnt != 0) {
			count +=(n&1);
			n =n>>1;
			cnt--;
		}
		return count;
    }

}
