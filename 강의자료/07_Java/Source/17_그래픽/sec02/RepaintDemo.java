package sec02;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RepaintDemo extends JFrame {
	Random r = new Random();
	List<Rectangle> list = new ArrayList<>();
	MouseEvent e;

	public RepaintDemo() {
		setTitle("클릭할 때마다 임의의 사각형 그리기");
		add(new MousePanel());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
	}

	class MousePanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (RepaintDemo.this.e != null) {
						if (RepaintDemo.this.e.equals(e))
							return;
					}

					int w = r.nextInt(20) + 5;
					int x = r.nextInt(350);
					int y = r.nextInt(150);
					list.add(new Rectangle(x, y, w, w));

					repaint();

					RepaintDemo.this.e = e;
				}
			});

			for (int i = 0; i < list.size(); i++) {
				Rectangle r = list.get(i);
				int x = (int) r.getX();
				int y = (int) r.getY();
				int l = (int) r.getWidth();
				g.drawRect(x, y, l, l);
			}
		}
	}

	public static void main(String[] argv) {
		new RepaintDemo();
	}
}