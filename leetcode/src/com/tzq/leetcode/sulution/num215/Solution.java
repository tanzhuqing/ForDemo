package com.tzq.leetcode.sulution.num215;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();  
        for(int i=0;i<nums.length;i++){  
            pq.offer(nums[i]);  
        }  
        for(int j=1;j<nums.length+1-k;j++){  
             pq.poll();  
        }  
        return pq.poll();  
    }
}
