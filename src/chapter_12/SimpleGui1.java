package chapter_12;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//在window关闭时结束程序
		frame.getContentPane().add(button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}
