package com.tzq.leetcode.sulution.num345;


public class Solution {
public static String reverseVowels(String s) {
	   char[] ss = s.toCharArray();
	   int i = 0;
	   int j = ss.length-1;
	   while (i<j) {
		if (!isVowels(ss[i])) {
			i++;
		}
		if (!isVowels(ss[j])) {
			j--;
		}
		if (isVowels(ss[i])&& isVowels(ss[j])) {
			char tmp = ss[i];
			ss[i] = ss[j];
			ss[j]=tmp;
			i++;
			j--;
			
		}
		
		
	}

		 return new String(ss);
    }
  

private static boolean isVowels(Character c){
	if (c=='a'||c=='e'||c=='i'||c=='u'||c=='o'||c=='A'||c=='E'||c=='I'||c=='U'||c=='O') {
		return true;
	}
	return false;
}

public static void main(String[] args) {
	String string = "race a car";
	System.err.println(reverseVowels(string));
}
}
