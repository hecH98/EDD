// Hector Herrera A01632115
// Diego Arredondo A0163932
// VentanaHanoi.java
// 27/02/19

import javax.swing.JFrame;

public class VentanaHanoi extends JFrame{
	PanelHanoi panel; 
	public VentanaHanoi() {
		super();
		this.setTitle("Torres Hanoi");
		this.panel = new PanelHanoi();
		this.add(panel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		VentanaHanoi ventana = new VentanaHanoi();
	}

}
