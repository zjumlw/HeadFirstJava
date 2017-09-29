package chapter_12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui3C implements ActionListener {
	JFrame frame;
	
	public static void main(String[] args){
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}
	private void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton colorButton = new JButton("Change colors");
		JButton labelButton = new JButton("Change label");
		colorButton.addActionListener(this);
		
		MyDrawPanel2 drawPanel = new MyDrawPanel2();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}

}
