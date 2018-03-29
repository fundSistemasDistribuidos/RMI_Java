import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
Classname: Client
Comment: The RMI client.
*/
public class Client {

  public static void main(String args[]){
    try {
      String serverIP = "192.168.25.158";
      Integer port = 9999;

      Registry registry = LocateRegistry.getRegistry(serverIP, port);
      Calc stub = (Calc) registry.lookup("Calc");

      //Execute remote method
      Integer response = stub.calc("+", 50, 10);
      System.out.println("50 + 10 = " + response);

      response = stub.calc("-", 50, 10);
      System.out.println("50 - 10 = " + response);

      response = stub.calc("*", 50, 10);
      System.out.println("50 * 10 = " + response);

      response = stub.calc("/", 50, 10);
      System.out.println("50 / 10 = " + response);

    }
    catch (Exception e) {
        System.out.println("Client exception: "
        + e.getMessage());
        e.printStackTrace();
    }
  }
}
