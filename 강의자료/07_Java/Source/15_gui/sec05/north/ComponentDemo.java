package sec05.north;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComponentDemo extends JFrame {
	ComponentDemo() {
		setTitle("원 넓이 구하기");

		setLayout(new BorderLayout(10, 10));
		showNorth();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 105);
		setVisible(true);
	}

	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(2, 0));

		JLabel l1 = new JLabel("원의 반지름");
		JLabel l2 = new JLabel("원의 넓이");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		t2.setEnabled(false);

		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		panel.add(p1);
		panel.add(p2);

		add(panel, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new ComponentDemo();
	}
}