// Hector Herrera A01632115
// MyHashTable.java
// 27/03/19

import java.util.NoSuchElementException;

public class MyHashTable <K,V>{
	private LinkedList<MyNodoHash<K,V>>[] tabla;
	private int size;
	private static final double LOAD_FACTOR=0.75;
	
	public MyHashTable() {
		this.tabla=(LinkedList<MyNodoHash<K,V>>[]) new LinkedList[11];
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i]=new LinkedList<>();
		}
		this.size=0;
	}
	
	public void put(K llave, V valor) { 
		// Genera el indice y guarda en la tabla
		// si la llave ya existe, se sobreescribe
		if((double)this.size/(this.tabla.length) > MyHashTable.LOAD_FACTOR) {
			rehashing();
		}
		int index = llave.hashCode()%this.tabla.length;
		this.tabla[index].insertarFin(new MyNodoHash<>(llave, valor));
		this.size++;
	}
	
	public void rehashing() {
		// Genera una nueva tabla de tamaño doble mas 1 y guarda los elementos de la tabla anterior en la nueva tabla
		// La tabla grande será la nueva tabla. MUY IMPORTANTE reacomodar los elementos en la nueva tabla
		LinkedList<MyNodoHash<K,V>>[] tmp=this.tabla;
		this.tabla=(LinkedList<MyNodoHash<K,V>>[]) new LinkedList[(this.tabla.length*2)+1];
		for (int i = 0; i < tmp.length; i++) {
			while (!tmp[i].estaVacia()) {
				MyNodoHash<K,V> nodoTmp=tmp[i].borrarInicio();
				put(nodoTmp.getLlave(), nodoTmp.getValor());
			}
		}
	}
	
	public V get(K llave) throws NoSuchElementException{
		int index=llave.hashCode()%this.tabla.length;
		V valor=null;
		for (int i = 0; i < tabla.length; i++) {
			MyNodoHash<K,V> tmp=this.tabla[index].getEn(i);
			if(tmp.getLlave().equals(llave)) {
				valor=tmp.getValor();
			}
		}
		return valor;
	}
	
	public V delete(K llave) {
		// calcular el indice donde deberia estar esta llave
		// buscar en la lista si esta un nodo con la llave buscada, si esta borrar el nodo con la llave 
		int index=llave.hashCode()%this.tabla.length;
		V valor=null;
		for (int i = 0; i < tabla.length; i++) {
			MyNodoHash<K,V> tmp=this.tabla[index].getEn(i);
			if(tmp.getLlave().equals(llave)) {
				valor=tmp.getValor();
				this.tabla[index].borrarEn(i);
			}
		}
		return valor;
	}
	
	public boolean containsKey(K llave) {
		//regresa true si la tabla tiene la llave que paso como parametro
		int k= llave.hashCode()%this.tabla.length;
		LinkedList<MyNodoHash<K,V>> lista=this.tabla[k];
		for (int i = 0; i < tabla.length; i++) {
			MyNodoHash<K,V> tmp=lista.getEn(i);
			if(tmp.getLlave().equals(llave)) {
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		// borra toda la hash table
		this.tabla=(LinkedList<MyNodoHash<K,V>>[]) new LinkedList[11];
		for (int i = 0; i < tabla.length; i++) {
			this.tabla[i]=new LinkedList<>();
		}
		this.size=0;
		System.gc();
	}

	public static void main(String[] args) {
		
	}
}

class MyNodoHash<K,V> {
	private K llave;
	private V valor;
	public MyNodoHash(K llave, V valor) {
		super();
		this.llave = llave;
		this.valor = valor;
	}
	public K getLlave() {
		return llave;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	
}


