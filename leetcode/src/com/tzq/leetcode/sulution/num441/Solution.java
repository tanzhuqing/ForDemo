package com.tzq.leetcode.sulution.num441;

public class Solution {
	//¶þ·Ö·¨
    public int arrangeCoins(int n) {
        long i=0,j=n;
        while (i<=j) {
			long m = (i+j)/2;
			long sum = m*(m+1)/2;
			if (sum>n) {
				j=m-1;
			}else {
				i=m+1;
			}
		}
        return (int)j;
    }
}
