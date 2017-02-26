package test;

public class SortDemo {
	private void swap(int array[],int i,int j){
		int tmp = array[i];
		array[j]=array[i];
		array[i]=tmp;
	}
	
	//内排序
	//插入排序 O(n^2),正序时O(n)
	public void insertSort(int array[],int n) {
		int tmp=0; //临时变量
		for (int i = 1; i < n; i++) { //依次插入第i个记录
			tmp=array[i]; //从i开始往前找记录i的正确位置
			int j=i-1;//将那些大于等于记录i的记录后移
			while (j>=0 && (tmp<array[j])) {
				array[j+1]=array[j];
				j=j-1;
			}
			//此时j后面就是记录i的正确位置，回填
			array[j+1]=tmp;
		}
	}
		
	//shell排序

	public void shellSort(int array[],int n) {
		int i,delta;
		//增量delta每次除以2递减 
		for (delta = n/2; delta>0; delta/=2) {
			for (i = 0; i<delta; i++) {
				//分别对delta个子序列进行插入排序
				modInsSort(array,n-i,delta);
				//如果增量序列不能保证最后一个delta间隔为1,可以安排下面这个扫尾性质的插入排序
			}			
		}
	}
	
	private void modInsSort(int array[],int n,int delta){
		int i,j;
		//对子序列中第i个记录，寻找合适的插入位置
		for ( i = delta; i < n; i+=delta) {
			//j以delta为步长向前寻找逆置对进行调整
			for (j =  i; j>=delta; j-=delta) {
				if (array[j]<array[j-delta]) { //逆置对
					int tmp = array[j];  //交换
					array[j]=array[j=delta];
					array[j-delta]=tmp;
				}else {
					break;
				}				
			}
		}
	}
	
	
	//直接选择排序
	//不稳定，时间代价O(n^2)
	
	public void selectSort(int array[],int n){
		for (int i = 0; i < n-1; i++) {
			int smallest = i;
			for (int j = i+1; j < n; j++) {
				if (array[j]<array[smallest]) {
					smallest=j;
				}			
			}
			int tmp = array[i];
			array[i]=array[smallest];
			array[smallest]=tmp;
		}
	}
	
/*	
	//堆排序
	//建堆O(n),删除堆顶O(logn)
	public void  heapSort(int array[],int n) {
		int i;
		MaxHeap<Integer> nax_heap = new MaxHeap<Integer>(array,n,n);
		for (i = 0; i < n-1; i++) {
			max_heap.RemoveMax();
		}
		
	}*/
	
	//交换排序
	//冒泡排序  O(n^2),  不稳定
	public void buble(int array[],int n) {
		boolean noswap;  //是否发生了交换的标志
		int i,j;
		for (i = 0; i < n-1; i++) {
			noswap = true; //初始标志为真
			for (j=n-1;j>i;j--) {
				if (array[j]<array[j-1]) { //判断是够逆置
					int tmp = array[j];  //交换逆置对
					array[j]=array[j-1];
					array[j-1]=tmp;
					noswap = false;  //发生了交换，标记变成假
				}
				if (noswap) {
					return;   //没发生交换，则已完成排好序
				}
			}
		}
	}
	
	//快速排序
	//时间O(nlogn),空间O(logn)
	
	public void quickSort(int array[],int left,int right) {
		if (right<=left) {
			return;
		}
		int pivot = SelectPivot(left,right); //选择轴值
		swap(array, pivot, right); //轴值放在数组末端
		pivot = Partition(array,left,right);
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
		
	}
	private int SelectPivot(int left,int right){
		return (left+right)/2;
	}
	
	private int Partition(int array[],int left,int right){
		int l = left;
		int r = right;
		int tmp = array[r];
		while (l!=r) {
			while (array[l]<=tmp && r>l) {
				l++;
			}
			if (l<r) {
				array[r]=array[l];
				r--;
			}
			while (array[r]>=tmp && r>l) {
				r--;
			}
			if (l<r) {
				array[l]=array[r];
				l++;
			}
		}
		array[l]=tmp;
		return l;
	}
}
