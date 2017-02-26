package test;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ZigzagLevelOrder {

	
	  public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	        if (root == null)
	            return res;
	        
	        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        list.add(root.val);
	        res.add(list);
	        if(root.right!=null)
	            queue.add(root.right);        
	        if(root.left!=null)
	            queue.add(root.left);
	        
	       boolean ace = true;
	      
	        while(queue.size()>0){
	            list = new ArrayList<Integer>();
	             ArrayList<TreeNode> q = new ArrayList<TreeNode>();
	            for(TreeNode node: queue){
	                list.add(node.val);
	                  if(root.right!=null)
	                      q.add(root.right);        
	                  if(root.left!=null)
	                      q.add(root.left);
	        
	            }
	            res.add(list);
	            queue.clear();
	            if (ace){
	                for(int i=q.size()-1;i>=0;i--){
	                    queue.add(q.get(i));
	                }
	                q.clear();
	            }else{
	                  queue = q;  
	            }
	                
	          
	            ace = !ace;
	            
	        }
	        return res;

	    }
	  
	  public static int reverse(int x) {
	       int res=0;
	       int y=x%10;
	       while(x>0.5){
	           res = res*10 + y;
	           x=x/10;
	           y=x%10;
	       } 
	        return res;    
	    }
	  public static int numTrees(int n) {
	        if(n==0||n==1||n==2)
	            return n;
	       return 2*(n-1)+(int)Math.pow(2,n)-numTrees(n-1);
	    }
	  
	  public static int run(TreeNode root) {
	        if(root==null)
	            return 0;
	        if(root.left==null&&root.right==null){
	            return 1;
	        }

	        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	      
	        if(root.left!=null)
	            list.add(root.left);
	        if(root.right!=null)
	            list.add(root.right);
	        int level = 2;
	        while(list.size()>0){
	        	  ArrayList<TreeNode> l = new ArrayList<TreeNode>();
	            for(TreeNode node:list){
	            	
	                if(node.left==null&&node.right==null){
	                    return level;
	                }
	                if(node.left!=null)
	                    l.add(node.left);
	                if(node.right!=null)
	                    l.add(node.right);
	            }
	            list.clear();
	            list = l;
	           
	            level++;
	        }
	        return level;
	        
	    }
	  
	  public static int evalRPN(String[] tokens) {
	        ArrayList<String> optstack = new ArrayList<String>();
	        for(String str: tokens){
	            if(isOpt(str)){
	                int a = getValue(optstack.get(optstack.size()-1));
	                int b = getValue(optstack.get(optstack.size()-2));
	                int c = opt(str,a,b);
	                optstack.remove(String.valueOf(a));
	                optstack.remove(String.valueOf(b));
	                optstack.add(String.valueOf(c));
	            }else{
	              optstack.add(str);
	            }
	        }
	        return getValue(optstack.get(0));
	    }
	    
	    private static boolean isOpt(String str){
	        if(str.toCharArray()[0]=='+'||str.toCharArray()[0]=='-'||str.toCharArray()[0]=='*'||str.toCharArray()[0]=='/')
	            return true;
	        return false;

	    }
	    private static int opt(String str,int a,int b){
	         if(str.toCharArray()[0]=='+')
		             return b+a;
		         else if (str.toCharArray()[0]=='-')
		              return b-a;
		         else if(str.toCharArray()[0]=='*')
		             return b*a;
		         else
		            return b/a;
	    }
	    private static int getValue(String str){
	        if(str.indexOf(0)==('-'))
	            return  -Integer.valueOf(str);
	        return Integer.valueOf(str);
	    }
	    public static int maxPoints(Point[] points) {
	      Map<Double, Integer> rateMap = new HashMap<Double,Integer>();
	      int max=0;
	      for (int i = 0; i < points.length; i++) {
			  rateMap.clear();
	    	  int duplicate = 1;
	    	  for (int j = 0; j < points.length; j++) {
				if(i==j)continue;
				if (points[i].x==points[j].x&&points[i].y==points[j].y) {
					duplicate++;
					continue;
				}
				double k = points[i].x == points[j].x ? 0.0 : (double)(points[j].y - points[i].y)/(points[j].x - points[i].x);
				Integer count = rateMap.get(k);
				if (count==null) {
					count=1;
				}else {
					count+=1;
				}
				rateMap.put(k, count);
			}
	    	if (max<duplicate) {
				max = duplicate;
			}
	    	 for (Double k : rateMap.keySet()) {
				if (max<rateMap.get(k)+duplicate) {
					max=rateMap.get(k)+duplicate;
				}
			}
		}
	    return max;
	    }
	    public static boolean Find(int target, int [][] array) {
	        int x=array[0].length-1;
	        int y=array.length-1;
	        if(target < array[0][y]){
	            return findLeft(target,array,0,--y,x,y);
	        }else if(target > array[0][y]){
	            return findDown(target,array,1,y,x,y);
	        }else{
	            return true;
	        }
	        
	    }
	    
	    private static boolean findDown(int target,int[][]array,int i,int j,int x,int y){
	        while(i<=y){
	            if(target>array[i][j]){
	                i++;
	            }else if( target < array[i][j]){
	                return findLeft(target,array,i,j,x,y);
	            }else{
	                return true;
	            }
	        }
	       return false;
	    }
	    
	    private static boolean findLeft(int target,int[][]array,int i,int j,int x,int y){
	        while(j>=0){
	            if(target<array[i][j]){
	                j--;
	            }else if(target>array[i][j]){
	                return findDown(target,array,i,j,x,y);
	            }else{
	                return true;
	            }
	        }
	      return false;
	    }
	    public static String replaceSpace(StringBuffer str) {
	      char[] rep = {'%','2','0'};
	      int c=0;
	      for (int i = 0; i < str.length(); i++) {
	    	  if (str.charAt(i)==' ') {
	    		  c++;
	    	  }
		  }
	      int resLength=str.length()+c*2;
	      char[] resChars = new char[resLength];
	      int count=0;
	      for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i)==' ') {
				resChars[count++]=rep[0];
				resChars[count++]=rep[1];
				resChars[count++]=rep[2];
			}else {
				resChars[count++]=str.charAt(i);
			}
		}
	      return new String(resChars);
	    }
	    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        if(pre.length==0){
	            return null;
	        }
	        TreeNode root = new TreeNode(pre[0]);
	        if(pre.length==1){
	            return root;
	        }
	        int index=0;
	        for(int i=0;i<in.length;i++){
	            if(in[i]==pre[0]){
	                index=i;
	                break;
	            }
	        }
	        int[] leftpre = new int[index];
	        int[] leftin = new int[index];
	        int[] rightpre = new int[pre.length-index-1];
	        int[] rightin = new int[in.length-index-1];
	        for(int i=1;i<pre.length;i++){
	            if(i<index+1){
	                leftpre[i-1]=pre[i];
	            }
	            if(i>index){
	                rightpre[i-index-1]=pre[i];
	            }
	        }
	        for(int i=0;i<in.length;i++){
	            if(i<index){
	                leftin[i]=in[i];
	            }
	            if(i>index){
	                rightin[i-index-1]=in[i];
	            }
	        }
	        root.left = reConstructBinaryTree(leftpre,leftin);
	        root.right= reConstructBinaryTree(rightpre,rightin);
	        return root;
	    }
	    
	   static Stack<Integer> stack1 = new Stack<Integer>();
	   static  Stack<Integer> stack2 = new Stack<Integer>();
	    
	    public static void push(int node) {
	        stack1.add(node);
	    }
	    
	    public static int pop() {
	        while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
	        int res = stack2.pop();
	        while(!stack2.isEmpty()){
	        	stack1.add(stack2.pop());
	        }
	        return res;
	    }
	    
	  public static void main(String[] args) {
		//["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
		  push(1);
		  push(2);
		  push(3);
		}
		

}
