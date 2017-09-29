package chapter_12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1B implements ActionListener{	//实现此接口
	JButton button;
	
	public static void main(String[] args){
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}
	
	private void go() {
		JFrame frame = new JFrame();
		button = new JButton("click me");
		
		button.addActionListener(this);	//向按钮注册
		
		MyDrawPanel2 myDraw = new MyDrawPanel2();
		
		frame.getContentPane().add(myDraw);
//		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {	//监听的事件处理方法
		button.setText("Clicked!");
	}

}
