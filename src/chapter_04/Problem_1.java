package chapter_04;

class Dog{
	private int size;
	private String name;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	void bark() {
		if(size > 60) {
			System.out.println("Wooof!");
		}
		else if(size > 14) {
			System.out.println("Ruff!");
		}
		else {
			System.out.println("Yip!");
		}
	}
}
public class Problem_1 {

	public static void main(String[] args) {
		Dog[] pets = new Dog[7];
		pets[0] = new Dog();
		pets[1] = new Dog();
		//pets[0].setSize(8);
		int x = pets[0].getSize();
		pets[1].setSize(20);
		System.out.println(x);
		System.out.println(pets[0].getName());
		
	}

}
