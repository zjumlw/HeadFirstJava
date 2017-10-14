package chapter_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Jukebox1 {
	ArrayList<String> songList = new ArrayList<String>();
	ArrayList<String> artistList = new ArrayList<String>();
	public static void main(String[] args) {
		new Jukebox1().go();
	}
	
	public void go(){
		getSongs();
		Collections.sort(songList);
		System.out.println(songList);
		System.out.println(artistList);
	}
	
	private void getSongs(){
		try{
			File file = new File("E:\\Test\\Java\\HeadFirstJava\\src\\chapter_16\\SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				addSong(line);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
//		System.out.println(tokens.length);
		songList.add(tokens[0]);
		artistList.add(tokens[1]);
	}
}
