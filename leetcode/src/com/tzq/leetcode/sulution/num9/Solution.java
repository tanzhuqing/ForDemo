package com.tzq.leetcode.sulution.num9;

public class Solution {
	public static boolean isPalindrome(int x) {
		if (x<0) {
			return false;
		}
		if (x<10) {
			return true;
		}
		int a = x%10;
		int b = x/10;
		int c = a;
		
	  while (b>0) {
		 a=b%10;
		 b = b/10;
		 c = c*10+a;
	}
		
		if (c ==x) {
			return true;
		}
		return false;

	}
	
	public static void main(String[] args) {
		isPalindrome(4856);
	}

}
