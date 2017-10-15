package chapter_16;

public class Song implements Comparable<Song>{
	private String title;
	private String artist;
	private String rating;
	private String bpm;
	
	public boolean equals(Object aSong){
		Song s = (Song) aSong;
		return this.getTitle().equals(s.getTitle());
	}
	
	public int hashCode(){
		return this.title.hashCode();
	}
	
	Song(String t, String a, String r, String b){
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public String getRating(){
		return rating;
	}
	
	public String getBpm(){
		return bpm;
	}
	
	//覆盖toString()
	public String toString(){
		return title;
	}

	@Override
	public int compareTo(Song s) {
		return title.compareTo(s.getTitle());
	}
}
