package com.tzq.leetcode.sulution.num12;

public class Solution {
	//¶þ·Ö·¨
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        while (num>0) {
			int i=0,j=values.length-1;
			while (i<=j) {
				int m = i+(j-i)/2;
				if (values[m]<=num) {
					i=m+1;
				}else {
					j=m-1;
				}
			}
			int pos = i-1;
			sb.append(romans[pos]);
			num-=values[pos];
		}
        
        return sb.toString();
    }
}
