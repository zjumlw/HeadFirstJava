package chapter_07;

class Appliance{
	public void turnOn(){
		System.out.println("Appliance turnOn.");
	};
}

class Toaster extends Appliance{
	public void turnOn(){
		System.out.println("Toaster turnOn.");
	};
}

class A{
	int n = 7;
	void m1(){
		System.out.println("A's m1 ");
	}
	void m2(){
		System.out.println("A's m2 ");
	}
	void m3(){
		System.out.println("A's m3 ");
	}
}

class B extends A{
	void m1(){
		System.out.println("B's m1 " );
	}
}

class C extends B{
	void m3(){
		System.out.println("C's m3 "+ (n + 6));
	}
}

public class TestDrive {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();
		a2.m1();
		a2.m2();
		a2.m3();
	}

}
