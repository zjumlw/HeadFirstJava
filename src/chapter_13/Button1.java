package chapter_13;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button1 {

	public static void main(String[] args) {
		Button1 gui = new Button1();
		gui.go();
	}

	private void go() {
		JFrame frame = new JFrame("Button1");
		JButton button = new JButton("click me");
		JButton button1 = new JButton("click me1");
		Font bigFont = new Font("Time New Roman", Font.BOLD, 28);
		button.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}
