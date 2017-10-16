package chapter_18.HelloTest;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloInterface {
	private String message;
	
	@Override
	public String sayHello() throws RemoteException {
		System.out.println("Called by HelloClient");
		return message;
	}

	public Hello() throws RemoteException{
	}
	
	public Hello(String msg) throws RemoteException{
		message = msg;
	}
}
