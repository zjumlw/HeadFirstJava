package chapter_9;

public class MakeDuck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d1 = new Duck();
		System.out.println(d1.getSize() + " " + d1.getName());
		
		Duck d2 = new Duck(10);
		System.out.println(d2.getSize() + " " + d2.getName());
		
		Duck d3 = new Duck("mengmeng");
		System.out.println(d3.getSize() + " " + d3.getName());
	}

}
