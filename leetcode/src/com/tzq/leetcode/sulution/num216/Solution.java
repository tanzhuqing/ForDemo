package com.tzq.leetcode.sulution.num216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (k==0||n==0) {
			return lists;
		}
        List<Integer> tmp = new ArrayList<>();
        helper(lists, tmp, k, n, 1);
        return lists;
    }
    
    private void helper(List<List<Integer>> res,List<Integer> tmp,int k,int n,int num){
    	if (tmp.size() == k && n==0) {
			res.add(new ArrayList<>(tmp));
			return;
		}
    	else if (tmp.size()>k || n < 0) {
			return;
		}
    	for (int i = num; i <= 9; i++) {
			if (i>n) {
				return;
			}
			tmp.add(i);
			n-=i;
			helper(res, tmp, k, n, i+1);
			n+=i;
			tmp.remove(tmp.size()-1);
		}
    }
}
