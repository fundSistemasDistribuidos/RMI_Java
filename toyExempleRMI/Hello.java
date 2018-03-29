

import java.rmi.*;
import java.rmi.RemoteException;

/*
Classname: Hello
Comment: The remote interface.
*/
public interface Hello extends Remote {
	String sayHello() throws RemoteException;
}
