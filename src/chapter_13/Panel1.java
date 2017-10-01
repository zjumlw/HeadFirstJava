package chapter_13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 {
	JButton button;
	JButton buttonClear;
	JTextField field;
	boolean flagChangeText = true;
	
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
		
	}

	private void go() {
		JFrame frame = new JFrame("Panel1");
		JPanel panel = new JPanel();
		
		field = new JTextField("你好");
		
		panel.setBackground(Color.gray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		button = new JButton(" Change text");
		button.addActionListener(new TextListener());
		
		buttonClear = new JButton("Clear text");
		buttonClear.addActionListener(new TextClearListener());
		
		JButton button1 = new JButton("Click me");
//		JButton button2 = new JButton("Click me2");
		

		System.out.println(field.getText());
		
		panel.add(field);
		panel.add(button);
		panel.add(buttonClear);
//		panel.add(button1);
//		panel.add(button2);
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.getContentPane().add(BorderLayout.SOUTH,panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	class TextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(flagChangeText){
			field.setText("Hello");
			flagChangeText = false;
			}
			else{
			field.setText("你好");
			flagChangeText = true;
			}
		}
	}
	
	class TextClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			field.setText("");
		}
		
	}
	

}
