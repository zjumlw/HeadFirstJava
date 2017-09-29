package chapter_12;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicPlayer1 {
	//静态方法制作信息并返回MidiEvent
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
	public static void main(String[] args) {
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();	//从MidiSystem取得定序器并打开
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);	//创建新的序列
			Track track = seq.createTrack();	//从序列中创建新的track
			
			for(int i = 5; i < 61; i+=4){
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
