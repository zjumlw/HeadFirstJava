package chapter_13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea1 implements ActionListener {
	JTextArea text;
	
	public static void main(String[] args){
		TextArea1 gui = new TextArea1();
		gui.go();
		
	}
	private void go() {
		JFrame frame = new JFrame("TextArea1");
		JPanel panel = new JPanel();
		JButton button = new JButton("Click it");
		button.addActionListener(this);
		text = new JTextArea(10,20);	//10行，20字宽
	//	text.setText("Hello");
		text.setLineWrap(true);	//启动自动换行
		
		JScrollPane scroller = new JScrollPane(text);	//将text赋值给新建的JScrollPane
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		frame.setSize(350, 300);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text.append("button clicked \n");
	}

}
