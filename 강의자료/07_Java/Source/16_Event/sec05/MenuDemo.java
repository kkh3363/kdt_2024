package sec05;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuDemo extends JFrame implements ActionListener {
	MenuDemo() {
		setTitle("메뉴 구성하기");
		makeMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 170);
		setVisible(true);
	}

	void makeMenu() {
		JMenuItem item;
		KeyStroke key;

		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu("파일");
		m1.setMnemonic(KeyEvent.VK_F);
		JMenu m2 = new JMenu("색상");
		m2.setMnemonic(KeyEvent.VK_C);

		item = new JMenuItem("새 파일", KeyEvent.VK_N);
		item.addActionListener(this);
		m1.add(item);
		item = new JMenuItem("파일 열기", KeyEvent.VK_O);
		item.addActionListener(this);
		m1.add(item);
		m1.add(new JMenuItem("파일 저장"));
		m1.addSeparator();
		m1.add(new JMenuItem("종료"));

		item = new JMenuItem("파란색");
		key = KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK);
		item.setAccelerator(key);
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("빨간색");
		key = KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK);
		item.setAccelerator(key);
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("노란색");
		key = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK);
		item.setAccelerator(key);
		item.addActionListener(this);
		m2.add(item);
		mb.add(m1);
		mb.add(m2);
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		new MenuDemo();
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) (e.getSource());

		switch (mi.getText()) {
		case "새 파일":
			System.out.println("새 파일");
			break;
		case "파일 열기":
			System.out.println("파일 열기");
			break;
		case "파란색":
			this.getContentPane().setBackground(Color.BLUE);
			break;
		case "빨간색":
			this.getContentPane().setBackground(Color.RED);
			break;
		case "노란색":
			this.getContentPane().setBackground(Color.YELLOW);
		}
	}
}