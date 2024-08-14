package sec03.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EventDemo extends JFrame {
	JTextField t1, t2;
	JTextArea area;
	JButton cal, reset;
	JComboBox cb;

	EventDemo() {
		setTitle("원 넓이 구하기");

		setLayout(new BorderLayout(10, 10));
		showNorth();
		showCenter();
		showSouth();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 220);
		setVisible(true);
	}

	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(2, 0));

		JLabel l1 = new JLabel("원의 반지름");
		JLabel l2 = new JLabel("원의 넓이");

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t2.setEnabled(false);

		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		panel.add(p1);
		panel.add(p2);

		add(panel, BorderLayout.NORTH);
	}

	void showCenter() {
		JPanel panel = new JPanel();

		area = new JTextArea(30, 20);
		area.setText("이 영역에 원의 넓이를\n계산하는 과정이 나타납니다.");
		area.setEditable(false);
		area.setForeground(Color.RED);

		panel.add(area);

		add(panel, BorderLayout.CENTER);
	}

	void showSouth() {
		String[] color = { "red", "blue" };

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

		cal = new JButton("계산");
		cb = new JComboBox<String>(color);
		reset = new JButton("리셋");

		panel.add(cal);
		panel.add(cb);
		panel.add(reset);
		add(panel, BorderLayout.SOUTH);

		ActionListener listener1 = e -> {
			if (e.getSource() == cal) {
				if (t1.getText().isEmpty())
					area.setText("반지름을 입력하세요!!!");
				else {
					String s = t1.getText();
					double radius = Double.parseDouble(s);
					double result = radius * radius * 3.14;
					t2.setText("" + result);
					area.setText(radius + " * " + radius + " * 3.14 = " + result);
				}
			} else {
				t1.setText("");
				t2.setText("");
				area.setText("");
			}
		};

		cal.addActionListener(listener1);
		reset.addActionListener(listener1);
	}

	public static void main(String[] args) {
		new EventDemo();
	}
}