package chapter_12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer2 implements ControllerEventListener {	//必须监听ControllerEvent
	
	public static void main(String[] args){
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}
	
	private void go() {
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			//向sequencer注册事件，注册的方法取用于监听者与想要监听的时间的int数组，只需要127事件
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this, eventsIWant);
			
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			int r = 0;
			for(int i = 5; i < 60; i+=4){
				r = (int)((Math.random()*50)+1);
				
				track.add(makeEvent(144,1,r,100,i));
				//插入事件编号为127的自定义ControllerEvent(176)，不会做任何事情，
				//只是让我们知道音符被播放，因为其tick和Note On是同时进行的
				track.add(makeEvent(176,1,127,0,i));	
				track.add(makeEvent(128,1,r,100,i+2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
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
	
	@Override
	public void controlChange(ShortMessage arg0) {
		System.out.println("la");
		
	}

}
