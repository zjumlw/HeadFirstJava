package chapter_13;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BeatBox {
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	
	String[] instrumentNames = {
			"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
			"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo",
			"Maracas", "Whistle", "Low Conga", "Cowbell",
			"Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"
	};
	int[] instruments ={
			35, 42, 46, 38,
			49, 39, 50, 60,
			70, 72, 64, 56,
			58, 47, 67, 63
	};
	
	public static void main(String[] args) {
		new BeatBox().buildGUI();
		
	}

	private void buildGUI() {
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();		
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//		background.setBackground(Color.gray);
		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i < 16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
	//	theFrame.getContentPane().add(background);	//两个位置好像都可以
		
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);
		
		//创建出checkbox组，设置为false并加到ArrayList和面板上
		for(int i = 0; i < 256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		
		setUpMidi();
		
		theFrame.getContentPane().add(background);	//两个位置好像都可以
		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();	//调整窗口大小
		theFrame.setVisible(true);
	}

	public void setUpMidi(){
		try{
			sequencer = MidiSystem.getSequencer();	//取得sequencer
			sequencer.open();	//打开
			sequence = new Sequence(Sequence.PPQ, 4);	
			track = sequence.createTrack();	//创建新的track
			sequencer.setTempoInBPM(120);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//
	public void buildTrackAndStart(){
		int[] trackList = null;
		
		//清除旧的track并新建一个
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for(int i = 0; i < 16; i++){	//对每个乐器都执行一次
			trackList = new int[16];
			int key = instruments[i];
			
			for(int j = 0; j < 16; j++){	//对每一拍都执行一次
				JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
				if(jc.isSelected()){	//如果被勾选，将关键字放在数组的该位置上
					trackList[j] = key;
				}else{
					trackList[j] = 0;
				}
			}
			
			makeTracks(trackList);	//创建此乐器的事件并加到track上
			track.add(makeEvent(176,1,127,0,16));	//相当于标志位，乐器执行完毕
		}
		
		track.add(makeEvent(192,9,1,0,15));	//确保第16拍有事件，否则BeatBox不会重复播放
		
		try{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//创建某项乐器的所有事件
	public void makeTracks(int[] list){
		for(int i = 0; i < 16; i++){
			int key = list[i];
			
			if(key != 0){
				//创建Note On和Note Off事件并加入到track中
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}
	
	//制作乐曲信息
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();	//创建message
			a.setMessage(comd, chan, one, two);	//置入指令
			event = new MidiEvent(a,tick);	//创建得到MidiEvent
		}catch(Exception e){
			e.printStackTrace();
		}
		return event;	//返回MidiEvent 乐曲信息
	}
	
	//内部类：按钮的监听者
	class MyStartListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			buildTrackAndStart();
		}
	}
	
	class MyStopListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			sequencer.stop();
		}
	}
	
	class MyUpTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));
		}
	}
	
	class MyDownTempoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*0.97));
		}
	}
	
}
