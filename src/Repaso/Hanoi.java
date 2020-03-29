package Repaso;

public class Hanoi {
	
	public static void resuelve(int n, int torre1, int torre2, int torre3) {
		if(n==1){
	  		System.out.println("mover disco de torre " + torre1 + " a torre " + torre3);
	 	}
	 	else{
	    	resuelve(n-1, torre1, torre3, torre2);
	    	System.out.println("mover disco de "+ torre1 + " a " + torre3);
	    	resuelve(n-1, torre2, torre1, torre3);
	 	}
	}
	
	public static void main(String[] args) {
		resuelve(3, 1, 2, 3);
	}

}
