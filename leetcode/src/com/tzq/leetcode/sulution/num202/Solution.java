package com.tzq.leetcode.sulution.num202;

public class Solution {
	public static boolean isHappy(int n) {
		if (n==1) {
			return true;
		}
		if (n<5) {
			return false;
		}
		int c = n%10;
		c *=c;
		n /= 10; 
		while (n>0) {
		int a = n%10;
		c += a*a;
		n /=10;				
		}
		return isHappy(c);
		

	}

	public static void main(String[] args) {
		System.err.println(isHappy(3));
	}
}
