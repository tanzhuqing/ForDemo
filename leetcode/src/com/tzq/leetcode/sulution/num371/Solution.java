package com.tzq.leetcode.sulution.num371;

public class Solution {
	public static int getSum(int a, int b) {
	      while (b!=0){
	            int x = a ^ b, y = (a & b) << 1;
	            System.err.println("x="+x +", y="+y);
	            a = x; b = y;
	        }
	        return a;
       
	}

	public static void main(String[] args) {
		System.out.println(getSum(9, 8));
	}
}
