//Hector Humberto Herrera Macías A01632115
// Recursividad.java
// 19/01/19


public class Recursividad {
	public static int sumatoria(int n) {
		if(n<=1) {
			return 1;
		}
		else {
			return n+sumatoria(n-1);
		}
	}

	public static String base10a2(int numero) {
		if(numero==1) {
			return "1";
		}
		else if(numero==0) {
			return "0";
		}
		else if(numero%2==0) {
			return base10a2(numero/2)+"0";
		}
		else {
			return base10a2(numero/2)+"1";
		}
	}

	public static void main(String[] args) {
		System.out.println(sumatoria(10));
		System.out.println(base10a2(123));
	}

}
