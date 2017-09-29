package chapter_12;

import java.awt.*;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer3 {
	static JFrame f = new JFrame("Music Video");
	static MyDrawPanel ml;
	
	public void setUpGui(){
		ml = new MyDrawPanel();	//MyDrawPanel是JPanel子类，所以用这种方法
		f.setContentPane(ml);	//加入MyDrawPanel
		f.setBounds(30,30,300,300);	//设置边界
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();	//运行mini
	}
	
	private void go() {
		setUpGui();
		try{
			Sequencer sequencer = MidiSystem.getSequencer();	//获取Sequencer
			sequencer.open();	//打开sequencer
			int[] eventsIWant = {127};	
			sequencer.addControllerEventListener(ml, eventsIWant);	//向sequencer注册事件，监听者是MyDrawPanel
			Sequence seq = new Sequence(Sequence.PPQ,4);	//创建新的序列
			Track track = seq.createTrack();	//从序列中创建新的track
			
			int r = 0;
			for(int i = 0; i < 60; i+=4){
				r = (int)((Math.random()*50)+1);	//随机的音高
				track.add(makeEvent(144,1,r,100,i));	//开始音符
				track.add(makeEvent(176,1,127,0,i));	//自定义ControllerEvent
				track.add(makeEvent(128,1,r,100,i+2));	//结束音符
			}
			sequencer.setSequence(seq);	//开始播放
			sequencer.setTempoInBPM(120);
			sequencer.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//静态makeEvent函数，制作信息并返回MidiEvent
	//前四个参数是给信息，tick是何时播放信息
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a,tick);
		}catch(Exception e){}
		return event;
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
		boolean msg = false;	//获知事件时才会为真
		
		@Override
		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();	//如果监测到播放音符，则repaint
		}
		
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2 = (Graphics2D)g;
				int red = (int)(Math.random()*250);
				int green = (int)(Math.random()*250);
				int blue = (int)(Math.random()*250);
				g.setColor(new Color(red,green,blue));	//设置颜色
				
				int height = (int)((Math.random()*120)+10);
				int width = (int)((Math.random()*120)+10);
				int x = (int)((Math.random()*40)+10);
				int y = (int)((Math.random()*40)+10);
				g.fillRect(x, y, width, height);	//填充矩形
				msg = false;	//msg参数置为false
			}
		}
	}
}
