import java.util.Iterator;

//Hector Humberto Herrera Macías A01632115
//MiListaEnlazada.java
//24/04/19

public class MiListaEnlazadaOriginal<E> implements Iterable<E>{
	LinkedList<E> lista;
	
	public MiListaEnlazadaOriginal(LinkedList<E> lista) {
		this.lista=lista;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			NodoLE<E> curr=lista.nodoInicio();
			private boolean callRemove=false;

			@Override
			public boolean hasNext() {
				return curr!=null;
			}

			@Override
			public E next() {
				callRemove=true;
				NodoLE<E> prev=curr;
				curr=curr.getNext();
				return prev.getDato();
			}
			
			public void remove() {
				if(this.callRemove) {
					NodoLE<E> prev=lista.getPrev(curr);
					lista.borrarNodo(prev);
				}
				
				this.callRemove=false;
				
			}
		};
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> lista=new LinkedList<>();
		for (int i = 0; i < 15; i++) {
			lista.insertarInicio(i);
		}
		System.out.println(lista);
		
		MiListaEnlazadaOriginal<Integer> iterador=new MiListaEnlazadaOriginal<>(lista);
		
		Iterator<Integer> it=iterador.iterator();
		int num;
		while (it.hasNext()) {
			num=it.next();
			if(num==4) {
				it.remove();
			}
			System.out.print(num+",");
		}
		
		System.out.println();
		
		
		for (int valor:iterador) {
			System.out.print(valor+",");
		}
	}
	
}
