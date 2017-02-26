package com.tzq.leetcode.sulution.num131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//深度优先搜索
	private List<List<String>> res = new ArrayList<>();
	private boolean[][] palindrome;
	private void find(String s,List<String> partition,int from){
		if (from == s.length()) {
			List<String> resultList = new ArrayList<>();
			resultList.addAll(partition);
			res.add(resultList);
			return;
		}
		for (int i = 0;from+ i < palindrome.length; i++) {
			if (!palindrome[i][from]) {
				continue;
			}
			partition.add(s.substring(from,from+1+i));
			find(s, partition, from+i+1);
			partition.remove(partition.size()-1);
		}		
	}
	
    public List<List<String>> partition(String s) {
        if (s==null||"".equals(s)) {
			return res;
		}
        palindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < palindrome.length; i++) {
			for (int j = 0;i+ j < palindrome.length; j++) {
				if (i==0) {
					palindrome[i][j]=true;
				}else if (i==1) {
					if (s.charAt(j)==s.charAt(j+i)) {
						palindrome[i][j]=true;
					}else {
						palindrome[i][j]=false;
					}
				}else {
					if (palindrome[i-2][j+1] && s.charAt(j)==s.charAt(j+i)) {
						palindrome[i][j]=true;
					}else {
						palindrome[i][j]=false;
					}
				}
			}
		}
    find(s, new ArrayList<String>(), 0);
    return res;
    
    
    }
}
