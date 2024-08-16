package sec02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LineDemo extends JFrame {
	int[] x = { 155, 205, 255 };
	int[] y = { 5, 50, 5 };

	LineDemo() {
		setTitle("직선 그리기");

		class MyPanel extends JPanel {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.setColor(Color.RED);
				g.drawLine(50, 10, 150, 50);
				g.setColor(Color.BLUE);
				g.drawPolyline(x, y, 3);
			}
		}

		add(new MyPanel());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LineDemo();
	}
}