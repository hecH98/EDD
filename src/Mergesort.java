
public class Mergesort {
	
	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		int min=0,
			max=datos.length-1;
		mergesort(datos, min, max);
	}
	
	private static <E extends Comparable<E>> void mergesort(E[] datos, int min, int max) {
		if(min<max) {
			int central=(min+max)/2;
			mergesort(datos, min, central);
			mergesort(datos, central+1, max);
			merge(datos, min, max);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <E extends Comparable<E>> void merge(E[] datos, int min, int max) {
		E[] tmp=(E[]) new Comparable[max-min+1];
		
		int central=(max+min)/2,
		    j=min,
			k=central+1;
		
		for (int i = 0; i < tmp.length; i++) {	
			if(j<=central && k<=max) {
				if(datos[j].compareTo(datos[k])<0) {
					tmp[i]=datos[j++];
				}
				else {
					tmp[i]=datos[k++];
				}
			}
			else if(j<=central) {
				tmp[i]=datos[j++];
			}
			else {
				tmp[i]=datos[k++];
			}
			
		}
		System.arraycopy(tmp, 0, datos, min, tmp.length);
	}
	
	public static <E> void imprimeArreglo(E[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] arr= {183, 8, 572, 682, 484, 2860, 284, 4,0, -234, 7, -75};
		imprimeArreglo(arr);
		mergesort(arr);
		imprimeArreglo(arr);
	}
}
