package com.tzq.leetcode.sulution.num258;

public class Solution {
	public static int addDigits(int num) {
		int a = num;
		while (a>9) {
			int c = num%10;
			num /= 10; 
			while (num>0) {
			c +=num%10;
			num /=10;				
			}
			a = c;
			num = c;
			
		}
		return a;
	}

	public static void main(String[] args) {
		System.err.println(addDigits(19));
	}
}
