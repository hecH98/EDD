//Hector Humberto Herrera Macías A01632115
// Arreglo.java
// 20/01/19


public class Arreglo {
	private int contador;
	private int[] arreglo;
	
	public Arreglo() {
		this.arreglo=new int[10];
		this.contador=0;
	}
	
	public Arreglo(int n) {
		this.arreglo=new int[n];
		this.contador=0;
	} 
	
	public void insertar(int n) throws IllegalStateException{
		if(this.contador==this.arreglo.length) {
			throw new IllegalStateException("No se puede insertar en un arreglo lleno");
		}
		else {
			this.arreglo[contador++]=n;
		}
	}
	
	public int borrar(int n) throws IllegalStateException{
		int x=this.arreglo[n-1];;
		if(n>contador) {
			throw new IllegalStateException("Posición invalida para borrar");
		}
		else {
			for(int i=n;i<this.arreglo.length;i++) {
				this.arreglo[i-1]=this.arreglo[i];
			}
			this.arreglo[--contador]=0;
		}
		return x;
	}
	
	public String toString() {
		String str="";
		for(int i=0; i<this.arreglo.length; i++) {
			str+=this.arreglo[i]+",";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Arreglo prueba=new Arreglo();
		prueba.insertar(1);
		prueba.insertar(2);
		prueba.insertar(3);
		prueba.insertar(4);
		prueba.insertar(98);
		prueba.insertar(0);
		prueba.insertar(1);
//		prueba.insertarDato(5);prueba.insertarDato(5);prueba.insertarDato(5);prueba.insertarDato(5);prueba.insertarDato(5);prueba.insertarDato(5);
		System.out.println(prueba);
		System.out.println(prueba.borrar(5));
		System.out.println(prueba);
	}
}
