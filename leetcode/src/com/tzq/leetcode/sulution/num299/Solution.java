package com.tzq.leetcode.sulution.num299;

public class Solution {
    public String getHint(String secret, String guess) {
        char[] sa = secret.toCharArray();
        char[] ga = guess.toCharArray();
        int len = sa.length;
        int pos = 0;
        int bulls = 0;
        while (pos<len) {
			if (sa[pos] == ga[pos]) {
				bulls ++;
				sa[pos] = sa[len-1];
				ga[pos] = ga[len-1];
				len--;
			}else {
				pos++;
			}
		}
        
        int[] sd = new int [10];
        int[] gd = new int [10];
        for (int i = 0; i < len; i++) {
			sd[sa[i]-'0']++;
			gd[ga[i]-'0']++;
		}
        int bows = 0;
        for (int i = 0; i < 10; i++) {
			bows += Math.min(sd[i], gd[i]);
		}
        return bulls+"A"+bows+"B";
    }
}
