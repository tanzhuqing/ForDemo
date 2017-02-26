package com.tzq.leetcode.sulution.num374;

public class Solution  {
    public int guessNumber(int n) {
    	int i = 0,j=n;
    	while (i<=j) {
			int m = i + (j-i)/2;
			int g = guessNumber(m);
			if (g==0) {
				return m;
			}
			if (g==-1) {
				j=m-1;
			}else {
				i=m+1;
			}
		}
    	
		return 1;
        
    }
}
