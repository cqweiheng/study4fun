package com.spirit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PersonServiceImpl extends UnicastRemoteObject implements PersonService{

	public PersonServiceImpl() throws RemoteException{

	}

	@Override
	public Person getPerson() throws RemoteException {
		return new Person().setAge(32).setName("蛋蛋");
	}
}
