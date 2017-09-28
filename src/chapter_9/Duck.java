package chapter_9;

public class Duck extends Animal{
	private int size;
	
	public int getSize(){
		return size;
	}
	
	public Duck(){
		this(8);
		System.out.println("Duck无参数构造函数");
	}
		
	public Duck(int newSize){
		super("唐老鸭");
		size = newSize;
		System.out.println("Duck有参数构造函数--size");
	}
	
	public Duck(String name){
		super(name);
		size = 9;
		System.out.println("Duck有参数构造函数--name");
	}
}
