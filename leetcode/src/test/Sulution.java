package test;

import java.util.HashSet;
import java.util.Set;

public class Sulution {
	  public static int minNumberInRotateArray(int [] array) {
	       if(array.length==0){
	           return 0;
	       }
	       if(array.length == 1){
	           return array[0];
	       }
	        int min = array[array.length-1];
	        int midindex = array.length/2;
	        int mid = array[midindex];
	        if(mid>array[array.length-1]){
	            return getmin(array,midindex,array.length-1,min);
	        }
	        if(mid<array[array.length-1]){
	        	min = mid;
	            return getmin(array,0,midindex,min);
	        }
	        return min;
	    }
	    
	    private static int getmin(int[] array,int i,int j,int min){
	        if(min>array[j]){
	            min = array[j];
	        }
	        
	        int midindex = (i+j)/2;
	        int mid = array[midindex];
	        if(mid>array[j])
	            return getmin(array,midindex,j-1,min);
	        if(mid<array[j]){
	        	if (min>mid) {
	        		min = mid;
				}	        	
	            return getmin(array,i,midindex,min);
	        }
	        return min;
	    }
	    
	    public static int JumpFloorII(int target) {
	        if(target==1||target==2){
	            return target;
	        }
	        int res = 1;
	        for(int i=1;i<target;i++){
	        	System.err.println(i+" "+JumpFloor(i));
	           // res +=JumpFloor(i);
	        }
	        return res;
	    }
	    public static int JumpFloor(int target) {
	        if(target==1||target==2){
	            return target;
	        }
	        return JumpFloor(target-1)+JumpFloor(target-2);
	    }
	    public static int NumberOf1(int n) {
	        int count = 0;
	       for (int i = 0; i < 32; i++) {
			count += n&1;
			n = n>>1;
		   }    
	      return count;
	    }
	    
	    public static double Power(double base, int exponent) {
	        if(exponent==0){
	            return 1.0;
	        }
	        if(exponent==1){
	            return base;
	        }
	        return Power(base,exponent-1)*base;
	  }
	    
	    public static boolean wordBreak(String s, Set<String> dict) {
	        boolean[] t = new boolean[s.length()+1];
	        t[0]=true;
	        for(int i=0;i<s.length();i++){
	            if(!t[i])
	                continue;
	            
	            for(String a:dict){
	                int len = a.length();
	                int end = i + len;
	                
	                if(end>s.length())
	                    continue;
	                
	                if(s.substring(i,end).equals(a))
	                    t[end]=true;
	            }
	                
	        }
	            
	       return t[s.length()];     
	    }
	    
	    public static int countBitDiff(int m, int n) {
	        int count=0;
	        while(m>0||n>0){
	         if(m%2==n%2){  
	             m=m>>1;
	             n=n>>1;
	         }else{
	        	 count++;
	             m=m>>1;
	             n=n>>1;
	         }	         
	        }
	        return count;
	    }
	    public static void main(String[] args) {
			System.err.println(countBitDiff(1999, 2299));
		}

}
