package Repaso;

public class BinarySearch {
	public static int binarySearch(int[] arr, int dato) {
		int low=0;
		int high=arr.length-1;
		int mid;
		
		while(low<high) {
			mid=(low+high)/2;
			
			if(dato==arr[mid]) {
				return mid;
			}
			else if(dato<arr[mid]) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		int[] arr= {-234,-75,0,4,7,8,183,284,484,572,682,2860};
		
		System.out.println(binarySearch(arr, 484));
		
	}
	
}
