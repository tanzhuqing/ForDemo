package com.tzq.leetcode.sulution.num70;

public class Solution {
    public static int climbStairs(int n) {
        int[] ways = new int[n+1];
        ways[0]=1;
        for (int i = 0; i < n; i++) {
			if (i+1<=n) {
				ways[i+1] += ways[i];
			}
			if (i+2<=n) {
				ways[i+2] += ways[i];
			}
		}
        return ways[n];
    }
    
    public static void main(String[] args) {
		System.err.println(climbStairs(9));
	}
}
