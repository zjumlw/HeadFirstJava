package chapter_13;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckBox1 implements ItemListener{
	JCheckBox check;
	public static void main(String[] args) {
		CheckBox1 gui = new CheckBox1();
		gui.go();
	}
	private void go() {
		JFrame frame = new JFrame("CheckBox");
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		check = new JCheckBox("Goes to 11");
		//check.addActionListener(new CheckListener());	//自定义的Listener
		check.addItemListener(this);
		panel.add(check);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		check.setSelected(true);
		check.setSelected(false);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String onOrOff = "off";
		if(check.isSelected())
			onOrOff = "on";
		System.out.println("Check box is " + onOrOff);
	}

	class CheckListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String onOrOff = "off";
			if(check.isSelected())
				onOrOff = "on";
			System.out.println("Check box is " + onOrOff);
		}
		
	}
}
