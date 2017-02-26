package com.tzq.leetcode.sulution.num74;

public class Solution {
	//¶þ·Ö·¨
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0|| matrix[0].length == 0) {
			return false;
		}
        int i=0,j=matrix.length * matrix[0].length-1;
        while (i<=j) {
			int m = i + (j-i)/2;
			int row = m/matrix[0].length;
			int col = m%matrix[0].length;
			if (matrix[row][col] == target) {
				return true;
			}
			if (matrix[row][col] < target) {
				i = m+1;
			}else {
				j = m-1;
			}
		}
        return false;
    }
}
