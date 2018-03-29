

import java.rmi.Naming;
import java.rmi.RemoteException;
// import java.rmi.RMISecurityManager;
import java.rmi.server.*;


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/*
Classname: HelloServerDemo
Purpose: The RMI server.
*/
public class HelloServer extends UnicastRemoteObject
  implements Hello {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

public HelloServer() throws RemoteException {}

public String sayHello() {
    System.out.println("Invocation to Hello was succesful!");
    return "Hello World from RMI server!";
  }

  public static void main(String args[]) {
    try {
      // Creates an object of the HelloServer class.
      HelloServer obj = new HelloServer();
      // Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);


            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", obj);


      // // Bind this object instance to the name "HelloServer".
      // Naming.rebind("Hello", obj);
      // System.out.println("Ligado no registro");
    }
    catch (Exception ex) {
      System.out.println("error: " + ex.getMessage());
      ex.printStackTrace();
    }
}
}
