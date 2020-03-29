import java.util.NoSuchElementException;

public class MyHeap<E extends Comparable<E>> {
	private E[] arr;
	private int size;
	
	public MyHeap(int size) {
		this.arr= (E[]) new Comparable[size];
		this.size=0;
	}
	
	public MyHeap() {
		this(10);
	}
	
	public void heapify() {
		int index=(this.arr.length/2)-1;
		heapify(this.arr, index);
	}
	
	public void heapifyd() {
		int index = (size/2)-1;
		while(index>=0) {
			if(this.arr[getLeftChild(index)]!=null) {
				if(this.arr[index].compareTo(this.arr[getLeftChild(index)])<0) {
					swap(index,getLeftChild(index));
				}
			}
			if(this.arr[getRightChild(index)]!=null) {
				if(this.arr[index].compareTo(this.arr[getRightChild(index)])<0) {
					swap(index,getRightChild(index));
				}
			}
			index--;
		}
	}
	
	private void heapify(E[] arr, int index) {
		if(index>=0) {
			if(index >= (this.size / 2) && index <= this.size) {
				return;
			}
			if(arr[index].compareTo(arr[getLeftChild(index)])<0 && arr[getLeftChild(index)] != null) {
				swap(index,getLeftChild(index));
				heapify(arr, index*2+1);
			}
			if(arr[index].compareTo(arr[getRightChild(index)])<0 && arr[getRightChild(index)] != null){
				swap(index, getRightChild(index));
				heapify(arr, index*2+2);
			}
			heapify(arr, --index);
		}
		
		
	}
	
	public void insert(E number) throws IndexOutOfBoundsException{
		if(this.size<=this.arr.length) {
			this.arr[size]=number;
			this.size++;
		}
		else {
			throw new IndexOutOfBoundsException("The array is full");
		}
		
	}
	
	public E delete() {
		E removed=this.arr[0];
		this.arr[0]=this.arr[this.size-1];
		this.arr[this.size-1]=null;
		heapifyDown(0);
		
		return removed;
	}

	public void heapifyDown(int index) {
		int greaterChildPos;
		if (index*2+1<=this.arr.length) {
			if (this.arr[getLeftChild(index)].compareTo(this.arr[getRightChild(index)])>0) {
				greaterChildPos=getLeftChild(index);
			}
			else {
				greaterChildPos=getRightChild(index);
			}
			
			if(this.arr[greaterChildPos].compareTo(this.arr[index])>0) {
				swap(index, greaterChildPos);
			}
			heapifyDown(greaterChildPos);
		}
		
	}
	
	public int getLeftChild(int parentPos) throws IndexOutOfBoundsException{
		if((parentPos*2)+1<this.arr.length) {
			return (parentPos*2)+1;
		}
		else {
			throw new IndexOutOfBoundsException("The x");
		}
	}
	
	public int getRightChild(int parentPos) {
		return getLeftChild(parentPos)+1;
	}
	
	public int parentPos() {
		return this.arr.length/2-1;
	}
	
	public void swap(int parent, int child) {
		E tmp=this.arr[parent];
		this.arr[parent]=this.arr[child];
		this.arr[child]=tmp;
		
	}
	
	public String toString() {
		String res="";
		for (int i = 0; i < this.arr.length; i++) {
			res+=this.arr[i]+",";
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		MyHeap<Integer> heap=new MyHeap<>(11);
		heap.insert(15);
		heap.insert(60);
		heap.insert(72);
		heap.insert(70);
		heap.insert(56);
		heap.insert(32);
		heap.insert(62);
		heap.insert(92);
		heap.insert(45);
		heap.insert(30);
		heap.insert(65);
		
		System.out.println(heap);
		
		heap.heapify();
		
		System.out.println(heap);
	}
}

