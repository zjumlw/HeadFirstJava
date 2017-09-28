package chapter_11;

import javax.sound.midi.*;

public class MusicTest1 {

	public void play() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("Successfully  got a sequencer.");
		} catch (MidiUnavailableException e) {
			System.out.println("Bummer.");
			e.printStackTrace(); //列出有用的信息
		}

	}
	public static void main(String[] args) {
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}

}
