
public class EjerciciosRecursivos {
	public static void main(String[] args) {
		System.out.println(contarNumeros(7271));
	}
	
	public static int contarNumeros(int num) {
		
		if(num%10 == 7) {
			return 1;
		}
		else {
			return contarNumeros(num/10);
		}
		
		
		
	}

}
