package chapter_10;

public class Foo6 {
	int x =15;
	
	public static void go(final int x){
		System.out.println(x);
	}
	public static void main(String[] args) {
		Foo6 f6 = new Foo6();
//		f6.go(x);	//错：静态方法不能存取调用非静态变量
	}

}
