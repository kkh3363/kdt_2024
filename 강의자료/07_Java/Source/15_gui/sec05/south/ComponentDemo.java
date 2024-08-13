package sec05.south;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComponentDemo extends JFrame {
	ComponentDemo() {
		setTitle("원 넓이 구하기");

		setLayout(new BorderLayout(10, 10));
		showSouth();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 105);
		setVisible(true);
	}

	void showSouth() {
		String[] color = { "red", "blue" };

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JButton cal = new JButton("계산");
		JComboBox<String> cb = new JComboBox<>(color);
		JButton reset = new JButton("리셋");

		panel.add(cal);
		panel.add(cb);
		panel.add(reset);

		add(panel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new ComponentDemo();
	}
}