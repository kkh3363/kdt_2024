package sec02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StarDemo extends JFrame {
	StarDemo() {
		setTitle("타원, 호, 다각형 그리기");

		add(new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.setColor(Color.RED);
				int x[] = { 82, 92, 112, 92, 100, 80, 55, 68, 49, 72, 82 };
				int y[] = { 8, 32, 38, 50, 75, 55, 72, 45, 28, 30, 8 };

				g.fillPolygon(x, y, x.length);

				g.fillArc(150, 10, 50, 50, 90, 90);

				g.setColor(Color.BLUE);
				g.fillArc(160, 10, 50, 50, 0, 90);

				g.setColor(Color.YELLOW);
				g.fillArc(150, 20, 50, 50, 180, 90);

				g.setColor(Color.GREEN);
				g.fillArc(160, 20, 50, 50, 270, 90);

				g.setColor(Color.BLACK);
				g.drawOval(60, 100, 50, 50);

				g.drawOval(130, 100, 100, 50);
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 210);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StarDemo();
	}
}