import java.util.NoSuchElementException;

public class MyABB<E extends Comparable<E>> {
	private NodoABB<E> root;
	private int size;
	
	public MyABB() {
		this.root=null;
		this.size=0;
	}
	
	public void insert(E dato) {
		NodoABB<E> nvo=new NodoABB<>(dato);
		NodoABB<E> curr=this.root,
				   prev=null;
		
		if(this.root!=null) {
			while(curr!=null) {
				prev=curr;
				curr= curr.dato.compareTo(dato)<0 ? curr.right:curr.left;
			}
			// prev apunta al nodo que será el padre de curr
			
			if(dato.compareTo(prev.dato)<0) {
				prev.left=nvo;
			}
			else {
				prev.right=nvo;
			}
		}
		else {
			this.root=nvo;
		}
		size++;
	}
	
	public E buscar(E dato) throws NoSuchElementException{
		NodoABB<E> curr=this.root;
		while(curr!=null) {
			if(curr.dato.equals(dato)) {
				return curr.dato;
			}
			else if(dato.compareTo(curr.dato)<0) {
				curr=curr.left;
			}	
			else {
				curr=curr.right;
			}
		}
		throw new NoSuchElementException("El elemento "+dato+" no esta en el arbol");
	}
	
	public E borrar(E dato) {
		NodoABB<E> curr=this.root,
				   prev=this.root;
		
		boolean lado;  // Si lado es true, se encuentra a la izquierda, sino a la derecha
		
		while(!curr.dato.equals(dato)) { // Aqui curr esta en el nodo a borrar y prev en el padre del nodo a borrar
			prev=curr;
			curr = curr.dato.compareTo(dato)>0 ? curr.left:curr.right;
		}
		
		// Saber si el nodo esta a la izquierda o derecha del padre
		lado = prev.left==curr;
		
		
		// Caso en el que solo es una hoja
		if(curr.left==null && curr.right==null) {
			if(lado) {
				prev.left=null;
			}
			else {
				prev.right=null;
			}
		}
		else if(curr.left==null) { // Curr solo tiene hijo derecho
			if(lado) {
				prev.left=curr.right;
			}
			else {
				prev.right=curr.right;
			}
		}
		else if(curr.right==null) { // Curr solo tiene hijo izquierdo
			if(lado) {
				prev.left=curr.left;
			}
			else {
				prev.right=curr.left;
			}
		}
		else { // Caso con dos hijos
			NodoABB<E> pred=predecesor(curr);
			
			curr.dato=pred.dato;

			if(curr.left==pred) {
				curr.left=null;
			}
			else {
				curr=curr.left;
				while(curr.right!=pred) {
					curr=curr.right;
				}
				curr.right=null;
			}
			
		}
		size--;
		return dato;
	}
	
	private NodoABB<E> predecesor(NodoABB<E> curr){
		curr=curr.left;
		while(curr.right!=null) {
			curr=curr.right;
		}
		return curr;
	}
	
	public void preOrder() {
		preOrder(this.root);
		System.out.println();
	}
	
	private void preOrder(NodoABB<E> curr) {
		if(curr!=null) {
			System.out.print(curr.dato+",");
			preOrder(curr.left);
			preOrder(curr.right);
		}
	}
	
	public void inOrder() {
		inOrder(this.root);
		System.out.println();
	}
	
	private void inOrder(NodoABB<E> curr) {
		if(curr!=null) {
			inOrder(curr.left);
			System.out.print(curr+",");
			inOrder(curr.right);
		}
	}
	
	public void postOrder() {
		postOrder(this.root);
		System.out.println();
	}
	
	private void postOrder(NodoABB<E> curr) {
		if(curr!=null) {
			postOrder(curr.left);
			postOrder(curr.right);
			System.out.print(curr+",");
		}
	}
	
