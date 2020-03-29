//Hector Humberto Herrera Macías A01632115
// Quicksort.java
// 07/02/19

public class Quicksort {
	
	public static <E extends Comparable<E>>void quicksort(E[] datos){
		quicksort(datos, 0, datos.length-1);
	}
	
	private static <E extends Comparable<E>> void quicksort(E[] datos, int min, int max) {
		if(min<max) {
			int p=particionar(datos, min, max);
			quicksort(datos, min, p-1);
			quicksort(datos, p+1, max);
		}
	}
	
	private static <E extends Comparable<E>> int particionar(E[] datos, int min, int max) {
		E p=datos[min];
		int i=min+1;
		for(int j=min+1;j<=max;j++) {
			if(p.compareTo(datos[j])>0) {
				
				swap(datos,i,j);
				i++;
			}
		}
		swap(datos, min, i-1);
		
		return i-1;
	}
	
	
	
	private static <E extends Comparable<E>> void swap(E[] datos, int i, int j) {
		E tmp=datos[i];
		datos[i]=datos[j];
		datos[j]=tmp;
	}
	
	public static <E> void imprimeArreglo(E[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] arr= {3,8,2,5,1,4,7,6};
		imprimeArreglo(arr);
		quicksort(arr);
		imprimeArreglo(arr);
	}

}
