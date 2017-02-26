package com.tzq.leetcode.sulution.num383;


public class RansomNote {
	public static class Solution {
		public  boolean canConstruct(String ransomNote, String magazine) {
			char[] rn = ransomNote.toCharArray();
			char[] mg = magazine.toCharArray();
			int size = rn.length;
			for (char r : rn) {
				for (int i = 0; i < mg.length; i++) {
					if (r == mg[i]) {
						size--;
						mg[i]=' ';
						break;
					}
				}
			}

			if (size==0) {
				return true;
			}else {
				return false;
			}
		}
	
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canConstruct("bjaajgea",
				"affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
		
	}
}
