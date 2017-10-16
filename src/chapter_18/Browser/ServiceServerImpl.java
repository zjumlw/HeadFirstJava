package chapter_18.Browser;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer{
	//服务存在HashMap中
	HashMap serviceList;
	
	protected ServiceServerImpl() throws RemoteException {
		setUpService();
	}
	
	private void setUpService(){
		serviceList = new HashMap();
		serviceList.put("Dice Rolling Service", new DiceService());
		serviceList.put("Day of the week Service", new DayOfTheWeekService());
		serviceList.put("Visual Music Service", new MiniMusicService());
	}
	
	@Override
	public Object[] getServiceList() throws RemoteException {
		//取得服务的清单，送出Object的数组，只带有HashMap的Key，实际服务到用户要求时才通过getService()送出
		System.out.println("in remote");
		return serviceList.keySet().toArray();
	}

	@Override
	public Service getService(Object serviceKey) throws RemoteException {
		//通过Key返回HashMap中相对应的服务
		Service theService = (Service) serviceList.get(serviceKey);
		return theService;
	}
	
	public static void main(String[] args){
		try{
			 //启动RMI注册服务，指定端口为1099　（1099为默认端口）
	         //也可以通过命令 ＄java_home/bin/rmiregistry 1099启动
	         //这里用这种方式避免了再打开一个DOS窗口
	         //而且用命令rmiregistry启动注册服务还必须事先用RMIC生成一个stub类为它所用
			LocateRegistry.createRegistry(1099);
			Naming.rebind("ServiceServer", new ServiceServerImpl());
		}catch(Exception ex){
			System.out.println("error");
			ex.printStackTrace();
		}
		System.out.println("Remote service is running");
	}
}
