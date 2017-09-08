package chapter_3;


class dog{
	private int age;
	
	public dog(int age) {
		this.age = age;
	}
	public dog() {
		this.age = 0;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int showAge() {
		return this.age;
	}
}

public class Problem_1 {

	public static void main(String[] args) {		
		dog dog1 = new dog(4);
//		dog1.setAge(3);
		System.out.println("dog1: " + dog1.showAge());
//		System.out.println("Integer: "+Integer.SIZE/8);
		
		dog1 = new dog();
		dog1.setAge(13);
		System.out.println("dog1: " + dog1.showAge());
		
		dog dog2 = dog1;
		System.out.println("dog2: " + dog2.showAge());
		
	}

}
