// Hector Herrera A01632115
// Diego Arredondo A0163932
// MyStack.java
// 27/02/19

import java.util.NoSuchElementException;

public class MyStack <E>{
	LinkedList<E> lista;
	
	public MyStack() {
		this.lista=new LinkedList<>();
	}
	
	public void push(E dato) { // Inserta el elemento
		this.lista.insertarInicio(dato);
	}
	
	public E pop() throws NoSuchElementException{ // Elimina el elemento
		try {
			return this.lista.borrarInicio();
		}
		catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException("No se puede borrar el elemento de una lista vacia");
		}
	}
	
	public E top() throws NoSuchElementException{ // Visualiza en inicio
		try {
			return this.lista.inicio();
		}
		catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException("No se obtener el elemento de una lista vacia");
		}
	}
	
	public E elementoEn(int pos) {
		return this.lista.getEn(pos);
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void flush() {
		this.lista.flush();
	}
	
	public String toString() {
		return this.lista.toString();
	}
	
	public static void main(String[] args) {
		MyStack<Integer> stack=new MyStack<>();
		
		for (int i = 0; i < 100; i++) {
			stack.push(i);
		}
		
		System.out.println(stack);
		
		System.out.println(stack.top());
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
	
	
}
