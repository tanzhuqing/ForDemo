package com.tzq.leetcode.sulution.num39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> sums = new LinkedList<Integer>();
        dfs(candidates, target, 0, res, sums);
        return res;
    }
    
    private void dfs(int[] candidates,int target,int start,List<List<Integer>> res, LinkedList<Integer> sums){
    	if (target == 0) {
			List<Integer> tmp = new LinkedList<Integer>(sums);
			res.add(tmp);
			return;
		}
    	for (int i = start; i < candidates.length; i++) {
			if (target<candidates[i]) {
				continue;
			}
			sums.push(candidates[i]);
			dfs(candidates, target-candidates[i], i, res, sums);
			sums.pop();
		}
    	
    }
}
