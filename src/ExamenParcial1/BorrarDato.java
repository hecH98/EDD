package ExamenParcial1;

public class BorrarDato {
	
	public void borrarDato(NodoLEEx nodo) {
		nodo.setDato(nodo.getNext().getDato());
		nodo.setNext(nodo.getNext().getNext());
	}

}
