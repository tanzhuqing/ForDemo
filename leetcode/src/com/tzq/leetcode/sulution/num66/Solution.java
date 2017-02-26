package com.tzq.leetcode.sulution.num66;


public class Solution {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
			return digits;
		}
        int flag = 1;
        int tmp = 0;
        for(int i=len-1;i>=0;i--){
        	tmp = digits[i]+flag;
        	if (tmp>=10) {
				flag = 1;
			}else {
				flag = 0;
			}
        	digits[i] = tmp%10;
        	
        }
        if (flag==1) {
			int[] res = new int[len+1];
			res[0] = 1;
			for (int i = 1; i <= len; i++) {
				res[i]=digits[i-1];
			}
			return res;
		}else {
			return digits;
		}
    }
    
    public static void main(String[] args) {
		int[] dig = {9};
		plusOne(dig);
	}
}
