package chapter_15;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {

	JTextField outgoing;
	Socket sock;
	PrintWriter writer;
	public static void main(String[] args) {
		SimpleChatClientA client = new SimpleChatClientA();
		client.go();
	}
	
	public void go(){
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
	//	outgoing.setSize(20, 10);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		
		setUpNetworking();
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
	
	class SendButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("sending message");
			try{
				writer.println(outgoing.getText());
				writer.flush();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
		
	}
	
	private void setUpNetworking(){
		try{
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
