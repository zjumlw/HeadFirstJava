package chapter_16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMapTest {

	public static void main(String[] args) {
		
	    ArrayList<Integer> al = new ArrayList<Integer>();  
	    al.add(3);  
	    al.add(2);          
	    al.add(1);  
	    al.add(4);  
	    al.add(5);  
	    al.add(6);  
	    al.add(6);  
	    System.out.println(al.get(0));
	  
	    Iterator<Integer> iter1 = al.iterator();  
	    while(iter1.hasNext()){  
	        System.out.println(iter1.next());  
	    } 
	    
	    LinkedList<Integer> ll = new LinkedList<Integer>();  
	    ll.add(3);  
	    ll.add(2);          
	    ll.add(1);  
	    ll.add(4);  
	    ll.add(5);  
	    ll.add(6);  
	    ll.add(6);  
	    System.out.println("size = " + ll.size());
	    System.out.println("------" + ll.get(ll.size()-1));
	  
	    Iterator<Integer> iter2 = ll.iterator();  
	    while(iter2.hasNext()){  
	        System.out.println(iter2.next());  
	    } 
	}
}
