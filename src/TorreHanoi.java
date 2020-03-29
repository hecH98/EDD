// Hector Herrera A01632115
// Diego Arredondo A0163932
// TorreHanoi.java
// 27/02/19

import java.awt.Color;
import java.awt.Graphics;

public class TorreHanoi{
	private int x,y;
	private int tamanoActual;
	private MyStack<DiscoHanoi> stack;
	
	public TorreHanoi(int x, int y) {
		super();
		this.x=x;
		this.y=y;
		this.tamanoActual=0;
		this.stack=new MyStack<>();
	}
	public void push(DiscoHanoi disco) {
		this.stack.push(disco);
		this.tamanoActual++;
	}
	public DiscoHanoi pop() {
		this.tamanoActual--;
		return this.stack.pop();
	}
	public void pintaTorre(Graphics g,  Color c) {
		g.setColor(c);
		g.fillRect(this.x-80, this.y+300, 200, 40);
		g.fillRect(this.x,this.y,40,300);
		
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, 40, 300);
		g.drawRect(this.x-80, this.y+300, 200, 40);
		
	}
	
	public String toString() {
		return stack.toString();
	}
	
	public void llenar(int n) {
		this.tamanoActual=n;
		int diametro = 200;
		
		for(int i=0;i<n;i++) {
//			System.out.println("Llenando " + i);
			this.stack.push(new DiscoHanoi(diametro));
			diametro=diametro-15;
		}
//		System.out.println(this.stack);
	}
	public void pintaDiscos(Graphics g) {
		int contador=0;
		Color col=new Color(117,132,218);
		if(this.tamanoActual!=0) {
			for (int i =tamanoActual-1; i > -1; i--) {
				this.stack.elementoEn(i).pintaDisco(g,x-80,y+280,col);  // para elementoEn modificamos la clase MyStack
				y-=20;
				x+=7;
				if(contador%2==0) {
					col=new Color(110,30,168);
				}
				else {
					col=new Color(117,132,218);
				}
				contador++;
			}
		}
		this.x-= contador*7;
		this.y+= contador*20;
		
	}
}


