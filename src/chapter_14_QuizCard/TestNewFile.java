package chapter_14_QuizCard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestNewFile {

	public static void main(String[] args) {
		String filePath = "E:\\Test\\Java\\HeadFirstJava\\src\\chapter_14_QuizCard";
		String fileName = "Hello.txt";
		File myPath = new File(filePath);
		if(!myPath.exists())
			myPath.mkdir();
		System.out.println("path: " + filePath);
		
		try{
			String filePathName = filePath + "\\" + fileName;
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePathName));
			writer.write("what");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		String fileName2 = "E:\\Test\\Java\\HeadFirstJava\\src\\chapter_14_QuizCard\\a.txt";
		File file = new File(fileName2);
		
		try{

			System.out.println(file.exists());
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
			writer.write("ww211113r23");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}



