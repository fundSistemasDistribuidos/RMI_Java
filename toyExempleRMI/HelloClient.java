
import java.rmi.Naming;
import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/*
Classname: HelloClient
Comment: The RMI client.
*/
public class HelloClient {

// The Hello object "obj" is the identifier that is




public static void main(String args[]){

  // String message = "blank";
  String host = (args.length < 1) ? null : args[0];
  try {

    Registry registry = LocateRegistry.getRegistry(host);
     Hello stub = (Hello) registry.lookup("Hello");
     String response = stub.sayHello();
     System.out.println("response: " + response);
      // Hello obj = (Hello)Naming.lookup("//" + "kvist.cs.umu.se"+ "/Hello");
      // // message = obj.Hello();
      // System.out.println("Mensagem no servidor RMI de: \"" + obj.sayHello() + "\"");
    }
    catch (Exception e) {
      System.out.println("HelloClient exception: "
      + e.getMessage());
      e.printStackTrace();
    }
  }
}
