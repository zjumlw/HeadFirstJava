package beatBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BeatBoxFinal {
	JFrame theFrame;
	JPanel mainPanel;
	JList incomingList;
	ArrayList<JCheckBox> checkboxList;
	int nextNum;
	JTextField userMessage;
	Vector<String> listVector = new Vector<String>();
	String userName;
	ObjectOutputStream out;
	ObjectInputStream in;
	HashMap<String, boolean[]> otherSeqsMap = new HashMap<String, boolean[]>();
	
	Sequencer sequencer;
	Sequence sequence;
	Sequence mySequence = null;
	Track track;
	
	
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
		new BeatBoxFinal().startUp(args[0]);	//作为显示名称的命令栏参数，例如%java BeatBoxFianl theFlash
	}

	public void startUp(String name){
		userName = name;
		//open connection to the server
		try{
			//设置网络、输入输出、创建出reader线程
			Socket sock = new Socket("127.0.0.1", 4242);
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			Thread remote = new Thread(new RemoteReader());
			remote.start();
		}catch(Exception ex){
			System.out.println("couldn't connect - you'll have to play alone.");
//			ex.printStackTrace();
		}
		setUpmidi();
		buildGUI();
	}
	
	public void buildGUI(){
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	//没有内容时显示的窗口大小
		
		checkboxList = new ArrayList<JCheckBox>();	//得到一组checkbox对象
		
		Box buttonBox = new Box(BoxLayout.Y_AXIS);	//得到放置button的容器，Y轴放置
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		JButton downTempo = new JButton("Tempo Dwon");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		JButton sendIt = new JButton("sendIt");
		sendIt.addActionListener(new MySendListener());
		buttonBox.add(sendIt);
		
		userMessage = new JTextField();
		buttonBox.add(userMessage);
		
		incomingList = new JList();
		incomingList.addListSelectionListener(new MyListSelectionListener());
		incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane theList = new JScrollPane(incomingList);
//		theList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		theList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buttonBox.add(theList);
//		listVector.add("贝多芬");
//		listVector.add("莫扎特");
		incomingList.setListData(listVector);	//no data to start with
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);	//添加乐器的名字
		for(int i = 0; i < 16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		
		theFrame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid); //Create a new buffered JPanel with the specified layout manager
		background.add(BorderLayout.CENTER, mainPanel);
		
		for(int i = 0; i < 256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		
		theFrame.setBounds(50, 50, 300, 300); //x,t,width,height
		theFrame.pack();	//适应窗口大小
		theFrame.setVisible(true);
	}
	
	public void setUpmidi(){
		try{
			sequencer = MidiSystem.getSequencer();	//取得sequencer
			sequencer.open();	//打开
			sequence = new Sequence(Sequence.PPQ, 4);	
			track = sequence.createTrack();	//创建新的track
			sequencer.setTempoInBPM(120);	//设置节奏
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void buildTrackAndStart(){
		ArrayList<Integer> trackList = null;
		sequence.deleteTrack(track);	//先删除track
		track = sequence.createTrack();
		
		for(int i = 0; i < 16; i++)	{//16种乐器
			trackList = new ArrayList<Integer>();
			
			for(int j = 0; j < 16; j++){	//16个节拍
				JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
				if(jc.isSelected()){
					int key = instruments[i];
					trackList.add(new Integer(key));	//如果该乐器的某个节拍选中，则在trackList中添加该乐器的代号
				}else{
					trackList.add(null);
				}
			}
			makeTracks(trackList);
		}
		track.add(makeEvent(192, 9, 1, 0, 15));//确保第16拍有事件，否则BeatBox不会重复播放
		try{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("MyStartListener");
			buildTrackAndStart();
		}
	}
	
	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("MyStopListener");
			sequencer.stop();
		}
	}
	
	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("MyUpTempoListener");
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*1.03));
		}
	}
	
	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("MyDownTempoListener");
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor*0.97));
		}
	}
	
	public class MySendListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("MySendListener");
			boolean[] checkboxState = new boolean[256];
			for(int i = 0; i < 256; i++){
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if(check.isSelected()){
					checkboxState[i] = true;
				}
			}
			String messageToSend = null;
			try{
				out.writeObject(userName + nextNum++ + ":" + userMessage.getText());
				out.writeObject(checkboxState);
			}catch(Exception ex){
				System.out.println("Couldn't send it to the server");
				ex.printStackTrace();
			}
			userMessage.setText("");
		}
	}
	
	public class MyListSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent lse) {
			if(!lse.getValueIsAdjusting()){
				System.out.println("MyListSelectionListener");
				String selected = (String)incomingList.getSelectedValue();
				if(selected != null){
					//go to the map change the sequence
					boolean[] selectedState = (boolean[]) otherSeqsMap.get(selected);	//线程remote得到otherSeqsMap
					changeSequence(selectedState);
					sequencer.stop();
					buildTrackAndStart();
				}
			}
		}
	}
	
	public class RemoteReader implements Runnable{
		boolean[] checkboxState = null;
		String nameToShow = null;
		Object obj = null;
		public void run() {
			System.out.println("In RemoteReader Thread.");
			try{
				while((obj = in.readObject()) != null){
					System.out.println("got an object from server");
					System.out.println(obj.getClass());
					nameToShow = (String) obj;
					checkboxState = (boolean[]) in.readObject();
					otherSeqsMap.put(nameToShow, checkboxState);
					listVector.add(nameToShow);
					incomingList.setListData(listVector);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public class MyPlayMineListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(mySequence != null){
				sequence = mySequence;
			}
		}
		
	}
	public void changeSequence(boolean[] checkboxState){
		for(int i = 0; i < 256; i++){
			JCheckBox check = (JCheckBox) checkboxList.get(i);
			if(checkboxState[i]){
				check.setSelected(true);
			}else
				check.setSelected(false);
		}
	}
	
	//创建某项乐器的所有事件
	public void makeTracks(ArrayList list){
		//an iterator over the elements in this list in proper sequence
		Iterator it = list.iterator();
		for(int i = 0; i < 16; i++){
			Integer num = (Integer) it.next();
			if(num != null){
				//创建Note On和Note Off事件并加入到track中
				int numKey = num.intValue();
				track.add(makeEvent(144,9,numKey,100,i));	//Note on
				track.add(makeEvent(128,9,numKey,100,i+1));	//Note off
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
		
}
