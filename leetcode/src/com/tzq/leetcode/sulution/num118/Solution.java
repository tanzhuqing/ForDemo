package com.tzq.leetcode.sulution.num118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	if (numRows == 0) {
			return  lists;
		}
    	lists.add(Arrays.asList(1));
    	for (int i = 1; i < numRows; i++) {
			List<Integer> lastList = lists.get(lists.size()-1);
			List<Integer> list = new ArrayList<>();
			list.add(1);
			for (int j = 1; j < lastList.size(); j++) {
				list.add(lastList.get(j-1)+lastList.get(j));
			}
			list.add(1);
			lists.add(list);
		}
    	
    	return lists;
    }

    public static void main(String[] args) {
    	generate(3);
	}
}
