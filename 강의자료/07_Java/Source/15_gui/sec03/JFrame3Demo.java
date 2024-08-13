package sec03;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrame3Demo extends JFrame {
	JFrame3Demo() {
		setTitle("¾È³ç, ½ºÀ®!");

		JButton b = new JButton("¹öÆ°");
		add(b);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JFrame3Demo();
	}
}