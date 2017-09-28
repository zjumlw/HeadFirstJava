package chapter_9;

public class Animal {
	private String name = "kitty";
	
	public String getName(){
		return name;
	}
	
	public Animal(){
		System.out.println("Animal无参数构造函数");
	}
	
	public Animal(String name){
		this.name = name;
		System.out.println("Animal有参数构造函数");
	}
}
