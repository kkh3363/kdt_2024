package challenge.three;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseDragTest extends JFrame {
	private int x1, y1, x2, y2;
	private JLabel status;
	Color color = Color.BLACK;

	public MouseDragTest() {
		setTitle("드래그에 의한 사각형");

		JPanel p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(color);
				int x = (x1 < x2) ? x1 : x2;
				int y = (y1 < y2) ? y1 : y2;
				int width = Math.abs(x1 - x2);
				int height = Math.abs(y1 - y2);
				g.drawRect(x, y, width, height);
			}
		};
		p1.setBackground(Color.YELLOW);

		MyMouseListener listener = new MyMouseListener();
		p1.addMouseListener(listener);
		p1.addMouseMotionListener(listener);

		JPanel p2 = new JPanel();
		status = new JLabel("마우스 위치 정보");
		p2.add(status);

		add("Center", p1);
		add("South", p2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		setVisible(true);
	}

	private class MyMouseListener implements MouseListener, MouseMotionListener {
		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			status.setText("(" + x1 + "," + y1 + ")");
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			x2 = e.getX();
			y2 = e.getY();
			status.setText("(" + x1 + "," + y1 + ") , (" + x2 + "," + y2 + ")");
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			x2 = e.getX();
			y2 = e.getY();
			status.setText("(" + x1 + "," + y1 + ") , (" + x2 + "," + y2 + ")");
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	public static void main(String[] args) {
		new MouseDragTest();
	}
}
