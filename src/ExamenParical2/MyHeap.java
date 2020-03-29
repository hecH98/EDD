package ExamenParical2;

public class MyHeap <E extends Comparable<E>>{
	private  E[] datos;
	private int size;
	
	public MyHeap(E[] datos, int size) {
		this.datos=datos;
		this.size=size;
	}
	
	public E delete() {
		E tmp=this.datos[0];
		this.datos[0]=this.datos[this.size-1];
		this.datos[this.size-1]=null;
		this.size--;
		heapifyDown(0);
		return tmp;
	}
	
	private void heapifyDown(int index) {
		int greaterChild=index;
		
		if(greaterChild>=this.size) {
			return;
		}
		
		if(greaterChild*2+2>this.size-2) {
			if(this.datos[getLeftChild(index)].compareTo(this.datos[getRightChild(index)])<0) {
				greaterChild=getRightChild(index);
			}
			else {
				greaterChild=getLeftChild(index);
			}
		}
		
		if(this.datos[index].compareTo(this.datos[getLeftChild(index)])<0) {
			swap(index, greaterChild);
		}
		
		if (this.datos[index].compareTo(this.datos[getLeftChild(index)])<0) {
			swap(index, greaterChild);
		}
		
		heapifyDown(greaterChild);
		
	}
	
	private int getLeftChild(int index) {
		return index*2+1;
	}
	
	private int getRightChild(int index) {
		return getLeftChild(index)+1;
	}
	
	private void swap(int index, int child) {
		E tmp=this.datos[index];
		this.datos[index]=this.datos[child];
		this.datos[child]=tmp;
	}
	
	public String toString() {
		String res="";
		for (int i = 0; i < this.datos.length; i++) {
			res+=this.datos[i]+",";
		}
		return res;
	}
	
	public static void main(String[] args) {
		Integer[] arr=new Integer[50];
		int length=arr.length;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=length;
			length--;
		}
		
		MyHeap<Integer> heap=new MyHeap<>(arr, 50);
		
		System.out.println(heap);
		
		heap.delete();
		
		System.out.println(heap);
		
		
	}

}
