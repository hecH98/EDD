package ExamenParcial1;

public class DigitoPalabra {
	public static void digitoPal(int num) {
		String str=num+"";
		if(str.length()==1) {
			System.out.print(letra(num)+" ");
		}
		else {
			
			int num2=num/10;
			digitoPal(num2);
			
			num=num%10;
			System.out.print(letra(num)+" ");
		}
	}
	
	private static String letra(int digito) {
		switch (digito) {
			case 1: return "uno"; 
			case 2: return "dos";
			case 3: return "tres";
			case 4: return "cuatro";
			case 5: return "cinco";
			case 6: return "seis";
			case 7: return "siete";
			case 8: return "ocho";
			case 9: return "nueve";
			case 0: return "cero";

		default:
			return "Error.";
		}
	}
	
	public static void main(String[] args) {
		digitoPal(12345);
		
	}
}
