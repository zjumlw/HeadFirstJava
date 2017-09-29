package chapter_11;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}

	private void play() {
		try{
			Sequencer player = MidiSystem.getSequencer();	//取得Sequencer并将其打开
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);	//
			
			Track track = seq.createTrack();	//取得Track
			
			//对Track加入2个MidiEvent
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);	//144：“NOTE ON”；1：频道，每个频道代表不同的演奏者；44：发出44音符，0-127代表不同音高；
										//100：音道，声音大小
			MidiEvent noteOn = new MidiEvent(a, 1);	//在第1拍启动a这个message
			track.add(noteOn);	//将MidiEvent加到Track中
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,44,100);	//128：关闭，
			MidiEvent noteOff = new MidiEvent(b, 14);//在第8拍结束a这个message
			track.add(noteOff);
			
			ShortMessage a1 = new ShortMessage();
			a1.setMessage(144,7,80,100);	//144：“NOTE ON”；1：频道，每个频道代表不同的演奏者；44：发出44音符，0-127代表不同音高；
										//100：音道，声音大小
			MidiEvent noteOn1 = new MidiEvent(a1, 9);	//
			track.add(noteOn1);	//将MidiEvent加到Track中
			
			ShortMessage b1 = new ShortMessage();
			b1.setMessage(128,7,80,100);	//128：关闭，
			MidiEvent noteOff1 = new MidiEvent(b1, 16);//
			track.add(noteOff1);
			
//			ShortMessage first = new ShortMessage();
//			first.setMessage(192,1,102,0);	//192：改变乐器；1：第1个频道；102：换成102乐器
			
			player.setSequence(seq);	//将Sequence送到Sequencer上
			
			player.start();	//开始播放
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

}
