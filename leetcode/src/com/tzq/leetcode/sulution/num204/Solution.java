package com.tzq.leetcode.sulution.num204;

public class Solution {
	public int countPrimes(int n) {
		 boolean[] prime = new boolean[n];  
         
         //全标记为素数  
         for(int i=0;i<prime.length;i++)  
         {  
             prime[i] = true;  
         }  


         for (int i = 2; i < n; i++)  
         {  
             if (prime[i])  
             {  
                 // 将i的2倍、3倍、4倍...都标记为非素数  
                 //初始值为:i*2; 边界条件j<n; j=j+i; 保障j每次加i，就是2,3,4倍  
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
