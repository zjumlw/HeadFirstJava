package chapter_04;

public class XCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int origin = 42;
		XCopy x = new XCopy();
		int y = x.go(origin);
		System.out.println(y);

	}
	int go(int arg) {
		return arg*2;
	}

}
