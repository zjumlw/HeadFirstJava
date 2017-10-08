package chapter_14_QuizCard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TestDrive {
	JFrame frame;
	private JTextArea question;
	private ArrayList<QuizCard> cardList;
	
	public static void main(String[] args) {
		TestDrive test = new TestDrive();
		test.go();
	}

	public void go(){
		frame = new JFrame("TestDrive");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		question = new JTextArea(6, 20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel qLabel = new JLabel("Question:");
		
		JButton getText = new JButton("GetText");
		getText.addActionListener(new getTextListener());
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ClearTextListener());
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
	//	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(getText);
		mainPanel.add(clear);
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	private void clearCard(){
		question.setText("");
		question.requestFocus();
	}
	
	private class getTextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(question.getText());
		}
		
	}
	
	private class ClearTextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			clearCard();
		}
		
	}
}
