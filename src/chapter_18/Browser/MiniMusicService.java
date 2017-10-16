package chapter_18.Browser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MiniMusicService implements Service {
	
	MyDrawPanel myPanel;
	
	@Override
	public JPanel getGuiPanel() {
		JPanel mainPanel = new JPanel();
		myPanel = new MyDrawPanel();
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new PlayListener());
		mainPanel.add(myPanel);
		mainPanel.add(playButton);
		return mainPanel;
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
		boolean msg = false;
		
		public void controlChange(ShortMessage event){
			msg= true;
			repaint();
		}
		
		public Dimension getPreferredSize(){
			return new Dimension(300, 300);
		}
		
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2 = (Graphics2D) g;
				
				int r = (int)(Math.random()*250);
				int gr = (int)(Math.random()*250);
				int b = (int)(Math.random()*250);
				
				g.setColor(new Color(r, gr, b));
				
				int ht = (int)((Math.random()*120) + 10);
				int width = (int)((Math.random()*120) + 10);
				
				int x = (int)((Math.random()*40) + 10);
				int y = (int)((Math.random()*40) + 10);
				
				g.fillRect(x, y, width, ht);
				msg = false;
			}
		}
		
	}

	class PlayListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				Sequencer sequencer = MidiSystem.getSequencer();
				sequencer.open();
				
				sequencer.addControllerEventListener(myPanel, new int[] {127});
				Sequence seq = new Sequence(Sequence.PPQ, 4);
				Track track = seq.createTrack();
				for(int i = 0; i < 100; i+=4){
					int r = (int)((Math.random()*50) +1);
					if(r < 38){
						track.add(makeEvent(144,1,r,100,i));	//开始音符
						track.add(makeEvent(176,1,127,0,i));	//自定义ControllerEvent
						track.add(makeEvent(128,1,r,100,i+2));	//结束音符
					}
				}
				
				sequencer.setSequence(seq);
				sequencer.start();
				sequencer.setTempoInBPM(220);
			}catch(Exception ex){
				ex.printStackTrace();
			}
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
	
}
