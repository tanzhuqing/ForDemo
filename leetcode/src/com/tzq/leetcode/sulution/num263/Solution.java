package com.tzq.leetcode.sulution.num263;

public class Solution {
	public boolean isUgly(int num) {
		if (num<1) {
			return false;
		}
       if (num<4) {
		return true;
	  }
       if (num==5) {
		return true;
	}
       if (num%2==0) {
		return isUgly(num/2);
	}
       if (num%3==0) {
		return isUgly(num/3);
	}
       if (num%5==0) {
		return isUgly(num/5);
	}
       
       return false;
	}

}