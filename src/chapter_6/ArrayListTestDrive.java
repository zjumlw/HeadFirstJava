package chapter_6;

import java.util.ArrayList;

class Egg{
	
}
public class ArrayListTestDrive {

	public static void main(String[] args) {
		ArrayList<Egg> myList = new ArrayList<Egg>();
		Egg s = new Egg();
		myList.add(s);
		
		Egg b = new Egg();
		myList.add(b);
		
		int theSize = myList.size();
		System.out.println(theSize);
		Boolean isIn = myList.contains(s);
		System.out.println(isIn);
		int idx = myList.indexOf(s);
		System.out.println(idx);
		Boolean empty = myList.isEmpty();
		System.out.println(empty);
		myList.remove(s);
		System.out.println(theSize);		
		
		String[] myString = new String[2];
		String strA = new String("waaaa");
		String strB = new String("ohhhh");
		myString[0] = strA;
		myString[1] = strB;
		System.out.println(myString[0]);
		strA = "lalaa";
		System.out.println("length = " + myString.length);
		System.out.println(strA);
		System.out.println(myString[0]);
	}

}
