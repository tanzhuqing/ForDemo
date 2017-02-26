package test;

public class SortDemo {
	private void swap(int array[],int i,int j){
		int tmp = array[i];
		array[j]=array[i];
		array[i]=tmp;
	}
	
	//������
	//�������� O(n^2),����ʱO(n)
	public void insertSort(int array[],int n) {
		int tmp=0; //��ʱ����
		for (int i = 1; i < n; i++) { //���β����i����¼
			tmp=array[i]; //��i��ʼ��ǰ�Ҽ�¼i����ȷλ��
			int j=i-1;//����Щ���ڵ��ڼ�¼i�ļ�¼����
			while (j>=0 && (tmp<array[j])) {
				array[j+1]=array[j];
				j=j-1;
			}
			//��ʱj������Ǽ�¼i����ȷλ�ã�����
			array[j+1]=tmp;
		}
	}
		
	//shell����

	public void shellSort(int array[],int n) {
		int i,delta;
		//����deltaÿ�γ���2�ݼ� 
		for (delta = n/2; delta>0; delta/=2) {
			for (i = 0; i<delta; i++) {
				//�ֱ��delta�������н��в�������
				modInsSort(array,n-i,delta);
				//����������в��ܱ�֤���һ��delta���Ϊ1,���԰����������ɨβ���ʵĲ�������
			}			
		}
	}
	
	private void modInsSort(int array[],int n,int delta){
		int i,j;
		//���������е�i����¼��Ѱ�Һ��ʵĲ���λ��
		for ( i = delta; i < n; i+=delta) {
			//j��deltaΪ������ǰѰ�����öԽ��е���
			for (j =  i; j>=delta; j-=delta) {
				if (array[j]<array[j-delta]) { //���ö�
					int tmp = array[j];  //����
					array[j]=array[j=delta];
					array[j-delta]=tmp;
				}else {
					break;
				}				
			}
		}
	}
	
	
	//ֱ��ѡ������
	//���ȶ���ʱ�����O(n^2)
	
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
	//������
	//����O(n),ɾ���Ѷ�O(logn)
	public void  heapSort(int array[],int n) {
		int i;
		MaxHeap<Integer> nax_heap = new MaxHeap<Integer>(array,n,n);
		for (i = 0; i < n-1; i++) {
			max_heap.RemoveMax();
		}
		
	}*/
	
	//��������
	//ð������  O(n^2),  ���ȶ�
	public void buble(int array[],int n) {
		boolean noswap;  //�Ƿ����˽����ı�־
		int i,j;
		for (i = 0; i < n-1; i++) {
			noswap = true; //��ʼ��־Ϊ��
			for (j=n-1;j>i;j--) {
				if (array[j]<array[j-1]) { //�ж��ǹ�����
					int tmp = array[j];  //�������ö�
					array[j]=array[j-1];
					array[j-1]=tmp;
					noswap = false;  //�����˽�������Ǳ�ɼ�
				}
				if (noswap) {
					return;   //û������������������ź���
				}
			}
		}
	}
	
	//��������
	//ʱ��O(nlogn),�ռ�O(logn)
	
	public void quickSort(int array[],int left,int right) {
		if (right<=left) {
			return;
		}
		int pivot = SelectPivot(left,right); //ѡ����ֵ
		swap(array, pivot, right); //��ֵ��������ĩ��
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
