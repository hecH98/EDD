package Repaso;

import java.util.NoSuchElementException;

public class LinkedList<E> {
	
	Nodo<E> inicio,
			fin;
	
	int size;
	
	public LinkedList(){
		this.inicio=this.fin=null;
		this.size=0;
	}

	public Nodo<E> getInicio() {
		return inicio;
	}

	public Nodo<E> getFin() {
		return fin;
	}

	public int getSize() {
		return size;
	}
	
	public void insertarInicio(E dato) {
		Nodo<E> tmp=new Nodo<>(dato, this.inicio);
		this.inicio=tmp;
		if(this.size==0) {
			this.fin=tmp;
		}
		size++;
	}
	
	public void insertarFin(E dato) {
		if (size==0) {
			insertarInicio(dato);
		}
		else {
			Nodo<E> tmp=new Nodo<>(dato);
			this.fin.next=tmp;
			this.fin=tmp;
		}
		size++;
	}
	
	public void insertarEn(E dato, int pos) throws IndexOutOfBoundsException{
		if(pos<0 || pos>size) {
			throw new IndexOutOfBoundsException("nel");
		}
		else if(pos==0) {
			insertarInicio(dato);
		}
		else if(pos==size) {
			insertarFin(dato);
		}
		else {
			Nodo<E> tmp=new Nodo<>(dato);
			
			Nodo<E> curr=this.inicio;
			
			for (int i = 0; i < pos-1; i++) {
				curr=curr.next;
			}
			tmp.setNext(curr.next);
			curr.next=tmp;
		}
		size++;
	}
	
	public E borrarInicio() throws NoSuchElementException{
		if(size==0) {
			throw new NoSuchElementException("Nel inicio");
		}
		else {
			E dato=this.inicio.getDato();
			this.inicio=inicio.next;
			size--;
			return dato;
		}
	}
	
	public E borrarFin(){
		if(size<=1) {
			return borrarInicio();
		}
		else {
			E dato=this.fin.getDato();
			this.inicio=inicio.next;
			
			Nodo<E> curr=this.inicio;
			for (int i = 0; i < size-2; i++) {
				curr=curr.next;
			}
			
			curr.next=null;
			this.fin=curr;
			
			size--;
			
			return dato;
		}
	}
	
	public E borrarEn(int pos) throws NoSuchElementException{
		if(pos<0 || pos>size) {
			throw new NoSuchElementException("nel borrar en");
		}
		else if(pos==0){
			return borrarInicio();
		}
		else if(pos==size-1) {
			return borrarFin();
		}
		else {
			Nodo<E> curr=this.inicio;
			for (int i = 0; i < pos-1; i++) {
				curr=curr.next;
			}
			
			E dato=curr.next.getDato();
			curr.next=curr.next.next;
			
			size--;
			
			return dato;
		}
	}
	
	public E obtenerDato(int pos) throws NoSuchElementException{
		if(pos<0 || pos>size) {
			throw new NoSuchElementException("nel borrar en");
		}
		else if(pos==0){
			return this.inicio.getDato();
		}
		else if(pos==size-1) {
			return this.fin.getDato();
		}
		else{
			Nodo<E> curr=this.inicio;
			for (int i = 0; i < pos; i++) {
				curr=curr.next;
			}
			return curr.getDato();
		}	
	}
	
	public void setAt(E dato, int pos) {
		if(pos<0 || pos>size) {
			throw new NoSuchElementException("nel borrar en");
		}
		else if(pos==0){
			this.inicio.setDato(dato);
		}
		else if(pos==size-1) {
			this.fin.setDato(dato);
		}
		else{
			Nodo<E> curr=this.inicio;
			for (int i = 0; i < pos; i++) {
				curr=curr.next;
			}
			curr.setDato(dato);
		}	
	}
	
	
	
	public static void main(String[] args) {
		LinkedList<Integer> lista1=new LinkedList<>();
		for (int i = 0; i < 9; i++) {
			lista1.insertarInicio(i);
		}
		System.out.println(lista1);
		
		lista1.insertarFin(2);
		
		System.out.println(lista1);
		
		lista1.insertarEn(23, 1);
		
		System.out.println(lista1);
		
		lista1.borrarInicio();
		
		System.out.println(lista1);
		
		lista1.borrarFin();
		
		System.out.println(lista1);
	}
	
}

class Nodo<E>{
	Nodo<E> next;
	E dato;
	
	public Nodo(E dato) {
		this(dato, null);
	}
	
	public Nodo(E dato, Nodo<E> next) {
		this.next=next;
		this.dato=dato;
	}

	public Nodo<E> getNext() {
		return next;
	}

	public void setNext(Nodo<E> next) {
		this.next = next;
	}

	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}
	
}
