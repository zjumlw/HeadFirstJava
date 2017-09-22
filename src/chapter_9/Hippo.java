package chapter_9;

public class Hippo extends Animal{
	private String name;
	
	public String getName(){
		return name;
	}
	
	public Hippo(){
		this("Tom");
		System.out.println("Hippo无参数构造函数");
	}
	
	public Hippo(String name){
		this.name = name;
		System.out.println("Hippo带参数构造函数");
	}
}
