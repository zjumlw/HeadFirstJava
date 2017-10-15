package chapter_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("AAA", 43);
		scores.put("BBB", 121);
		scores.put("CCC", 21);
	    System.out.println(scores);
	    System.out.println(scores.get("AAA"));
	}
}
