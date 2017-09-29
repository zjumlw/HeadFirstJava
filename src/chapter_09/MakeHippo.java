package chapter_09;

import java.util.ArrayList;

public class MakeHippo {

	public static void main(String[] args) {
		Hippo h1 = new Hippo();
		Hippo h2 = new Hippo("Lucy");
		System.out.println("h1 = " + h1.getName());
		System.out.println("h2 = " + h2.getName());
		//不指定类型，则将存储的对象当做Object使用，拿出来的时候需要进行类型转换
		ArrayList manyHippos = new ArrayList();
		manyHippos.add(h1);
		manyHippos.add(h2);
		Hippo h1tmp =  (Hippo) manyHippos.get(0);
		Hippo h2tmp =  (Hippo) manyHippos.get(1);
		System.out.println("h1tmp = " + h1tmp.getName());
		System.out.println("h2tmp = " + h2tmp.getName());
		
	}

}
