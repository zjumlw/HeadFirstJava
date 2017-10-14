package chapter_15;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {

	JTextField outgoing;
	JTextArea incoming;
	BufferedReader reader;
	Socket sock;
	PrintWriter writer;
	
	public static void main(String[] args) {
		SimpleChatClient client = new SimpleChatClient();
		client.go();
	}
	
	public void go(){
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15, 50);
		incoming.setLineWrap(true);	//自动换行
		incoming.setWrapStyleWord(true);	//激活断行不断字功能
		incoming.setEditable(false);	//不可编辑
		JScrollPane scroller = new JScrollPane(incoming);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		
		mainPanel.add(scroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		
		setUpNetworking();
		
		//启动新的进程，以内部类为任务，该任务读取服务器的socket串流显示在文本区域
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(600, 500);
		frame.setVisible(true);
	}
	
	class SendButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println("sending message");
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
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	//thread的任务
	public class IncomingReader implements Runnable{

		@Override
		public void run() {
			String message;
			try{
				while((message = reader.readLine()) != null){
					System.out.println("read " + message);
					incoming.append(message + "\n");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
}
