package com.tzq.leetcode.sulution.num492;


public class Solution {
	 public int[] constructRectangle(int area) {
	        int l = 1;
	        int w = 1;
	        int dis = area;
	        for (int i = 1; i < area/2+1; i++) {
				int j = area/i;
				if (i*j == area) {
					if (dis > Math.abs(j-i)) {
						dis = Math.abs(j-i);
						if (j>i) {
							l = j;
							w = i;
						}else {
							l = i;
							w = j;
						}
					}
				}
			}
	        
      int[] res = {l,w};
      return res;
	 }
}
