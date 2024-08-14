package sec05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorDemo extends JFrame {
	JTextField tfResult;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JButton bAdd, bSub,bMul,bDiv,bResult, bce;
	
	String value_1;
	String value_2;
	String opCode;
	
	public CalculatorDemo() {
		setTitle("나만의 계산기");
		setLayout(new BorderLayout(10, 10));
		showNorth();
		showCenter();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 220);
		setVisible(true);
	}
	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel panel = new JPanel(new GridLayout(1, 0));
		tfResult = new JTextField(10);
		tfResult.setHorizontalAlignment(SwingConstants.RIGHT);


		p1.add(tfResult);
		panel.add(p1);

		add(tfResult, BorderLayout.NORTH);
		value_1 = "";
		value_2 = "";
		opCode = "";
	}

	void showCenter() {
		JPanel panel = new JPanel(new GridLayout(0, 4));
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bAdd= new JButton("+"); 
		bSub= new JButton("-");
		bMul= new JButton("*");
		bDiv = new JButton("/");
		bResult= new JButton("=");
		bce= new JButton("CE");
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b0);
		panel.add(bAdd);
		panel.add(bSub);
		panel.add(bMul);
		panel.add(bDiv);
		panel.add(bResult);
		panel.add(bce);

		add(panel, BorderLayout.CENTER);
		ActionListener listener1 = e->{
			String strText = tfResult.getText();
			if (e.getSource() == b0) {
				if ( strText.length() > 0)
					tfResult.setText(strText+ "0");
			}
			else if ( e.getSource() == b1)
				tfResult.setText(strText+ "1");
			else if ( e.getSource() == b2)
				tfResult.setText(strText+ "2");
			else if ( e.getSource() == b3)
				tfResult.setText(strText+ "3");
			else if ( e.getSource() == b4)
				tfResult.setText(strText+ "4");
			else if ( e.getSource() == b5)
				tfResult.setText(strText+ "5");
			else if ( e.getSource() == b6)
				tfResult.setText(strText+ "6");
			else if ( e.getSource() == b7)
				tfResult.setText(strText+ "7");
			else if ( e.getSource() == b8)
				tfResult.setText(strText+ "8");
			else if ( e.getSource() == b9)
				tfResult.setText(strText+ "9");
			else if ( e.getSource() == bAdd) {
				opCode = "+";
				value_1 = tfResult.getText();
				tfResult.setText("");
			}
			else if ( e.getSource() == bResult) {
				value_2 = tfResult.getText();
				runCalucate();
			}
			else if ( e.getSource() == bce) {
				tfResult.setText("");
				value_1 = "";
				value_2 = "";
				opCode = "";
			}
				
		};
		b0.addActionListener(listener1);
		b1.addActionListener(listener1);
		b2.addActionListener(listener1);
		b3.addActionListener(listener1);
		b4.addActionListener(listener1);
		b5.addActionListener(listener1);
		b6.addActionListener(listener1);
		b7.addActionListener(listener1);
		b8.addActionListener(listener1);
		b9.addActionListener(listener1);
		bAdd.addActionListener(listener1);
		bResult.addActionListener(listener1);
		bce.addActionListener(listener1);
		
	}
	public void runCalucate() {
		if ( value_1.length() < 1 || value_2.length() < 1)
			tfResult.setText("");
		int val1 = Integer.parseInt(value_1);
		int val2 = Integer.parseInt(value_2);
		switch( opCode ) {
			case "+" : tfResult.setText( "" + (val1 + val2)); break;
			case "-" : tfResult.setText( "" + (val1 - val2)); break;
			case "*" : tfResult.setText( "" + (val1 * val2)); break;
			case "/" : tfResult.setText( "" + (val1 / val2)); break;
		}
		value_1 = "";
		value_2 = "";
		opCode = "";
	}
	public static void main(String[] args) {
		new CalculatorDemo();

	}

}
