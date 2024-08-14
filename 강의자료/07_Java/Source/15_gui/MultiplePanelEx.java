import java.awt.*;
import javax.swing.*;

public class MultiplePanelEx extends JFrame {
	public MultiplePanelEx() {
		super("Multiple Panels and Layouts"); // 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane(); // 프레임으로부터 컨텐트팬 알아내기
		c.setLayout(new BorderLayout()); // 컨텐트팬의 배치 관리자 BorderLayout
		
		// 컨텐트팬에 2개의 패널(컨테이너) 부착
		c.add(new NorthPanel(), BorderLayout.NORTH); // NORTH 영역에 NorthPanel 패널 부착
		c.add(new CenterPanel(), BorderLayout.CENTER); // CENTER 영역에 CenterPanel 패널 부착
		setSize(300,300);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel { // 컨텐트팬의 NORTH 영역 패널
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY); // 배경색 설정
			setLayout(new FlowLayout()); // FlowLayout 배치관리자 지정
			add(new JButton("Open"));
			add(new JButton("Read"));
			add(new JButton("Close"));	
		}
	}

	class CenterPanel extends JPanel {	// 컨텐트팬의 CENTER 영역 패널
		private JLabel [] labels = {new JLabel("Hello"), 
				new JLabel("Java"), new JLabel("Love")}; // 3개의 JLabel을 가진 배열 
		public CenterPanel() {
			setLayout(null); // 배치관리자 삭제, 절대 위치에 컴포넌트 삽입
			for(int i=0; i<labels.length; i++) {
				int x = (int)(Math.random()*200); // 0에서 200미만의 랜덤 정수
				int y = (int)(Math.random()*200); // 0에서 200미만의 랜덤 정수
				labels[i].setLocation(x, y); // 랜덤한 위치에 JLabel 배치
				labels[i].setSize(100,20); // JLabel의 크기 지정
				add(labels[i]); // JLabel을 이 패널(CenterPanel)에 부착				
			}			
		}		
	}
	
	static public void main(String[] arg) {
		new MultiplePanelEx();
	}
}
