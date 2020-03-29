import java.util.Iterator;

public class EjemploIterador implements Iterable<Integer>{
	private Integer[] valores;
	private int size;
	
	public EjemploIterador(Integer[] valores) {
		this.valores=valores;
		size=valores.length;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int pos=0;
			private boolean callRemove=false;
			
			@Override
			public boolean hasNext() {
				return pos<size;
			}

			@Override
			public Integer next() {
				this.callRemove=true;
				return valores[pos++];
			}
			
			public void remove() {
				if (this.callRemove) {
					for (int i = pos; i < size; i++) {
						valores[i-1]=valores[i];
					}
					valores[size-1]=null;
					size--;
					pos--;
				}
				this.callRemove=false;
			}
			
		};
	}
	
	
	public static void main(String[] args) {
		Integer[] numeros= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		
		EjemploIterador ei=new EjemploIterador(numeros);
		
		Iterator<Integer> it=ei.iterator();
		int num;
		while (it.hasNext()) {
			num=it.next();
			if(num==7) {
				it.remove();
			}
			System.out.println(num);
		}
		
		System.out.println();
		
		for (int valor:ei) {
			System.out.println(valor);
		}
	}

}
