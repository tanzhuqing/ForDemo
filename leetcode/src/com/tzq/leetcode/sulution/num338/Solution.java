package com.tzq.leetcode.sulution.num338;

public class Solution {
	public int[] countBits(int num) {
		int[] array = new int[num+1];
		for (int i = 0; i <= num; i++) {
			array[i] = countbid(i);
		}
		return array;
	}
	private int countbid(int n){
		if (n==0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}else {
			if (n%2 ==0) {
				return countbid(n/2);
			}else {
				return 1+ countbid(n/2);
			}

		}	        
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = solution.countBits(2);
		for (int i : array) {
			System.out.println(i);
		}
	}
}
