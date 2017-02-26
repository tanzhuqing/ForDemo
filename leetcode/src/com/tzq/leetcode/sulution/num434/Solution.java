package com.tzq.leetcode.sulution.num434;

public class Solution {
    public static int countSegments(String s) {
        int count = 0;
        int prev = 0;
        for (int i = 0; i <= s.length(); i++) {
		   if (i==s.length()||s.charAt(i)==' ') {
			if (prev < i) {
				count++;
			}
			prev = i +1;
		}	
		}
        return count;
    }
    
    public static void main(String[] args) {
		String string= "Hello, my name is John";
		System.err.println(countSegments(string));
	}
}
