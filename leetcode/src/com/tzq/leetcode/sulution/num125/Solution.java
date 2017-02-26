package com.tzq.leetcode.sulution.num125;

public class Solution {
	 public static boolean isPalindrome(String s) {
		 if (s.equals("")) {
			return true;
		}
		 s = s.toLowerCase();
		 int i=0,j=s.length()-1;
		 for (; i<=j; i++,j--) {
			 while (!Character.isLetterOrDigit(s.charAt(i)) && i<j) {
					i++;
				}
				while (!Character.isLetterOrDigit(s.charAt(j))&& i<j) {
					j--;
				}
				if (s.charAt(i) != s.charAt(j)) {
					return false;
				}
		}
	   return true;

 }
	 
	 public static void main(String[] args) {
		String string = "aA";
		System.err.println(isPalindrome(string));
	}
}
