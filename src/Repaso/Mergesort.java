package Repaso;

public class Mergesort {
	
	public static void mergeSort(int[] arr) {
		int min=0;
		int max=arr.length-1;
		mergeSort(arr,min, max);
	}
	
	public static void mergeSort(int[] arr, int min, int max) {
		if(min<max) {
			int mid=(min+max)/2;
			
			mergeSort(arr, min, mid);
			
			mergeSort(arr, mid+1, max);
			
			merge(arr, min, max);
		}
		
	}
	
	public static void merge(int[] arr, int min, int max) {
		int[] tmp=new int[max-min+1];
		
		int mid=(min+max)/2,
			j=min,
			k=mid+1;
		
		for (int i = 0; i < tmp.length; i++) {
			if(j<=mid && k<=max) {
				if(arr[j]<arr[k]) {
					tmp[i]=arr[j];
					j++;
				}
				else {
					tmp[i]=arr[k];
					k++;
				}
			}
			else if(j<=mid) {
				tmp[i]=arr[j];
				j++;
			}
			else {
				tmp[i]=arr[k];
				k++;
			}
		}
		
		System.arraycopy(tmp, 0, arr, min, tmp.length);
		
	}
	
	public static String print(int[] arr) {
		String res="";
		
		for (int i = 0; i < arr.length; i++) {
			res+=arr[i]+",";
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {183, 8, 572, -334, 682, 484, 2860, 284, 4,0, -234, 7, -75};
		System.out.println(print(arr));
		mergeSort(arr);
		System.out.println(print(arr));
		
		
	}

}
