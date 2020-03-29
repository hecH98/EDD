//Hector Humberto Herrera Macías A01632115
// BubbleSort.java
// 28/01/19

public class BubbleSort {
	public static void bubbleSort(int[] numeros) {
		for (int i = 0; i < numeros.length-1; i++) {
			for (int j = 0; j < numeros.length-1-i; j++) {
				if(numeros[j]>numeros[j+1]) {
					swap(numeros,j,j+1);
				}
			}
		}
	}
	
	private static void swap(int[] numeros, int i, int j) {
		int tmp;
		tmp=numeros[i];
		numeros[i]=numeros[j];
		numeros[j]=tmp;
	}
	
	private static <E> void swap(E[] numeros, int i, int j) {
		E tmp;
		tmp=numeros[i];
		numeros[i]=numeros[j];
		numeros[j]=tmp;
	}
	
	public static void imprimeArreglo(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+",");
		}
		System.out.println();
	}
	
	public static <E> void imprimeArreglo(E[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+",");
		}
		System.out.println();
	}
	
	public static <E extends Comparable<E>> void bubbleSort(E[] arreglo) {
		for (int i = 0; i < arreglo.length-1; i++) {
			for (int j = 0; j < arreglo.length-1-i; j++) {
				if(arreglo[j].compareTo(arreglo[j+1])>0) {
					swap(arreglo,j,j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr= {183, 8, 572, 682, 484, 2860, 284, 4,0, -234, 7, -75};
		
		String[] str= {"Hector", "Aldo", "Tlaloc", "David","Zacatecas", "Kiera", "Fernando"};
		
		imprimeArreglo(arr);
		bubbleSort(arr);
		imprimeArreglo(arr);
		
		imprimeArreglo(str);
		bubbleSort(str);
		imprimeArreglo(str);
	}
}
