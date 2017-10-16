package chapter_18.Browser;

import java.rmi.*;

public interface ServiceServer extends Remote {
	//远程服务器要实现的方法
	Object[] getServiceList() throws RemoteException;
	Service getService(Object serviceKey) throws RemoteException;
}
