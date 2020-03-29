//Hector Humberto Herrera Macías A01632115
// BusquedaBinaria.java
// 24/01/19


public class BusquedaBinaria {
	public static int binarySearch(int num, int[] datos) {
		int min=0,
			max=datos.length-1,
			avg;
		
		while(min<=max) {
			avg=(min+max)/2;
			
			if(datos[avg]==num) {
				return avg;
			}
			else if(num<datos[avg]) {
				max=avg-1;
			}
			else if(num>datos[avg]) {
				min=avg+1;
			}
		}
		
		return -1;
	}
	
	public static int binarySearch(String str, String[] data) {
		int min=0,
			max=data.length-1,
			avg;
		
		do{
			avg=(min+max)/2;
			
			if(data[avg].equals(str)) {
				return avg;
			}
			else if(str.compareTo(data[avg])<0) {
				max=avg-1;
			}
			else if(str.compareTo(data[avg])>0) {
				min=avg+1;
			}
		}
			 while(min<=max);
		
		return -1;
	}
	
	public static int binarySearchRec(int num, int [] data) {
		int min=0,
			max=data.length-1;
		return binarySearchRec(num, min, max, data);
		
	}
	
	public static int binarySearchRec(int num, int min, int max, int[] data) {
		int avg=(min+max)/2;
		if(data[avg]==num) {
			return avg;
		}
		else if(num<data[avg]){
			return binarySearchRec(num, min, avg-1, data);
		}
		else if(num>data[avg]) {
			return binarySearchRec(num, avg+1, max, data);
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> int binarySearchRec(E[] valores,E valor) {
		int min=0,
			max=valores.length-1;
		
		return binarySearchRec(valores, valor, min, max);
	}

	private static <E extends Comparable<E>> int binarySearchRec(E[] valores,E valor,int min,int max) {
		int avg=(min+max)/2;
		if(valores[avg].equals(valor)) {
			return avg;
		}
		else if(valor.compareTo(valores[avg])<0){
			return binarySearchRec(valores, valor, min, avg-1);
		}
		else if(valor.compareTo(valores[avg])>0) {
			return binarySearchRec(valores, valor, avg+1, max);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30 , 40, 50, 60, 70 , 80, 90, 100};
		
		String[] valores= {"Aldo", "Brenda", "Carlos", "Daniel", "Flor", "Guillermo", "Hector", "Ignacio"};
		
		System.out.println(binarySearch(50, arr));
		
		System.out.println(binarySearchRec(60, arr));
		
		System.out.println(binarySearch("Hector", valores));
		
		System.out.println(binarySearchRec(valores, "Flor"));
	}
}
