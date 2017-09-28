package chapter_10;

import java.util.Date;

public class TestFormats {

	public static void main(String[] args) {
		String s = String.format("I have the time: %td, %ta", new Date(), new Date());
		System.out.println(s);
	}

}
