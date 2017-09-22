package chapter_9;

public class MakeHippo {

	public static void main(String[] args) {
		Hippo h = new Hippo();
		Hippo h2 = new Hippo("Lucy");
		System.out.println(h.getName());
		System.out.println(h2.getName());
	}

}
