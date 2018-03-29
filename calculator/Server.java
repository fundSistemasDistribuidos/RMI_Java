

import java.rmi.Naming;
import java.rmi.RemoteException;
// import java.rmi.RMISecurityManager;
import java.rmi.server.*;


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/*
Classname: ServerDemo
Purpose: The RMI server.
*/
public class Server extends UnicastRemoteObject
  implements Calc {

  /**
	 *
	 */
	private static final long serialVersionUID = 1L;

public Server() throws RemoteException {}

public Integer calc(String op, Integer op1, Integer op2) {
    Integer resp = 0;
    switch(op){
      case "+":
        resp = op1 + op2;
        break;
      case "-":
        resp = op1 - op2;
        break;
      case "*":
        resp = op1 * op2;
        break;
      case "/":
        resp = op1 / op2;
        break;

    }
    System.out.println("Calculado!");
    return resp;
  }

  public static void main(String args[]) {
    try {
      // Creates an object of the Server class.
      Server obj = new Server();
      Registry registry = LocateRegistry.createRegistry(9999);
      registry.bind("Calc", obj);


      // // Bind this object instance to the name "Server".
      // Naming.rebind("Hello", obj);
      System.out.println("Ouvindo na porta 9999");
    }
    catch (Exception ex) {
      System.out.println("error: " + ex.getMessage());
      ex.printStackTrace();
    }
}
}
