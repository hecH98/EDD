import java.util.NoSuchElementException;

public class MyQueueOriginal <E>{
	private LinkedList<E> lista;
	
	public MyQueueOriginal() {
		this.lista=new LinkedList<>();
	}
	
	public void enqueue(E dato) {
		lista.insertarFin(dato);
	}
	
	public E dequeue() {
		try {
			return this.lista.borrarInicio();
		} 
		catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException("No se puede hacer un dequeue en una cola vacia");
		}
		
	}
	
	public E next() {
		try {
			return this.lista.inicio();
		} 
		catch(IndexOutOfBoundsException e) {
			throw new NoSuchElementException("No se puede ver el siguiente elemento en una cola vacia");
		}
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
		MyQueueOriginal<String> cola=new MyQueueOriginal<>();
		cola.enqueue("Hola ");
		cola.enqueue("que ");
		cola.enqueue("tal ");
		cola.enqueue("veamos ");
		cola.enqueue("si ");
		cola.enqueue("funciona ");
		cola.enqueue("esto ");
		cola.enqueue("no?");
		
		System.out.println(cola);
		
		System.out.println(cola.next());
		
		while(!cola.isEmpty()) {
			System.out.print(cola.dequeue());
		}
	}
}
