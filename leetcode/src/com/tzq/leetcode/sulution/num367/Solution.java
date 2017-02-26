package com.tzq.leetcode.sulution.num367;

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num<0) {
			return false;
		}
        long i=0;
        long j=num;
        while (i<=j) {
			long  m = (i+j)/2;
			long m2 = m*m;
			if (m2==num) {
				return true;
			}
			if (m2<num) {
				i = m+1;
			}else {
				j = m-1;
			}
		}
        return false;
    }
}
