package graphics_prj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageDemo extends JFrame {
	String strFname = "D:\\kdt_2024\\WorkSpace\\java_eclipse\\graphics_prj\\src\\graphics_prj\\tiger.png";
	ImageDemo() {
		setTitle("이미지 그리기");

		class MyPanel extends JPanel {
			BufferedImage img;

			public MyPanel() {
				try {
					img = ImageIO.read(new File(strFname));
					System.out.println("가로 " + img.getWidth() + " 높이 : " + img.getHeight());
				} catch (IOException e) {
				}
			}

			public void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.drawImage(img, 0, 0, null);
				//g.drawImage(img, 0, 0, 150, 150, 50, 50, 150, 150, null);
			}
		}

		//add(new MyPanel());
		
		JLabel lbl = new JLabel("", JLabel.CENTER);
		ImageIcon icon = new ImageIcon(strFname);
		
		lbl.setIcon(icon);
		
		Image img= icon.getImage();
		System.out.println("가로 " + img.getWidth(null) + " 높이 : " + img.getHeight(null));
		
		//Image updateImage = img.getScaledInstance(240, 185, Image.SCALE_SMOOTH);
		Image updateImage = img.getScaledInstance(img.getWidth(null) / 2
				, img.getHeight(null) / 2
				, Image.SCALE_SMOOTH);
		ImageIcon  newIcon = new ImageIcon(updateImage);
		 
		lbl.setIcon(newIcon);
		//add(lbl);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ImageDemo();

	}

}
