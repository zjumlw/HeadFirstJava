package chapter_12;

import java.awt.*;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer3 {
	static JFrame f = new JFrame("Music Video");
	static MyDrawPanel ml;
	
	public void setUpGui(){
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30,30,300,300);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}
	
	private void go() {
		setUpGui();
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(ml, eventsIWant);
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 0; i < 60; i+=4){
				r = (int)((Math.random()*50)+1);
				track.add(makeEvent(144,1,r,100,i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,r,100,i+2));
			}
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			sequencer.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

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
			repaint();
		}
		
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2 = (Graphics2D)g;
				int red = (int)(Math.random()*250);
				int green = (int)(Math.random()*250);
				int blue = (int)(Math.random()*250);
				g.setColor(new Color(red,green,blue));
				
				int height = (int)((Math.random()*120)+10);
				int width = (int)((Math.random()*120)+10);
				int x = (int)((Math.random()*40)+10);
				int y = (int)((Math.random()*40)+10);
				g.fillRect(x, y, width, height);
				msg = false;
			}
		}
	}
}
