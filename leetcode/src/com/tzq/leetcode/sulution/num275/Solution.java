package com.tzq.leetcode.sulution.num275;

public class Solution {
	//二分查找法
	
	public int hIndex(int[] citations) {
		int i = 0, j = citations.length - 1;
		while (i <= j) {
			int m = (i + j) >> 1;
			if (citations[m] == citations.length - m) {
				return citations.length - m;
			}
			if (citations[m] >= citations.length - m) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return citations.length - i;
	}
}
