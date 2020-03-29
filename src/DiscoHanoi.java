// Hector Herrera A01632115
// Diego Arredondo A0163932
// DiscoHanoi.java
// 27/02/19

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiscoHanoi {
	private int diametro;
	public DiscoHanoi(int diametro) {
		this.diametro=diametro;
	}
	public void pintaDisco(Graphics g, int x, int y, Color color) {
		g.setColor(color);
		g.fillRect(x, y, diametro, 20);
		g.setColor(Color.black);
		g.drawRect(x, y, diametro, 20);
	}
	
	public String toString() {
		return "diametro: "+this.diametro;
	}

}
