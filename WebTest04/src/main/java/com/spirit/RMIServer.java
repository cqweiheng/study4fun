package com.spirit;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

	public static void main(String[] args) {
		try {
			int port = 8888;
			String url = "rmi://127.0.0.1:" + 8888 + "/PersonService";
			PersonService personService = new PersonServiceImpl();
			LocateRegistry.createRegistry(port);
			Naming.bind(url, personService);
			System.out.println(port + "==== RMI服务已启动");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
