package chapter_13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class test {

	public static void main(String[] args) {
		String a = new String("good");
		String b = new String("good");
		char[] c = {'g','o','o','d'};
		String d = String.valueOf(c);
		String a1 = "good";
		String b1 = "good";
		System.out.println(a1==b1);	//true
		System.out.println(a.equals(b));	//true
		System.out.println(a.equals(c));	//false
		System.out.println(a.equals(d));	//true
		System.out.println(a==b);	//false
		System.out.println(a==a1);	//false
		System.out.println(a1.equals(c));	//false
		
//		try{
//		FileOutputStream f = new FileOutputStream(new File("foo.ser"));
//		ObjectOutputStream os = new ObjectOutputStream(f);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		try{
//		BufferedReader reader = new BufferedReader(new FileReader(new File("foo1.ser")));
//		String line = null;
//		while((line = reader.readLine()) != null){
//			System.out.println("1");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
//		
				
	}
}
