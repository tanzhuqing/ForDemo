package com.tzq.leetcode.sulution.num278;

public class Solution extends VersionControl  {
	//���ֲ��ҷ�
    public int firstBadVersion(int n) {
        long i=1,j=n;
        while (i<=j) {
			int m = (int)(i+(j-i)/2);
			if (isBadVersion(m)) {
				j=m-1;
			}else {
				i=m+1;
			}
		}
        return (int)i;
    }
}
