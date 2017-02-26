package com.tzq.leetcode.sulution.num344;

public class Solution {
	 public static String reverseString(String s) {
	   char[] ss = s.toCharArray();
	   for (int i = 0,j=ss.length-1; i <=j; i++,j--) {
		      if (ss[i]!=ss[j]) {
				char tmp = ss[i];
				ss[i] = ss[j];
				ss[j]=tmp;
			}
	     }
		 return new String(ss);
	    }

	 public static void main(String[] args) {
		String str = "hello";
		System.out.println(reverseString(str));
	}
}
