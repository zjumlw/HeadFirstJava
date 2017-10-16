package chapter_18.HelloTest;

import java.rmi.Naming;

public class HelloClient {

	public static void main(String[] args) {
		try { 
			HelloInterface hello = (HelloInterface) Naming.lookup("Hello"); 
			//如果要从另一台启动了RMI注册服务的机器上查找hello实例
			//HelloInterface hello = (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello"); 
			//调用远程方法
			//hello.sayHello();
			System.out.println(hello.sayHello()); 
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e); 
			} 
		}
}
