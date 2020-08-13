package com.spirit;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonService extends Remote {

	public Person getPerson() throws RemoteException;
}
