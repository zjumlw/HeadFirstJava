package chapter_03;


class dog{
	private int age;
	private String name;
	
	public dog(int age,String name) {
		this.age = age;
		this.name = name;
	}
	public dog(int age) {
		this.age = age;
	}
	public dog() {
	}
	
	public void bark() {
		System.out.println(name + "汪汪汪!");
	}
	public void eat() {
		
	}
	public void chaseCat() {
		
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int showAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String showName() {
		return this.name;
	}
	
}

public class Problem_1 {

	public static void main(String[] args) {		
		dog dog1 = new dog(4);
//		dog1.setAge(3);
		//中文注释
		System.out.println("dog1: " + dog1.showAge());
//		System.out.println("Integer: "+Integer.SIZE/8);
		
		dog1 = new dog();
		dog1.setAge(13);
		System.out.println("dog1: " + dog1.showAge());
		
		dog dog2 = dog1;
		System.out.println("dog2: " + dog2.showAge());
		
		dog1 = null;
//		System.out.println("dog1: " + dog1.showAge());
//		error: dog1没有引用任何事物
	
		
	}

}
