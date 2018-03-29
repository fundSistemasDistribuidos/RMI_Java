
import java.rmi.Naming;
import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/*
Classname: HelloClient
Comment: The RMI client.
*/
public class Client {

  public static void main(String args[]){
    try {

      Registry registry = LocateRegistry.getRegistry(9999);
      Calc stub = (Calc) registry.lookup("Calc");
      Integer response = stub.calc("+", 50, 10);
      System.out.println("response: " + response);
    }
    catch (Exception e) {
        System.out.println("Client exception: "
        + e.getMessage());
        e.printStackTrace();
    }
  }
}
