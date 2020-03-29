
public class example {
	
	public void bubbleSort(int[] list) {
		int tmp=0;
		for (int i = 0; i < list.length-1; i++) {
			for (int j = 0; j < list.length-1-i; j++) {
				if(list[j]>list[j+1]) {
					tmp=list[j];
					list[j]=list[j+1];
					list[j+1]=tmp;
				}
			}
		}
	}
	
	public <E extends Comparable <E>> void bubbleSort(E[] list){
		E tmp;
		for (int i = 0; i < list.length-1; i++) {
			for (int j = 0; j < list.length-1-i; j++) {
				if(list[j].compareTo(list[j+1])>0) {
					tmp=list[j];
					list[j]=list[j+1];
					list[j+1]=tmp;
				}
			}
		}
	}
	
	public void mergeSort(int[] array) {
		int low=0;
		int high=array.length-1;
		mergeSort(low, high);
	}
	
	public void mergeSort(int low, int high) {
		if(low<high) {
			int mid=(low+high)/2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			merge(low, mid, high);
		}
	}
	
	public void merge(int low, int mid, int high) {
		for (int i = 0; i <= high; i++) {
//			helper[i]=numbers[i];
		}
		int i=low,
			j=mid+1,
			k=low;
		
		while(i<=mid && j<=high) {
			
		}
	}
	
	//		num= number to search,	list= array
	public String binarySearch(int num, int[] list) {
		int low=0, 
			mid=0, 
			high =list.length-1;
		
		
		while(low<=high) {
			mid=(low+high)/2;
			
			if(list[mid]==num) {
				return "Number " + num + " found at index "+mid;
				
			}
			else if(num<mid) {
				high=mid-1;
			}
			else if(num>mid) {
				low=mid+1;
			}
		}
		
		return "Number " + num + " not found in array";
	}
	
	public static void main(String[] args){
		Integer[] arr= {40, 368, 16, -10, 7, 89, 0, 174, -54, 18,50};

		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println();
		
		example ex = new example();
		ex.bubbleSort(arr);
		
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println();
		
		//System.out.println(ex.binarySearch(40, arr));
		
	}
}
