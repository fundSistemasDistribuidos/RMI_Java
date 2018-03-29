import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/*
Classname: Server
Purpose: The RMI server.
*/
public class Server extends UnicastRemoteObject implements Calc {

public Server() throws RemoteException {}

// Remote method
public Integer calc(String op, Integer op1, Integer op2) {
    Integer resp = 0;

    System.out.println("Iniciando Cálculo!");
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
      Integer port = 9999;

      // Creates an object of the Server class.
      Server obj = new Server();
      Registry registry = LocateRegistry.getRegistry(port);
      registry.bind("Calc", obj);


      System.out.println("Ouvindo na porta " + port);
    }
    catch (Exception ex) {
      System.out.println("error: " + ex.getMessage());
      ex.printStackTrace();
    }
}
}
