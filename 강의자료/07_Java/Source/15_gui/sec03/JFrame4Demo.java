package sec03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrame4Demo extends JFrame {
	JFrame4Demo() {
		setTitle("¾È³ç, ½ºÀ®!");

		JPanel p = new JPanel();
		JLabel l = new JLabel("¾È³ç, ½ºÀ®!");
		JButton b = new JButton("¹öÆ°");
		p.add(l);
		p.add(b);
		add(p);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		// pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new JFrame4Demo();
	}
}