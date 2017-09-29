package chapter_13;

public class test {

	public static void main(String[] args) {
		String a = new String("good");
		String b = new String("good");
		char[] c = {'g','o','o','d'};
		String d = String.valueOf(c);
		String a1 = "good";
		String b1 = "good";
		System.out.println( a1==b1);	//true
		System.out.println(a.equals(b));	//true
		System.out.println(a.equals(c));	//false
		System.out.println(a.equals(d));	//true
		System.out.println(a==b);	//false
		System.out.println(a==a1);	//false
		System.out.println(a1.equals(c));	//false
	}

}
