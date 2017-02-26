package com.tzq.leetcode.sulution.num69;

public class Solution {
	//二分法
    public int mySqrt(int x) {
        int i=0,j=x;
        while (i<=j) {
			int m = (i+j)/2;
			long m2 =  (long)m*m;
			if (m2 == (long)x) {
				return m;
			}
			if (m2>x) {
				j = m-1;
			}else {
				i = m+1;
			}
		}
        return i-1;
    }
    
    //牛顿迭代法
    public static int msart(int x) {
		if (x==0) {
			return 0;
		}
		double y  = Math.max(1, x/2);
		while (true) {
			double ny = (((double)y*y + x)/2/y);
			if (Math.abs(y-ny) <= 0.01) {
				return (int)ny;
			}
			y = ny;
		}
	}
    
    public static void main(String[] args) {
		System.err.println(msart(5));
	}
}
