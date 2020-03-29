package ExamenParcial1;

public class ListaEnlazadaEx {
	NodoLEEx inicio;
	
	public ListaEnlazadaEx(int[] arr) {
		int tmp=arr.length-1;
		for (int i = 0; i < arr.length; i++) {
			NodoLEEx nodo=new NodoLEEx(arr[tmp--]);
			
			if(this.inicio==null) {
				this.inicio=nodo;
			}
			else {
				nodo.setNext(this.inicio);
				this.inicio=nodo;
			}
		}
	}
	
	public String toString() {
		NodoLEEx curr=inicio;
		String res="";
		while(curr!=null) {
			res += curr.getDato()+",";
			curr=curr.getNext();
		}
		return res;
	}
	
//	public void borrarDato(NodoLEEx nodo) {
//		nodo.setDato(nodo.getNext().getDato());
//		nodo.setNext(nodo.getNext().getNext());
//	}		
//	public NodoLEEx returnNodo() {
//		return this.inicio.getNext().getNext();
//	}
	
	public static void main(String[] args) {
		int[] arr= {12,545,65,35,7,-14,5,145,6};
		ListaEnlazadaEx lista=new ListaEnlazadaEx(arr);
		
		System.out.println(lista);
		
//		System.out.println(lista.returnNodo());
//		
//		lista.borrarDato(lista.returnNodo());
//		
//		System.out.println(lista);
		
	}

}
