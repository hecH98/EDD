// Hector Herrera A01632115
// Diego Arredondo A0163932
// PanelHanoi.java
// 27/02/19

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelHanoi extends JPanel implements Runnable, MouseListener{
	private TorreHanoi torre1 = new TorreHanoi(100, 100);
	private TorreHanoi torre2 = new TorreHanoi(400, 100);
	private TorreHanoi torre3 = new TorreHanoi(700, 100);
	private Thread hilo;
	private int discos;
	private boolean start;

	public PanelHanoi () {
		super();
		this.setPreferredSize(new Dimension(900,600));
		this.discos=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de discos"));
		this.torre1.llenar(this.discos);

		this.hilo= new Thread(this);
		this.hilo.start();
		this.start=false;
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		torre1.pintaTorre(g, Color.GREEN.darker());
		torre2.pintaTorre(g, Color.blue.darker());
		torre3.pintaTorre(g, Color.yellow.darker());
		
		torre1.pintaDiscos(g);
		torre2.pintaDiscos(g);
		torre3.pintaDiscos(g);
		
	}
	
	public void acomoda(int discos, TorreHanoi torre1, TorreHanoi torre2, TorreHanoi torre3) throws InterruptedException {
		Thread.sleep(500);
		this.update(this.getGraphics());
		if(discos==1) {
			torre3.push(torre1.pop());
			this.update(this.getGraphics());
			System.out.println("swap");
			Thread.sleep(500);
		}
		else {
			this.update(this.getGraphics());
			System.out.println("discos: "+discos);
			acomoda(discos-1, torre1, torre3, torre2);
			torre3.push(torre1.pop());
			this.update(this.getGraphics());
			acomoda(discos-1, torre2, torre1, torre3);
		}

	}
	

	public void run() {
		
		try {
			if(this.start) {
				System.out.println("torre1: "+torre1.toString());
				System.out.println("torre2: "+torre2.toString());
				System.out.println("torre3: "+torre3.toString());
				acomoda(this.discos, this.torre1,this.torre2,this.torre3);
				System.out.println("torre1: "+torre1.toString());
				System.out.println("torre2: "+torre2.toString());
				System.out.println("torre3: "+torre3.toString());					
			}
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.start=true;
		run();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

