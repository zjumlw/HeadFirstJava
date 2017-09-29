package chapter_12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
	int x = 0;
	int y = 0;
	
	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}

	private void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		for(int i = 0; i < 130; i++){
			x++;
			y++;
			drawPanel.repaint();	//重新绘制面板
			try{
				Thread.sleep(50);	//加上延迟可以放缓
			}catch(Exception e){}
		}
	}
	
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.red);
			g.fillOval(x, y, 100, 100);
			
		}
	}
}
