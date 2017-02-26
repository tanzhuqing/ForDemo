package com.tzq.leetcode.sulution.num318;

public class Solution {
    public static int maxProduct(String[] words) {
        int[] f = new int[words.length];
        for (int i = 0; i < words.length; i++) {
			char[] wa = words[i].toCharArray();
			for (int j = 0; j < wa.length; j++) {
				int a = wa[j]-'a';
				int b = 1<<a;
				f[i] |=b;
			}
		}
        int max = 0;
        for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
				if ((f[i]&f[j])==0) {
					max = Math.max(max, words[i].length()*words[j].length());
				}
			}
		}
        return max;
    }
    
    
    public static void main(String[] args) {
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.err.println(maxProduct(words));
	}
}
