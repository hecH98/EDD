

public class Hanoi {
	static MyStack<Integer> torre1=new MyStack<>();
	static MyStack<Integer> torre2=new MyStack<>();
	static MyStack<Integer> torre3=new MyStack<>();
	
//	public static void resuelve(int n, int torre1, int torre2, int torre3) {
//		if(n==1){
//	  		System.out.println("mover disco de torre " + torre1 + " a torre " + torre3);
//	 	}
//	 	else{
//	    	resuelve(n-1, torre1, torre3, torre2);
//	    	System.out.println("mover disco de "+ torre1 + " a " + torre3);
//	    	resuelve(n-1, torre2, torre1, torre3);
//	 	}
//	}
	
	public static void acomoda(int discos, MyStack<Integer> torre1, MyStack<Integer> torre2, MyStack<Integer> torre3) {
		if(discos==1) {
			torre3.push(torre1.pop());
			System.out.println("mover disco de " + torre1+ " a " + torre3);		}
		else {
			System.out.println("discos: "+discos);
			acomoda(discos-1, torre1, torre3, torre2);
			torre3.push(torre1.pop());
	    	System.out.println("mover disco de "+ torre1 + " a " + torre3);
			acomoda(discos-1, torre2, torre1, torre3);
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			torre1.push(i);
		}
		System.out.println(torre1);
		System.out.println(torre2);
		System.out.println(torre3);
		
		acomoda(3, torre1, torre2, torre3);
		
		System.out.println("\ndespues");
		
		System.out.println(torre1);
		System.out.println(torre2);
		System.out.println(torre3);
	}

}
