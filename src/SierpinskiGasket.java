import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskiGasket extends JFrame{
	private Point a,
				  b,
				  c;
	
	private int nivel;
	
	public SierpinskiGasket() {
		super("Fractal SierpinskiGasket");
		this.setSize(1200,850);
		//this.setSize(640,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.a=new Point(600, 50);
		this.b=new Point(20,830);
		this.c=new Point(1180, 830);
//		this.a=new Point(320, 50);
//		this.b=new Point(20,380);
//		this.c=new Point(620, 380);
		this.nivel=Integer.parseInt(JOptionPane.showInputDialog("Escribe el nivel"));
		this.setVisible(true);
	}
	
	public Point puntoMedio(Point a, Point b) {
		int xM=(a.x+b.x)/2,
			yM=(a.y+b.y)/2;
		
		return new Point(xM, yM);
	}
	
	public void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	public void pintaTriangulos(Graphics g, int nivel, Point a, Point b, Point c) {
		if(nivel==0) {
			this.pintaLineas(g, a, b);
			this.pintaLineas(g, b, c);
			this.pintaLineas(g, c, a);
		}
		else {
			Point pmAB=puntoMedio(a, b),
				  pmBC=puntoMedio(b, c),
				  pmCA=puntoMedio(c, a);
			this.pintaTriangulos(g, nivel-1,a, pmAB,pmCA);
			this.pintaTriangulos(g, nivel-1,pmAB, b,pmBC);
			this.pintaTriangulos(g, nivel-1,pmCA, pmBC,c);
		}
		
	}
	
	public void paint(Graphics g) {
		this.pintaTriangulos(g, nivel, a, b, c);
	}
	
	public static void main(String[] args) {
		SierpinskiGasket sg=new SierpinskiGasket();
				
	}
}
