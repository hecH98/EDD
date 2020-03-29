
public class Fibonacci {
	public static long fibonacci(int numero) {
		if(numero==0 || numero==1) {
			return 1;
		}
		else {
			return fibonacci(numero-1) + fibonacci(numero-2);
		}
	}
	
	public static long fibonacciOpt(int n) {
		long[] tabla=new long[n+1];
		tabla[0]=tabla[1]=1;
		return fibonacciOpt(n, tabla);
	}
	
	public static long fibonacciOpt(int n, long[] tabla) {
		if(tabla[n]!=0) {
			return tabla[n];
		}
		else {
			tabla[n]=fibonacciOpt(n-1,tabla)+fibonacciOpt(n-2, tabla);
			return tabla[n];
		}
	}
	
	public static long fibonacciArray(int n) {
		long arr[]= {0,1};
		
		long tmp;
		
		for(int i=0; i< n ; i++) {
			tmp=arr[0]+arr[1];
			arr[0]=arr[1];
			arr[1]=tmp;
		}
		
		return arr[1];
	}
	
	public static void main(String[] args) {
		
		int prueba = 45;
		
		long inicio = System.nanoTime();
		System.out.println(fibonacci(prueba));
		long fin = System.nanoTime();
		long total = (fin - inicio);
		System.out.println("tiempo de ejecucion 0: " + total);
		
		inicio=fin=0;
		inicio = System.nanoTime();
		System.out.println(fibonacciOpt(prueba));
		fin = System.nanoTime();
		total = (fin - inicio);
		System.out.println("tiempo de ejecucion 1: " + total);
		
		inicio=fin=0;
		inicio = System.nanoTime();
		System.out.println(fibonacciArray(prueba));
		fin = System.nanoTime();
		total = (fin - inicio);
		System.out.println("tiempo de ejecucion 2: " + total);
	}
}
