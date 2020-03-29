package Repaso;

public class Bubblesort {
	
	public static void bubblesort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	
	public static void imprime(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr= {183, 8, 572, 682, 484, 2860, 284, 4,0, -234, 7, -75};
		
		imprime(arr);
		
		bubblesort(arr);
		
		imprime(arr);
	}

}
