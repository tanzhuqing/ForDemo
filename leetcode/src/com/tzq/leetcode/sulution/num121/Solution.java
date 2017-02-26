package com.tzq.leetcode.sulution.num121;

public class Solution {
    public static int maxProfit(int[] prices) {
    	if (prices==null||prices.length==0) {
			return 0;
		}
    	int min = Integer.MAX_VALUE;
    	int distantPrice = 0;
    	int allprice = 0;
    	for (int i = 0; i < prices.length; i++) {
    		  if(min != Integer.MAX_VALUE && (prices[i] - min) > distantPrice ) {
    			  distantPrice = prices[i]-min;
    			  allprice += distantPrice;
    			  distantPrice = 0;
    			  min = Integer.MAX_VALUE;
    		  }
    		  if (min>prices[i]) {
				min = prices[i];
			}
		}
    	return allprice;

    }
    
    public static void main(String[] args) {
		int[] nums = {1,2,1,0,1};
		System.err.println(maxProfit(nums));
	}
}
