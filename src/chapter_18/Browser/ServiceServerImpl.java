package chapter_18.Browser;

import java.rmi.Naming;
import java.rmi.RemoteException;
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
			Naming.rebind("ServiceServer", new ServiceServerImpl());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Remote service is running");
	}
}
