package chapter_10;

public class Duck {
	private int size;
	private static int duckCount = 0;
	private static String name = "Tang";
	public void setSize(int size){
		this.size = size;
	}
	
	public Duck(){
		duckCount++;
	}
	public static void main(String[] args) {
		Duck d1 = new Duck();
		Duck d2 = new Duck();
		Duck d3 = new Duck();
		System.out.println(duckCount);
		d1.setSize(10);
		System.out.println("size = " + d1.size);
		System.out.println(name);
	}

}
