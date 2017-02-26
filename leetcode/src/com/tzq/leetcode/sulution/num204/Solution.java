package com.tzq.leetcode.sulution.num204;

public class Solution {
	public int countPrimes(int n) {
		 boolean[] prime = new boolean[n];  
         
         //ȫ���Ϊ����  
         for(int i=0;i<prime.length;i++)  
         {  
             prime[i] = true;  
         }  


         for (int i = 2; i < n; i++)  
         {  
             if (prime[i])  
             {  
                 // ��i��2����3����4��...�����Ϊ������  
                 //��ʼֵΪ:i*2; �߽�����j<n; j=j+i; ����jÿ�μ�i������2,3,4��  
                 for (int j = i * 2; j < n; j = j + i)  
                 {  
                     prime[j] = false;  
                 }  
             }  
         }  


         int count = 0;  
         for (int i = 2; i < n; i++)  
         {  
             if (prime[i]) count++;  
         }  
         return count;  

	}
}
