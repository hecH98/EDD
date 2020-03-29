package Repaso;

public class Quicksort {
	
	public static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	
	public static void quicksort(int[] arr, int min, int max) {
		if (min<max) {
			int p=particionar(arr, min, max);
			quicksort(arr, min, p-1);
			quicksort(arr, p+1, max);
		}
	}
	
	public static int particionar(int[] arr, int min, int max) {
		int p=arr[min];
		
		int i=min+1;
		for (int j = min+1; j<=max;j++) {
			if(arr[j]<p) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, min, i-1);
		
		return i-1;
	}
	
	public static void swap(int[] arr,int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public static String print(int[] arr){
		String res="";
		
		for (int i = 0; i < arr.length; i++) {
			res+=arr[i]+",";
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr= {183, 8, 572, -334, 682, 484, 2860, 284, 4,0, -234, 7, -75};
		System.out.println(print(arr));
		quicksort(arr);
		System.out.println(print(arr));
		
	}
}
