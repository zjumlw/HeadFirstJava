package chapter_14_QuizCard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ReadAFile {

	public static void main(String[] args) {
		try{
			File myFile = new File("E:\\Test\\Java\\HeadFirstJava\\src\\chapter_14_QuizCard\\Foo.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(myFile),"GBK"));
//			BufferedReader reader = new BufferedReader(new FileReader(myFile));	//查看是否注释问题
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
