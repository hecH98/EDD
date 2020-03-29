package ExamenParcial1;

public class NodoLEEx {
	NodoLEEx next;
	int dato;
	
	public NodoLEEx(int dato) {
		this.next=null;
		this.dato=dato;
	}
	
	public NodoLEEx(int dato, NodoLEEx nodo) {
		this.next=nodo;
		this.dato=dato;
	}

	public NodoLEEx getNext() {
		return next;
	}

	public void setNext(NodoLEEx next) {
		this.next = next;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
	
	public String toString() {
		return this.dato+",";
	}

}