	public void amplitudUL() { // Arriba-abajo izquierda-derecha
		MyQueueOriginal<NodoABB<E>> queue=new MyQueueOriginal<>();
		NodoABB<E> curr=this.root;
		
		queue.enqueue(curr);
		while(!queue.isEmpty()){
			if(curr.left!=null) {
				queue.enqueue(curr.left);
			}
			if(curr.right!=null) {
				queue.enqueue(curr.right);
			}
			System.out.print(queue.dequeue()+",");
			if(!queue.isEmpty()) {
				curr=queue.next();
			}
		}
		System.out.println();
	}
	
	public void amplitudUR() { // Arriba-abajo derecha-izquierda
		MyQueueOriginal<NodoABB<E>> queue=new MyQueueOriginal<>();
		NodoABB<E> curr=this.root;
		
		queue.enqueue(curr);
		while(!queue.isEmpty()){
			if(curr.right!=null) {
				queue.enqueue(curr.right);
			}
			if(curr.left!=null) {
				queue.enqueue(curr.left);
			}
			System.out.print(queue.dequeue()+",");
			if(!queue.isEmpty()) {
				curr=queue.next();
			}
		}
		System.out.println();
	}
	
	public void amplitudDL() { // Abajo-arriba izquierda-derecha
		MyStack<NodoABB<E>> stack=new MyStack<>();
		MyQueueOriginal<NodoABB<E>> queue=new MyQueueOriginal<>();
		NodoABB<E> curr=this.root;
		
		queue.enqueue(curr);
		while(!queue.isEmpty()){
			if(curr.right!=null) {
				queue.enqueue(curr.right);
			}
			if(curr.left!=null) {
				queue.enqueue(curr.left);
			}
			stack.push(queue.dequeue());
			if(!queue.isEmpty()) {
				curr=queue.next();
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+",");
		}
		System.out.println();
	}
	
	public void amplitudDR() { // Abajo-arriba derecha-izquierda
		MyStack<NodoABB<E>> stack=new MyStack<>();
		MyQueueOriginal<NodoABB<E>> queue=new MyQueueOriginal<>();
		NodoABB<E> curr=this.root;
		
		queue.enqueue(curr);
		while(!queue.isEmpty()){
			if(curr.left!=null) {
				queue.enqueue(curr.left);
			}
			if(curr.right!=null) {
				queue.enqueue(curr.right);
			}
			stack.push(queue.dequeue());
			if(!queue.isEmpty()) {
				curr=queue.next();
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyABB<Integer> arbol=new MyABB<>();
		arbol.insert(21);
		arbol.insert(13);
		arbol.insert(33);
		arbol.insert(10);
		arbol.insert(18);
		arbol.insert(25);
		arbol.insert(40);
		arbol.insert(29);
		arbol.insert(27);
		arbol.insert(30);
		
		System.out.println("Pre Order");
		arbol.preOrder();
		System.out.println();
		
		System.out.println("borrar dato "+arbol.borrar(10));
		System.out.println();
		
		System.out.println("Pre Order");
		arbol.preOrder();
		System.out.println();
		
		System.out.println("In Order");
		arbol.inOrder();
		System.out.println();
		
		System.out.println("Post Order");
		arbol.postOrder();
		System.out.println();
		
		System.out.println("Amplitud Arriba-abajo izquierda-derecha");
		arbol.amplitudUL();
		System.out.println();
		
		System.out.println("Amplitud Arriba-abajo derecha-izquierda");
		arbol.amplitudUR();
		System.out.println();
		
		System.out.println("Amplitud Abajo-arriba izquierda-derecha");
		arbol.amplitudDL();
		System.out.println();
		
		System.out.println("Amplitud Abajo-arriba derecha-izquierda");
		arbol.amplitudDR();
		System.out.println();
	}

}

class NodoABB<E>{
	E dato;
	NodoABB<E> right, 
			left;
	
	public NodoABB(E dato, NodoABB<E> right, NodoABB<E> left) {
		super();
		this.dato = dato;
		this.right = right;
		this.left = left;
	}

	public NodoABB(E dato) {
		this(dato, null,null);
	}
	
	public String toString() {
		return this.dato.toString();
	}
}

