package sec04;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame {
	BorderLayoutDemo() {
		setTitle("º¸´õ ·¹ÀÌ¾Æ¿ô!");
		setLayout(new BorderLayout());

		add("East", new JButton("µ¿"));
		add("West", new JButton("¼­"));
		add("South", new JButton("³²"));
		add(new JButton("ºÏ"), BorderLayout.NORTH);
		add(new JButton("Áß¾Ó"), BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 110);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutDemo();
	}
}