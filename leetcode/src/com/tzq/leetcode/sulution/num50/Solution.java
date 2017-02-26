package com.tzq.leetcode.sulution.num50;

public class Solution {
	//二分法，递归
    public double myPow(double x, int n) {
        if (n==0) {
			return 1;
		}
        if (n<-0) {
			n = -n;
			x = 1/x;
		}
        if (n==1) {
			return x;
		}
        if (n==2) {
			return x*x;
		}
        return myPow(myPow(x, n/2), 2) * myPow(x, n-n/2*2);
    }
    //倍乘，迭代
    public double mpow(double x,int n) {
		long ln = (long) n;
		if (ln < 0) {
			x = 1.0/x;
			ln = -ln;
		}
		double pow = 1.0;
		while (ln > 0) {
			double p = x;
			long m =1;
			for (; m*2<ln;m*=2,p*=p);
			pow *= p;
			ln -= m;
		}
		return pow;
	}
}
