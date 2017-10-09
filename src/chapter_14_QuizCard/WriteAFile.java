package chapter_14_QuizCard;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {

	public static void main(String[] args) {
		try{
			FileWriter writer = new FileWriter("E:\\Test\\Java\\HeadFirstJava\\src\\chapter_14_QuizCard\\Foo.txt");
			writer.write("hello你好");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
