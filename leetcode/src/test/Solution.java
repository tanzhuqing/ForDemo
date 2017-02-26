package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.omg.CORBA.INTERNAL;

public class Solution {
	
	  public static int candy(int[] ratings) {
	        int length=ratings.length;
	        if(length==0){
	            return -1;
	        }
	        if(length==1){
	            return 1;
	        }
	        
	        int total=0;
	        int[] can = new int[length];
	        for (int i = 0; i < can.length; i++) {
				can[i]=1;
			}
	        for(int i=1;i<length;i++){
	            if(ratings[i]>ratings[i-1])
	            	can[i]=can[i-1]+1;
	        }
	        for(int i=length-2;i>=0;i--){
	           if (ratings[i]>ratings[i+1]&&can[i]<=can[i+1]) {
				   can[i]=can[i+1]+1;
			  }
	        }
	        for(int i=0;i<length;i++){
	            total+=can[i];
	        }
	        
	        return total;
	    }
	  
	  public static ArrayList<ArrayList<String>> partition(String s) {
	        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	        Stack<String> stack = new Stack<String>();
	        while (true) {
	        	  for (int i = 0; i < s.length(); i++) {
	  	        	ArrayList<String> list = new ArrayList<>();
	  	        	
	  			}				
			}
	    }
	  
	  public static int numDistinct(String S, String T) {
		  int lens=S.length();
		  int lent = T.length();
		  if(lent == 0)return 1;
          else if(lens == 0)return 0;
	      int d[][]= new int[lens+1][lent+1];
          for (int i = 0; i <= lens; i++) {
			d[i][0]=1;
		  }
          for (int i = 1; i <= lens; i++) {
			for (int j = 1; j <= lent; j++) {
				if (S.charAt(i-1)==T.charAt(j-1)) {
					d[i][j]=d[i-1][j-1]+d[i-1][j];
				}else {
					d[i][j]=d[i-1][j];
				}
			}
		}

		  
		  
		  return d[lens][lent];
	    }
	  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		  if (root==null) {
			  return res;
		}
		  ArrayList<Integer> copy = new ArrayList<>(); 
		  copy.add(root.val);
		  if (root.val==sum&&root.left==null&&root.right==null) {
			res.add(copy);
			return res;
		}

		  pathSum(root.left, sum-root.val,res,copy);
		  pathSum(root.right, sum-root.val,res,copy);
		  return res;
	   }
	   private static void pathSum(TreeNode node,int sum,ArrayList<ArrayList<Integer>> result,ArrayList<Integer>  list){
		   if (node==null) {
			return;
		}
		   ArrayList<Integer> copy = new ArrayList<>(list);  
		   if (sum<node.val) {
			return;
		}
		   copy.add(node.val);
		   int rsum = sum-node.val;
	       if(node.val==sum&&node.left==null&&node.right==null){
	        	result.add(copy);
	        }
	     
           if(rsum>0){
                pathSum(node.left, sum-node.val,result,copy);
	             pathSum(node.right, sum-node.val,result,copy);
           }
	       
	   }

	  public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        int len = triangle.size();
	        if (len==0) {
				return 0;
			}
	        int d[]=new int [len+1];
	        d[0]=triangle.get(0).get(0);
	        for (int i = 1; i < len; i++) {
	        	d[i]=d[i-1]+triangle.get(i).get(i);
	        	for (int j = i-1; j > 0; j--) {
					d[j]=Math.min(d[j-1], d[j])+triangle.get(i).get(j);
				}
	        	d[0]+=triangle.get(i).get(0);
			}
	        int x =d[0];
	        for (int i=1;i<len;i++) {
				if (x>d[i]) {
					x=d[i];
				}
			}
	        return x;
	    }
	  public static boolean hasPathSum(TreeNode root, int sum) {
	        if (root==null) {
				return false;
			}
	        if (root.val==sum&&root.left==null&root.right==null) {
				return true;
			}
	        if (root.left!=null&&hasPathSum(root.left, sum-root.val)==true) {
				 return true;
			}
	        if (root.right!=null&&hasPathSum(root.right, sum-root.val)==true) {
				return true;
			}
	        return false;
	    }
	  
	  public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left= new TreeNode(4);
		root.left.left= new TreeNode(11);
		root.left.left.left= new TreeNode(7);
		root.left.left.right=new TreeNode(2);
		root.right= new TreeNode(8);
		root.right.left= new TreeNode(13);
		root.right.right= new TreeNode(4);
		root.right.right.left= new TreeNode(5);
		root.right.right.right= new TreeNode(1);
		
		System.err.println(hasPathSum(root, 22));
		
	}

}
