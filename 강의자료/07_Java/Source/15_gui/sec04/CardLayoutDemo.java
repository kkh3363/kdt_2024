package sec04;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CardLayoutDemo extends JFrame {
	CardLayout layout;

	public void rotate() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
			layout.next(this.getContentPane());
		}
	}

	CardLayoutDemo() {
		setTitle("카드 레이이웃!");
		layout = new CardLayout();
		setLayout(layout);

		add(new JButton("버튼 0"));
		add(new JButton("버튼 1"));
		add(new JButton("버튼 2"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 110);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CardLayoutDemo().rotate();
	}
}